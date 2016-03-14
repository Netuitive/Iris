package com.netuitive.iris.entity.Policy;

import com.netuitive.iris.entity.Policy.PolicyAction;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author john.king
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class EventAction extends PolicyAction {

	private Integer category;

	public EventAction() {
		
	}
	
	public EventAction(Integer category) {
		this.category = category;
	}
}
