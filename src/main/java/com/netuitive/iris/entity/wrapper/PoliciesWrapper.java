package com.netuitive.iris.entity.wrapper;

import com.netuitive.iris.entity.Policy.Policy;
import lombok.Data;

/**
 *
 * @author john.king
 */
@Data
public class PoliciesWrapper {

    private Iterable<Policy> policies;
}
