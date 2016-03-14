package com.netuitive.iris.client.policy;

import com.netuitive.iris.client.BasicAuthRestClient;
import com.netuitive.iris.client.request.GenericRequest;
import com.netuitive.iris.client.request.policy.NumberOfEventsByPolicyRequest;
import com.netuitive.iris.client.utils.HttpMethod;
import com.netuitive.iris.entity.wrapper.PoliciesWrapper;
import com.netuitive.iris.entity.wrapper.PolicyWrapper;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author john.king
 */
public class NetuitivePolicyRestClient extends BasicAuthRestClient implements NetuitivePolicyClient {
    
    public static final String POLICIES_ENDPOINT = "/policies";
    
    public NetuitivePolicyRestClient(String username, String password) {
        super(username, password);
    }
    
    @Override
    public void delete(String policyId) {
        String path = POLICIES_ENDPOINT + "/" + policyId;
        this.send(new GenericRequest(HttpMethod.DELETE, path));
    }
    
    @Override
    public Integer getNumberOfEventsByPolicy(NumberOfEventsByPolicyRequest req) {
        String path = POLICIES_ENDPOINT + "/" + req.getPolicyId() + "/events";
        Map<String, Object> params = new HashMap<String, Object>();
        if (req.getDuration() != null) {
            params.put("duration", req.getDuration());
        }
        if (req.getEndTime() != null) {
            params.put("endTime", req.getEndTime().getTime());
        }
        if (req.getStartTime() != null) {
            params.put("startTime", req.getStartTime().getTime());
        }
        return this.send(new GenericRequest(HttpMethod.GET, path)
                .withParams(params)
                .withReturnType(Integer.class));
    }
    
    @Override
    public PoliciesWrapper list() {
        String path = POLICIES_ENDPOINT;
        return this.send(new GenericRequest(HttpMethod.GET, path)
                .withReturnType(PoliciesWrapper.class));
    }
    
    @Override
    public PolicyWrapper get(String policyId) {
        String path = POLICIES_ENDPOINT + "/" + policyId;
        return this.send(new GenericRequest(HttpMethod.GET, path)
                .withReturnType(PolicyWrapper.class));
    }
    
    @Override
    public PolicyWrapper create(PolicyWrapper policy) {
        String path = POLICIES_ENDPOINT;
        return this.send(new GenericRequest(HttpMethod.POST, path)
                .withBody(policy)
                .withReturnType(PolicyWrapper.class));
    }
    
    @Override
    public PolicyWrapper update(String policyId, PolicyWrapper policy) {
        String path = POLICIES_ENDPOINT + "/" + policyId;
        return this.send(new GenericRequest(HttpMethod.PUT, path)
                .withBody(policy)
                .withReturnType(PolicyWrapper.class));
    }
    
}
