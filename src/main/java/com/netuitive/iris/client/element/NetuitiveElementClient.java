package com.netuitive.iris.client.element;

import com.netuitive.iris.client.request.element.ListElementsRequest;
import com.netuitive.iris.client.request.element.ListEventsRequest;
import com.netuitive.iris.client.request.element.GetMetricMetaDataRequest;
import com.netuitive.iris.client.request.element.GetMetricResultsRequest;
import com.netuitive.iris.entity.wrapper.ElementWrapper;
import com.netuitive.iris.entity.wrapper.ElementsWrapper;
import com.netuitive.iris.entity.wrapper.EventsWrapper;
import com.netuitive.iris.entity.wrapper.MetricMetasWrapper;
import com.netuitive.iris.entity.wrapper.MetricResultsWrapper;
import com.netuitive.iris.entity.wrapper.PoliciesWrapper;
import com.netuitive.iris.entity.wrapper.TagWrapper;
import com.netuitive.iris.entity.wrapper.TagsWrapper;

/**
 *
 * @author john.king
 */
public interface NetuitiveElementClient {

    public ElementsWrapper listElements(ListElementsRequest req);

    public EventsWrapper listEvents(ListEventsRequest req);

    public MetricMetasWrapper getMetaDataForMetric(GetMetricMetaDataRequest req);

    public MetricResultsWrapper getMetricResults(GetMetricResultsRequest req);

    public TagWrapper createMetricTag(String elementId, String metricId, TagWrapper tagWrapper);

    public TagsWrapper getMetricTags(String elementId, String metricId);

    public void deleteMetricTag(String elementId, String metricId, String tag);

    public void updateMetricTag(String elementId, String metricId, String tagName, TagWrapper tagWrapper);

    public PoliciesWrapper getPolicies(String elementId);

    public TagWrapper createElementTag(String elementId, TagWrapper tagWrapper);

    public TagsWrapper getElementTags(String elementId);

    public void deleteElementTag(String elementId, String tag);

    public void updateElementTag(String elementId, String tagName, TagWrapper tagWrapper);

    public void deleteElement(String id);

    public ElementWrapper getElement( String id);
}
