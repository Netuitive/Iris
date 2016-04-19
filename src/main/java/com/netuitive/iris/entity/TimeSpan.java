package com.netuitive.iris.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author john.king
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeSpan {

    private Date startTime;
    private Date endTime;
    
    public Duration getDuration() {
		return Duration.of((endTime.getTime() - startTime.getTime()), ChronoUnit.MILLIS);
	}
}
