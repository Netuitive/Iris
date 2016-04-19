package com.netuitive.iris.entity;

import lombok.Data;

/**
 * @author John King
 */
@Data
public class Tag {

    private String name;
    private String value;

    public Tag(String name, String value) {
        this.name = name;
        this.value = value;
    }
    
    
}
