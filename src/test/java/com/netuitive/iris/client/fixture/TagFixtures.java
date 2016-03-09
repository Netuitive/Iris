package com.netuitive.iris.client.fixture;

import com.netuitive.iris.entity.Tag;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author john.king
 */
public class TagFixtures {

    public static Tag getEventTag(){
        return new Tag("Iris Event Tag Name", "Iris Event Tag Value"); 
    }
    
    public static Tag getMetricTag(){
        return new Tag("Iris Metric Tag Name", "Iris Metric Tag Value"); 
    }
    
    public static Map<String,String> getElementTagMap(){
        Map<String,String> tags = new HashMap<String, String>();
        tags.put("Iris Element Tag Name", "Iris Element Tag Value");
        return tags;
    }
    public static Map<String,String> getUpdatedElementTagMap(){
        Map<String,String> tags = new HashMap<String, String>();
        tags.put("Iris Element Tag Name", "Iris Element Tag Value1");
        return tags;
    }
    public static Map<String,String> getMetricTagMap(){
        Map<String,String> tags = new HashMap<String, String>();
        tags.put("Iris Metric Tag Name", "Iris Metric Tag Value");
        return tags;
    }
    public static Map<String,String> getUpdatedMetricTagMap(){
        Map<String,String> tags = new HashMap<String, String>();
        tags.put("Iris Metric Tag Name", "Iris Metric Tag Value1");
        return tags;
    }
}
