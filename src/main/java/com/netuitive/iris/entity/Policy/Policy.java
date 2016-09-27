package com.netuitive.iris.entity.Policy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Collection;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Wither;

/**
 *
 * @author john.king
 */
@Data
@Wither
@JsonInclude(Include.NON_NULL)
public class Policy {

   private String id;
    private String name;
    private String description;
    private PolicyScope scope;
    private Integer duration;
    private Collection<PolicyCondition> conditions;
    private Collection<PolicyEventCondition> eventConditions;
    private Collection<PolicyAction> actions;
    private boolean enabled;
    private boolean deleted;
    private String originTenantId;
    private String originPolicyId;
    private String creatorEmail;
    private Date lastUpdated;

    public Policy() {
    }

    public Policy(String id, String name, String description, PolicyScope scope, Integer duration, Collection<PolicyCondition> conditions, Collection<PolicyEventCondition> eventConditions, Collection<PolicyAction> actions, boolean enabled, boolean deleted, String originTenantId, String originPolicyId, String creatorEmail, Date lastUpdated) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.scope = scope;
        this.duration = duration;
        this.conditions = conditions;
        this.eventConditions = eventConditions;
        this.actions = actions;
        this.enabled = enabled;
        this.deleted = deleted;
        this.originTenantId = originTenantId;
        this.originPolicyId = originPolicyId;
        this.creatorEmail = creatorEmail;
        this.lastUpdated = lastUpdated;
    }
    
    
}
