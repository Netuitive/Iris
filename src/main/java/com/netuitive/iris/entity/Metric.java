package com.netuitive.iris.entity;

import lombok.Data;
import java.util.Set;
import lombok.experimental.Wither;

/**
 * @author John King
 */
@Data
@Wither
public class Metric {

    private Long dataSourceId;
    private String id;
    private String fqn;
    private String name;
    private String unit;
    private String type;
    private SparseDataStrategy sparseDataStrategy;
    private Set<Tag> tags;

    public Metric(Long dataSourceId, String id, String fqn, String name, String unit, String type, SparseDataStrategy sparseDataStrategy, Set<Tag> tags) {
        this.dataSourceId = dataSourceId;
        this.id = id;
        this.fqn = fqn;
        this.name = name;
        this.unit = unit;
        this.type = type;
        this.sparseDataStrategy = sparseDataStrategy;
        this.tags = tags;
    }

    public Metric() {
    }
    
    
}
