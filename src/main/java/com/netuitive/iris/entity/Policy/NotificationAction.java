package com.netuitive.iris.entity.Policy;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author john.king
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NotificationAction extends PolicyAction {

    private Long id;
    private boolean enabled = true;
}
