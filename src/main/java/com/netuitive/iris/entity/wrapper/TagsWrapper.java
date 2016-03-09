package com.netuitive.iris.entity.wrapper;

import java.util.Map;
import lombok.Data;

/**
 *
 * @author john.king
 */
@Data
public class TagsWrapper {

    private Map<String, String> netuitiveTags;
    private Map<String, String> sourceTags;
}
