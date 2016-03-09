package com.netuitive.iris.client.request;

import com.netuitive.iris.client.utils.HttpMethod;
import java.util.Map;
import lombok.Data;
import lombok.experimental.Wither;

/**
 *
 * @author john.king
 */
@Data
@Wither
public class GenericRequest{

    HttpMethod method;
    String path;
    Map<String, Object> params;
    Object body;
    Class returnType;
    Map<String, String> headers;
    public GenericRequest(HttpMethod method, String path) {
        this.method = method;
        this.path = path;
    }

    public GenericRequest(HttpMethod method, String path, Map<String, Object> params, Object body, Class returnType, Map<String, String> headers) {
        this.method = method;
        this.path = path;
        this.params = params;
        this.body = body;
        this.returnType = returnType;
        this.headers = headers;
    }
    
}
