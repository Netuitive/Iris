package com.netuitive.iris.entity.Policy;

import java.util.Map;
import lombok.Data;

/**
 *
 * @author john.king
 */
@Data
public class PolicyScope {

    private String elementName;
    private String elementType;
    private Map<String, String> elementTags;
}
