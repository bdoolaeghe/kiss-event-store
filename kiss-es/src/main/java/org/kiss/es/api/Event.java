package org.kiss.es.api;

public interface Event<ENTITY> {
    ENTITY applyOn(ENTITY entity);
}
