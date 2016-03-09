package com.netuitive.iris.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Date;
import lombok.Data;

import java.util.Set;

/**
 * @author John King
 */
@Data
@JsonInclude(Include.NON_NULL)
public class Element {

    private String tenantId;
    private String id;
    private String fqn;
    private String name;
    private String type;
    private String location;
    private Date lastProcessed;
    private Set<Attribute> attributes;
    private Set<Tag> tags;
    private Set<Metric> metrics;
    private Set<Relation> relations;
    private Set<Sample> samples;
}
