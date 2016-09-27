package com.netuitive.iris.entity.Policy;

import lombok.Data;
import lombok.experimental.Wither;

/**
 *
 * @author john.king
 */
@Data
@Wither
public class PolicyEventCondition {

    String messageRegex;
    String titleRegex;
    String sourceRegex;
    String level;

    public PolicyEventCondition() {
    }

    public PolicyEventCondition(String messageRegex, String titleRegex, String sourceRegex, String level) {
        this.messageRegex = messageRegex;
        this.titleRegex = titleRegex;
        this.sourceRegex = sourceRegex;
        this.level = level;
    }
    
    
}
