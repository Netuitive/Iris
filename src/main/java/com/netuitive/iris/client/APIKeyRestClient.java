package com.netuitive.iris.client;


/**
 *
 * @author john.king
 */
public class APIKeyRestClient extends AbstractRestClient{

    private final String apiKey;

    public APIKeyRestClient(String apiKey) {
        super();
        this.apiKey = apiKey;
    }
    
    public APIKeyRestClient(String scheme, String host, String apiKey) {
        super(scheme, host);
        this.apiKey = apiKey;
    }
    
    public String getApiKey(){
        return apiKey;
    }
}
