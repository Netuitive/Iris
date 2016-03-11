package com.netuitive.iris.client.element;

import com.netuitive.iris.client.BasicAuthRestClient;
import com.netuitive.iris.client.request.GenericRequest;
import com.netuitive.iris.client.request.element.GetMetricMetaDataRequest;
import com.netuitive.iris.client.request.element.GetMetricResultsRequest;
import com.netuitive.iris.client.request.element.ListElementsRequest;
import com.netuitive.iris.client.request.element.ListEventsRequest;
import com.netuitive.iris.client.utils.HttpMethod;
import com.netuitive.iris.entity.wrapper.ElementWrapper;
import com.netuitive.iris.entity.wrapper.ElementsWrapper;
import com.netuitive.iris.entity.wrapper.EventsWrapper;
import com.netuitive.iris.entity.wrapper.MetricMetasWrapper;
import com.netuitive.iris.entity.wrapper.MetricResultsWrapper;
import com.netuitive.iris.entity.wrapper.PoliciesWrapper;
import com.netuitive.iris.entity.wrapper.TagWrapper;
import com.netuitive.iris.entity.wrapper.TagsWrapper;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author john.king
 */
public class NetuitiveElementRestClient extends BasicAuthRestClient implements NetuitiveElementClient {

    public static final String ELEMENTS_ENDPOINT = "/elements";

    public NetuitiveElementRestClient(String username, String password) {
        super(username, password);
    }

    @Override
    public ElementsWrapper listElements(ListElementsRequest req) {
        String path = ELEMENTS_ENDPOINT + "/";
        Map<String, Object> params = new HashMap<String, Object>();

        if (req.getEndTime() != null) {
            params.put("endTime", req.getEndTime().getTime());
        }
        if (req.getStartTime() != null) {
            params.put("startTime", req.getStartTime().getTime());
        }
        if (req.getFields() != null) {
            params.put("fields", req.getFields());
        }
        if (req.getIds() != null) {
            params.put("ids", req.getIds());
        }
        if (req.getLocation() != null) {
            params.put("location", req.getLocation());
        }
        if (req.getName() != null) {
            params.put("name", req.getName());
        }
        if (req.getTags() != null) {
            params.put("tags", req.getTags());
        }
        if (req.getType() != null) {
            params.put("type", req.getType());
        }
        return this.send(new GenericRequest(HttpMethod.GET, path)
                .withParams(params)
                .withReturnType(ElementsWrapper.class));

    }

    @Override
    public EventsWrapper listEvents(ListEventsRequest req) {
        String path = ELEMENTS_ENDPOINT + "/" + req.getElementId() + "/events/";
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
                .withReturnType(EventsWrapper.class));
    }

    @Override
    public MetricMetasWrapper getMetaDataForMetric(GetMetricMetaDataRequest req) {
        String path = ELEMENTS_ENDPOINT + "/" + req.getElementId() + "/metrics/";
        Map<String, Object> params = new HashMap<String, Object>();
        if (req.getMetricFQN() != null) {
            params.put("metricFQN", req.getMetricFQN());
        }
        return this.send(new GenericRequest(HttpMethod.GET, path)
                .withParams(params)
                .withReturnType(MetricMetasWrapper.class));
    }

    @Override
    public MetricResultsWrapper getMetricResults(GetMetricResultsRequest req) {
        String path = ELEMENTS_ENDPOINT + "/" + req.getElementId() + "/metrics/" + req.getMetricId() + "/samples";
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
        if (req.getRollup() != null) {
            params.put("rollup", req.getRollup());
        }
        return this.send(new GenericRequest(HttpMethod.GET, path)
                .withParams(params)
                .withReturnType(MetricResultsWrapper.class));
    }

    @Override
    public TagWrapper createMetricTag(String elementId, String metricId, TagWrapper tagWrapper) {
        String path = ELEMENTS_ENDPOINT + "/" + elementId + "/metrics/" + metricId + "/tags/";
        return this.send(new GenericRequest(HttpMethod.POST, path)
                .withBody(tagWrapper)
                .withReturnType(TagWrapper.class));
    }

    @Override
    public TagsWrapper getMetricTags(String elementId, String metricId) {
        String path = ELEMENTS_ENDPOINT + "/" + elementId + "/metrics/" + metricId + "/tags";
        return this.send(new GenericRequest(HttpMethod.GET, path)
                .withReturnType(TagsWrapper.class));
    }

    @Override
    public void deleteMetricTag(String elementId, String metricId, String tag) {
        String path = ELEMENTS_ENDPOINT + "/" + elementId + "/metrics/" + metricId + "/tags/" + tag;
        this.send(new GenericRequest(HttpMethod.DELETE, path));
    }

    @Override
    public void updateMetricTag(String elementId, String metricId, String tagName, TagWrapper tagWrapper) {
        String path = ELEMENTS_ENDPOINT + "/" + elementId + "/metrics/" + metricId + "/tags/" + tagName;
        this.send(new GenericRequest(HttpMethod.PUT, path)
                .withBody(tagWrapper));
    }

    @Override
    public PoliciesWrapper getPolicies(String elementId) {
        String path = ELEMENTS_ENDPOINT + "/" + elementId + "/policies";
        return this.send(new GenericRequest(HttpMethod.GET, path)
                .withReturnType(PoliciesWrapper.class));

    }

    @Override
    public TagWrapper createElementTag(String elementId, TagWrapper tagWrapper) {
        String path = ELEMENTS_ENDPOINT + "/" + elementId + "/tags/";
        return this.send(new GenericRequest(HttpMethod.POST, path)
                .withReturnType(TagWrapper.class)
                .withBody(tagWrapper));

    }

    @Override
    public TagsWrapper getElementTags(String elementId) {
        String path = ELEMENTS_ENDPOINT + "/" + elementId + "/tags";
        return this.send(new GenericRequest(HttpMethod.GET, path)
                .withReturnType(TagsWrapper.class));

    }

    @Override
    public void deleteElementTag(String elementId, String tag) {
        String path = ELEMENTS_ENDPOINT + "/" + elementId + "/tags/" + tag;
        this.send(new GenericRequest(HttpMethod.DELETE, path));

    }

    @Override
    public void updateElementTag(String elementId, String tagName, TagWrapper tagWrapper) {
        String path = ELEMENTS_ENDPOINT + "/" + elementId + "/tags/" + tagName;
        this.send(new GenericRequest(HttpMethod.PUT, path)
                .withBody(tagWrapper));

    }

    @Override
    public void deleteElement(String id) {
        String path = ELEMENTS_ENDPOINT + "/" + id;
        this.send(new GenericRequest(HttpMethod.DELETE, path));

    }

    @Override
    public ElementWrapper getElement(String id) {
        String path = ELEMENTS_ENDPOINT + "/" + id;
        return this.send(new GenericRequest(HttpMethod.GET, path)
                .withReturnType(ElementWrapper.class));

    }

}
