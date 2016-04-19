
package com.netuitive.iris.client.policy;

import com.netuitive.iris.client.request.policy.NumberOfEventsByPolicyRequest;
import com.netuitive.iris.entity.wrapper.PoliciesWrapper;
import com.netuitive.iris.entity.wrapper.PolicyWrapper;

/**
 *
 * @author john.king
 */
public interface NetuitivePolicyClient {

    public void delete(String policyId);

    public Integer getNumberOfEventsByPolicy(NumberOfEventsByPolicyRequest req);

    public PoliciesWrapper list();

    public PolicyWrapper get(String policyId);

    public PolicyWrapper create(PolicyWrapper policy);

    public PolicyWrapper update(String policyId, PolicyWrapper policy);
}
