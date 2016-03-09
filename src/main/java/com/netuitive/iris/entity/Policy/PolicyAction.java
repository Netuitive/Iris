package com.netuitive.iris.entity.Policy;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 *
 * @author john.king
 */
@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include= JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({
	@JsonSubTypes.Type(name="notification", value=NotificationAction.class),
    @JsonSubTypes.Type(name="event", value=EventAction.class) })
public abstract class PolicyAction {

}
