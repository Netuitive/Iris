package com.netuitive.iris.client.exception;

/**
 *
 * @author john.king
 */
public class RequestException extends RuntimeException{

    public RequestException(String message) {
        super(message);
    }

    public RequestException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public RequestException(Exception ex){
        super(ex);
    }
}
