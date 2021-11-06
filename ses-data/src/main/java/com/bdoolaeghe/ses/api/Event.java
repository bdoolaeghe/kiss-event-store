package com.bdoolaeghe.ses.api;

public interface Event<ENTITY> {
    ENTITY applyOn(ENTITY entity);
}
