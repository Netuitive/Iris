package com.netuitive.iris.cache;

import com.netuitive.iris.entity.Element;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 *
 * @author john.king
 */
public class ElementCache {

    private final Object MAP_LOCK;

    private ConcurrentMap<String, Element> elements;

    public ElementCache() {
        MAP_LOCK = new Object();
        elements = new ConcurrentHashMap<String, Element>();
    }

    public List<Element> clear() {
        synchronized (MAP_LOCK) {
            List<Element> values = new ArrayList<Element>(elements.values());
            elements = new ConcurrentHashMap<String, Element>();
            return values;
        }
    }

    public List<Element> getElements() {
        synchronized (MAP_LOCK) {
            return new ArrayList<Element>(elements.values());
        }
    }

    public void addElement(Element add) {
        synchronized (MAP_LOCK) {
            Element old = this.elements.get(add.getFqn());
            if (old == null) {
                this.elements.put(add.getFqn(), add);
            }
            else{
                old.mergeData(add);
            }
        }
    }
}
