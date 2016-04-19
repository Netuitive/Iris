package com.netuitive.iris.entity.wrapper;

import com.netuitive.iris.entity.Attribute;
import com.netuitive.iris.entity.Element;
import com.netuitive.iris.entity.Relation;
import com.netuitive.iris.entity.Sample;
import com.netuitive.iris.entity.Tag;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import lombok.Data;

/**
 *
 * @author john.king
 */
@Data
public class ElementDecorator {

    private Element element;
    private Set<MetricDecorator> metrics;
    private String tenantId;
    private String id;
    private String fqn;
    private String name;
    private String type;
    private String location;
    private Date lastProcessed;
    private Set<Attribute> attributes;
    private Set<Tag> tags;
    private Set<Relation> relations;
    private Set<Sample> samples;
    private Map<String, String> netuitiveTags = new TreeMap<String, String>();
    private Map<String, String> sourceTags = new TreeMap<String, String>();
}
