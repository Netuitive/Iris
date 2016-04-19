package com.netuitive.iris.entity;

import lombok.Data;

/**
 * @author John King
 */
@Data
public class Attribute {

    private String id;
    private Long dataSourceId;
    private String name;
    private String value;
    private AttributeType attributeType;
}
