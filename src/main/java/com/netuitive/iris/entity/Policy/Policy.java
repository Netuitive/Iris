package com.netuitive.iris.entity.Policy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Collection;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author john.king
 */
@Data
@JsonInclude(Include.NON_NULL)
public class Policy {

    private String id;
    private String name;
    private String description;
    private PolicyScope scope;
    private Integer duration;
    private Collection<PolicyCondition> conditions;
    private Collection<PolicyAction> actions;
    private boolean enabled;
    private boolean deleted;
    private String originTenantId;
    private String originPolicyId;
    private Date lastUpdated;
}
