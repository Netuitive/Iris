package com.netuitive.iris.client.request.policy;

import java.time.Duration;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Wither;

/**
 *
 * @author john.king
 */
@Data
@Wither
public class NumberOfEventsByPolicyRequest {

    String policyId;

    Duration duration;
    Date startTime;
    Date endTime;

    public NumberOfEventsByPolicyRequest(String policyId) {
        this.policyId = policyId;
    }

    public NumberOfEventsByPolicyRequest(String policyId, Duration duration, Date startTime, Date endTime) {
        this.policyId = policyId;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
