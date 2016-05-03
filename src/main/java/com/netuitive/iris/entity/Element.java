package com.netuitive.iris.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Date;
import java.util.HashSet;
import lombok.Data;

import java.util.Set;
import lombok.experimental.Wither;

/**
 * @author John King
 */
@Data
@Wither
@JsonInclude(Include.NON_NULL)
public class Element {

    private String tenantId;
    private String id;
    private String fqn;
    private String name;
    private String type;
    private String location;
    private Date lastProcessed;
    private Set<Attribute> attributes = new HashSet<Attribute>();
    private Set<Tag> tags = new HashSet<Tag>();
    private Set<Metric> metrics = new HashSet<Metric>();
    private Set<Relation> relations = new HashSet<Relation>();
    private Set<Sample> samples = new HashSet<Sample>();

    public Element(String tenantId, String id, String fqn, String name, 
            String type, String location, Date lastProcessed, 
            Set<Attribute> attributes, Set<Tag> tags, Set<Metric> metrics, 
            Set<Relation> relations, Set<Sample> samples) {
        this.tenantId = tenantId;
        this.id = id;
        this.fqn = fqn;
        this.name = name;
        this.type = type;
        this.location = location;
        this.lastProcessed = lastProcessed;
        this.attributes = attributes;
        this.tags = tags;
        this.metrics = metrics;
        this.relations = relations;
        this.samples = samples;
    }

    public Element() {
    }
    
    
    public void mergeData(Element from){
        if(from.getMetrics() != null && this.metrics != null){
            for(Metric metric : this.metrics){
                for(Metric fromMetric : from.getMetrics()){
                    if(!fromMetric.getId().equals(metric.getId())){
                        this.metrics.add(fromMetric);
                    }
                }
            }
        }
        if(this.samples != null && from.getSamples() != null){
            this.samples.addAll(from.getSamples());
        }
    }
}
