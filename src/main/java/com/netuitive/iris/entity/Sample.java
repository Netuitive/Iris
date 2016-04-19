
package com.netuitive.iris.entity;

import lombok.Data;

import java.util.Date;
/**
 * @author John King
 */
@Data
public class Sample {

    private String metricId;
    private Date timestamp;
    private Double val;
    private Double min;
    private Double max;
    private Double avg;
    private Double sum;
    private Double cnt;


}
