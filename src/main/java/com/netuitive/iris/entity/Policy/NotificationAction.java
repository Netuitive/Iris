package com.netuitive.iris.entity.Policy;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Wither;

/**
 *
 * @author john.king
 */
@Data
@Wither
@EqualsAndHashCode(callSuper = true)
public class NotificationAction extends PolicyAction {

    private Long id;
    private boolean enabled;
    private int notifyFrequencyMin;
    private boolean sendOnClear;

    public NotificationAction() {
    }

    public NotificationAction(Long id, boolean enabled, int notifyFrequencyMin, boolean sendOnClear) {
        this.id = id;
        this.enabled = enabled;
        this.notifyFrequencyMin = notifyFrequencyMin;
        this.sendOnClear = sendOnClear;
    }
    
    
}
