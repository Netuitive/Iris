package com.netuitive.iris.entity.wrapper;

import com.netuitive.iris.entity.MetricResults;
import lombok.Data;

/**
 *
 * @author john.king
 */
@Data
public class MetricResultsWrapper {

    private Iterable<MetricResults> samples;
    
}
