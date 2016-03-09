package com.netuitive.iris.entity;

import lombok.Data;

/**
 *
 * @author john.king
 */
@Data
public class ResponseTag {

    private String id;
    private Long dataSourceId;
    private String name;
    private String value;
}
