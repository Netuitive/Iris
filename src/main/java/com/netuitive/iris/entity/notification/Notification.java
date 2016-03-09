package com.netuitive.iris.entity.notification;

import java.util.Map;
import lombok.Data;

/**
 *
 * @author john.king
 */
@Data
public class Notification {

    private Long id;
    private boolean enabled;
    private NotificationType type;
    private String tenantId;
    private Map<String, String> properties;
}
