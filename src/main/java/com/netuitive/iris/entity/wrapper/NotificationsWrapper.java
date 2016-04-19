package com.netuitive.iris.entity.wrapper;

import com.netuitive.iris.entity.notification.Notification;
import lombok.Data;

/**
 *
 * @author john.king
 */
@Data
public class NotificationsWrapper {

    private Iterable<Notification> notifications;
}
