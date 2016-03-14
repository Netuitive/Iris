package com.netuitive.iris.client.notification;

import com.netuitive.iris.entity.wrapper.NotificationWrapper;
import com.netuitive.iris.entity.wrapper.NotificationsWrapper;

/**
 *
 * @author john.king
 */
public interface NetuitiveNotificationClient {

    public NotificationWrapper create(NotificationWrapper notificationWrapper);

    public void delete(Long id);

    public NotificationWrapper get(Long id);

    public NotificationsWrapper list();

    public NotificationWrapper update(Long id, NotificationWrapper notificationWrapper);

    public String sendTestNotification(NotificationWrapper notificationWrapper);
}
