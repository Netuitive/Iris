package com.netuitive.iris.entity;

/**
 * @author John King
 */
public enum SparseDataStrategy {

    None,
    ReplaceWithZero,
    ReplaceWithLast,
    ReplaceWithHistoricalMax,
    ReplaceWithHistoricalMin
}
