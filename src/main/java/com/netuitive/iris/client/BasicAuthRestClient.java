package com.netuitive.iris.client;

import com.netuitive.iris.client.request.GenericRequest;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author john.king
 */
public class BasicAuthRestClient extends AbstractRestClient{

    private final String basicAuth;

    public BasicAuthRestClient(String username, String password) {
        super();
        this.basicAuth = contructBasicAuth(username, password);
    }
    
    public BasicAuthRestClient(String scheme, String host, String username, String password) {
        super(scheme, host);
        this.basicAuth = contructBasicAuth(username, password);
    }
    
    private String contructBasicAuth(String username, String password) {
        String authString = username + ":" + password;
        return new String(Base64.getEncoder().encode(authString.getBytes()));
    }
    
    @Override
    public <T> T send(GenericRequest req){
        Map<String, String> headers = req.getHeaders() == null ? new HashMap<String, String>() : req.getHeaders();
        headers.put("Authorization", "Basic " + basicAuth);
        return super.send(req.withHeaders(headers));
    }
}
