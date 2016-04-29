package com.netuitive.iris.client.metric;

import com.netuitive.iris.client.BasicAuthRestClient;
import com.netuitive.iris.client.request.GenericRequest;
import com.netuitive.iris.client.request.metric.GetMetricFqnsRequest;
import com.netuitive.iris.client.request.metric.GetMetricStatisticsRequest;
import com.netuitive.iris.client.utils.HttpMethod;
import com.netuitive.iris.entity.wrapper.FqnListWrapper;
import com.netuitive.iris.entity.wrapper.MetricStatisticsWrapper;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author john.king
 */
public class NetuitiveMetricRestClient extends BasicAuthRestClient implements NetuitiveMetricClient {

    public static final String METRICS_ENDPOINT = "/metrics";

    public NetuitiveMetricRestClient(String username, String password) {
        super(username, password);
    }

    public NetuitiveMetricRestClient(String scheme, String host, String username, String password) {
        super(scheme, host, username, password);
    }

    @Override
    public MetricStatisticsWrapper getMetricStatistics(GetMetricStatisticsRequest req) {
        String path = METRICS_ENDPOINT + "/statistics";
        Map<String, Object> params = new HashMap<String, Object>();
        if (req.getShowValues() != null) {
            params.put("showValues", req.getShowValues());
        }
        if (req.getDuration() != null) {
            params.put("duration", req.getDuration());
        }
        if (req.getEndTime() != null) {
            params.put("endTime", req.getEndTime().getTime());
        }
        if (req.getStartTime() != null) {
            params.put("startTime", req.getStartTime().getTime());
        }
        if (req.getFqn() != null) {
            params.put("fqn", req.getFqn());
        }
        if (req.getRollup() != null) {
            params.put("rollup", req.getRollup());
        }
        return this.send(new GenericRequest(HttpMethod.GET, path)
                .withParams(params)
                .withReturnType(MetricStatisticsWrapper.class));
    }

    @Override
    public FqnListWrapper getMetricFqns(GetMetricFqnsRequest req) {
        String path = METRICS_ENDPOINT + "/fqns";
        Map<String, Object> params = new HashMap<String, Object>();
        if (req.getElementAttribute() != null) {
            params.put("elementAttribute", req.getElementAttribute());
        }
        if (req.getElementFqn() != null) {
            params.put("elementFqn", req.getElementFqn());
        }
        if (req.getElementId() != null) {
            params.put("elementId", req.getElementId());
        }
        if (req.getElementName() != null) {
            params.put("elementName", req.getElementName());
        }
        if (req.getElementTag() != null) {
            params.put("elementTag", req.getElementTag());
        }
        if (req.getElementType() != null) {
            params.put("elementType", req.getElementType());
        }
        if (req.getMetricFqn() != null) {
            params.put("metricFqn", req.getMetricFqn());
        }
        if (req.getMetricTag() != null) {
            params.put("metricTag", req.getMetricTag());
        }
        return this.send(new GenericRequest(HttpMethod.GET, path)
                .withParams(params)
                .withReturnType(FqnListWrapper.class));
    }

}
