package com.netuitive.iris.entity;

import java.time.Duration;
import lombok.Data;

/**
 *
 * @author john.king
 */
@Data
public class MetricResultsRollup {

    private String table;
    private Duration rollupPeriod;
}
