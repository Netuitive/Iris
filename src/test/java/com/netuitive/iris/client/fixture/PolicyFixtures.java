package com.netuitive.iris.client.fixture;

import com.netuitive.iris.entity.Policy.NotificationAction;
import com.netuitive.iris.entity.Policy.Policy;
import com.netuitive.iris.entity.Policy.PolicyAction;
import com.netuitive.iris.entity.Policy.PolicyCondition;
import com.netuitive.iris.entity.Policy.PolicyConditionAnalytic;
import com.netuitive.iris.entity.Policy.PolicyScope;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author john.king
 */
public class PolicyFixtures {

    public static Policy getUpdatedPolicy(Long notificationId){
        Policy policy = getPolicy(notificationId);
        policy.setName("Iris Updated Policy Name");
        return policy;
    }
    public static Policy getPolicy(Long notificationId){
        Policy policy = new Policy();
        policy.setDuration(300);
        policy.setEnabled(true);
        policy.setDescription("Iris Test Policy Description");
        policy.setName("Iris Test Policy Name1");
        policy.setScope(getPolicyScope());
        List<PolicyCondition> conditions = new ArrayList<PolicyCondition>();
        conditions.add(getPolicyCondition());
        policy.setConditions(conditions);
        List<PolicyAction> actions = new ArrayList<PolicyAction>();
        actions.add(getPolicyAction(notificationId));
        policy.setActions(actions);
        return policy;
    }
    
    public static PolicyScope getPolicyScope(){
        PolicyScope scope = new PolicyScope();
        scope.setElementType("Iris Type");
        scope.setElementName("");
        scope.setElementType("");
        return scope;
    }
    
    public static PolicyCondition getPolicyCondition(){
        PolicyCondition condition =  new PolicyCondition();
        condition.setAnalytic(PolicyConditionAnalytic.actual);
        condition.setLevel(0.0);
        condition.setMetric("iris.metric");
        condition.setOperator(">");
        return condition;
    }
    
    public static PolicyAction getPolicyAction(Long notificationId){
        NotificationAction action = new NotificationAction();
        action.setId(notificationId);
        action.setEnabled(false);
        return action;
    }
    
    
}
