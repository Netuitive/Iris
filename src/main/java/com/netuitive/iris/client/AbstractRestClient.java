package com.netuitive.iris.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netuitive.iris.client.exception.RequestException;
import com.netuitive.iris.client.request.GenericRequest;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import lombok.Data;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author john.king
 */
@Data
public class AbstractRestClient {

    public static final String API_HOST = "api.app.netuitive.com";
    public static final String SCHEME = "https";
    public static final String BASE_API_URL = SCHEME + "://" + API_HOST;
    private final ObjectMapper mapper;

    public AbstractRestClient() {
        mapper = new ObjectMapper();
    }

    public <T> T send(GenericRequest genericReq) {
        HttpRequestBase req = null;
        try {
            URIBuilder builder = new URIBuilder();
            builder.setScheme("https").setHost(API_HOST).setPath(genericReq.getPath());
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            if (genericReq.getParams() != null && !genericReq.getParams().isEmpty()) {
                for (Map.Entry<String, Object> entry : genericReq.getParams().entrySet()) {
                    try {
                        String value = entry.getValue() instanceof String ? (String) entry.getValue() : this.getMapper().writeValueAsString(entry.getValue());
                        value = value.replaceAll(" ", "irisspaceplaceholder"); //we replace spaces because currently we expect '%20' instead of '+' on params
                        nvps.add(new BasicNameValuePair(entry.getKey(), value));
                    } catch (JsonProcessingException ex) {
                        throw new RequestException("cannot parse " + entry.getKey(), ex);
                    }
                }
                builder.addParameters(nvps);
            }
            
            String uri = builder.build().toString().replace("irisspaceplaceholder", "%20");
            
            switch (genericReq.getMethod()) {
                case GET:
                    req = new HttpGet(uri);
                    break;
                case POST:
                    req = new HttpPost(builder.build());
                    break;
                case PUT:
                    req = new HttpPut(builder.build());
                    break;
                case DELETE:
                    req = new HttpDelete(builder.build());
                    break;
                default:
                    throw new RequestException("unknown http method");
            }
        } catch (URISyntaxException ex) {
            throw new RequestException(ex);
        }
        if (genericReq.getHeaders() != null) {
            for (Map.Entry<String, String> entry : genericReq.getHeaders().entrySet()) {
                req.addHeader(entry.getKey(), entry.getValue());
            }
        }
        if (genericReq.getBody() != null && req instanceof HttpEntityEnclosingRequestBase) {
            setEntity((HttpEntityEnclosingRequestBase) req, genericReq.getBody());
            
        }
        return this.request((Class<T>)genericReq.getReturnType(), req);
    }
    

    private void setEntity(HttpEntityEnclosingRequestBase req, Object obj) {
        try {
            req.setEntity(new StringEntity(mapper.writeValueAsString(obj)));
            req.setHeader(new BasicHeader("Content-Type", "application/json"));
        } catch (JsonProcessingException ex) {
            throw new RequestException("unable to parse request body", ex);
        } catch (UnsupportedEncodingException ex) {
            throw new RequestException("unable to parse request body", ex);
        }
    }

    public <T> T request(Class<T> retType, HttpRequestBase req) {
        CloseableHttpClient client = null;
        try {
            client = HttpClientBuilder.create().build();
            try {
                HttpResponse response = client.execute(req);
                int status = response.getStatusLine().getStatusCode();
                if (status < 200 || status > 299) {
                    StringWriter writer = new StringWriter();
                    IOUtils.copy(response.getEntity().getContent(), writer);
                    throw new RequestException(
                            "request returned a status code of: " + status
                            + " with a message of: " + response.getStatusLine().getReasonPhrase() 
                            + ": " + writer.toString());
                }
                if (retType == null) {
                    return null;
                }
                StringWriter writer = new StringWriter();
                IOUtils.copy(response.getEntity().getContent(), writer);
                String ret = writer.toString();
                if(retType.equals(String.class)){
                   return (T) ret; //we do this here in case we need to return a json object as a string. 
                }
                return ret == null || ret.isEmpty() ? null : mapper.readValue(writer.toString(), retType);
            } catch (IOException ex) {
                throw new RequestException(ex);
            }
        } finally {
            if (client != null) {
                try {
                    client.close();
                } catch (IOException ex) {
                    throw new RequestException("unable to close http client", ex);
                }
            }
        }
    }
}
