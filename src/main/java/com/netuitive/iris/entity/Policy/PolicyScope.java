package com.netuitive.iris.entity.Policy;

import java.util.Map;
import java.util.Set;
import lombok.Data;
import lombok.experimental.Wither;

/**
 *
 * @author john.king
 */
@Data
@Wither
public class PolicyScope {

    private String elementName;
    private String elementNameExclude;
    private Set<String> fqnIncludes;
    private Set<String> fqnExcludes;
    private String elementType;
    private Map<String, String> elementTags;

    public PolicyScope() {
    }

    public PolicyScope(String elementName, String elementNameExclude, Set<String> fqnIncludes, Set<String> fqnExcludes, String elementType, Map<String, String> elementTags) {
        this.elementName = elementName;
        this.elementNameExclude = elementNameExclude;
        this.fqnIncludes = fqnIncludes;
        this.fqnExcludes = fqnExcludes;
        this.elementType = elementType;
        this.elementTags = elementTags;
    }
}
