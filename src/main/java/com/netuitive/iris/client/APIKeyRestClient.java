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
    
    public String getApiKey(){
        return apiKey;
    }
}
