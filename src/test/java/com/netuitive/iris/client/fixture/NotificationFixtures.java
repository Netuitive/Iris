package com.netuitive.iris.client.fixture;

import com.netuitive.iris.entity.notification.Notification;
import com.netuitive.iris.entity.notification.NotificationType;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author john.king
 */
public class NotificationFixtures {

    public static Notification getNotification(){
        Notification notification = new Notification();
        notification.setEnabled(true);
        notification.setType(NotificationType.email);
        notification.setProperties(getProperties());
        return notification;
    }
    
    public static Notification getUpdatedNotification(Long id){
        Notification notification = getNotification();
        notification.setProperties(getUpdatedProperties());
        notification.setId(id);
        return notification;
    }
    
    public static Map<String, String> getProperties(){
        Map<String, String> properties = new HashMap<String,String>();
        properties.put("templateType", "default");
        properties.put("address", System.getProperty("email"));
        properties.put("bodyTemplate", "Iris Notification Body");
        properties.put("subjectTemplate", "Iris Notification Subject");
        return properties;
    }
    public static Map<String, String> getUpdatedProperties(){
        Map<String, String> properties = getProperties();
        properties.put("bodyTemplate", "Iris Updated Notification Body");
        return properties;
    }
}
