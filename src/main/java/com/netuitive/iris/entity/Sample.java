
package com.netuitive.iris.entity;

import lombok.Data;

import java.util.Date;
import lombok.experimental.Wither;
/**
 * @author John King
 */
@Data
@Wither
public class Sample {

    private String metricId;
    private Date timestamp;
    private Double val;
    private Double min;
    private Double max;
    private Double avg;
    private Double sum;
    private Double cnt;

    public Sample(String metricId, Date timestamp, Double val, Double min, Double max, Double avg, Double sum, Double cnt) {
        this.metricId = metricId;
        this.timestamp = timestamp;
        this.val = val;
        this.min = min;
        this.max = max;
        this.avg = avg;
        this.sum = sum;
        this.cnt = cnt;
    }

    public Sample() {
    }

    public Sample(String metricId, Date timestamp, Double val) {
        this.metricId = metricId;
        this.timestamp = timestamp;
        this.val = val;
    }


}
