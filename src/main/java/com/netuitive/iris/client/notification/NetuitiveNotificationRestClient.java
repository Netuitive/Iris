package com.netuitive.iris.client.notification;

import com.netuitive.iris.client.BasicAuthRestClient;
import com.netuitive.iris.client.request.GenericRequest;
import com.netuitive.iris.client.utils.HttpMethod;
import com.netuitive.iris.entity.wrapper.NotificationWrapper;
import com.netuitive.iris.entity.wrapper.NotificationsWrapper;

/**
 *
 * @author john.king
 */
public class NetuitiveNotificationRestClient extends BasicAuthRestClient implements NetuitiveNotificationClient {
    
    public static final String ELEMENTS_ENDPOINT = "/notifications";
    
    public NetuitiveNotificationRestClient(String username, String password) {
        super(username, password);
    }
    
    @Override
    public NotificationWrapper create(NotificationWrapper notificationWrapper) {
        String path = ELEMENTS_ENDPOINT + "/";
        return this.send(new GenericRequest(HttpMethod.POST, path)
                .withBody(notificationWrapper)
                .withReturnType(NotificationWrapper.class));
    }
    
    @Override
    public void delete(Long id) {
        String path = ELEMENTS_ENDPOINT + "/" + id;
        this.send(new GenericRequest(HttpMethod.DELETE, path));
    }
    
    @Override
    public NotificationWrapper get(Long id) {
        String path = ELEMENTS_ENDPOINT + "/" + id;
        return this.send(new GenericRequest(HttpMethod.GET, path)
                .withReturnType(NotificationWrapper.class));
    }
    
    @Override
    public NotificationsWrapper list() {
        String path = ELEMENTS_ENDPOINT;
        return this.send(new GenericRequest(HttpMethod.GET, path)
                .withReturnType(NotificationsWrapper.class));
    }
    
    @Override
    public NotificationWrapper update(Long id, NotificationWrapper notificationWrapper) {
        String path = ELEMENTS_ENDPOINT + "/" + id;
        return this.send(new GenericRequest(HttpMethod.PUT, path)
                .withBody(notificationWrapper)
                .withReturnType(NotificationWrapper.class));
    }
    
    @Override
    public String sendTestNotification(NotificationWrapper notificationWrapper) {
        String path = ELEMENTS_ENDPOINT + "/test";
        return this.send(new GenericRequest(HttpMethod.POST, path)
                .withBody(notificationWrapper)
                .withReturnType(String.class));
    }
    
}
