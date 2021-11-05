package com.bdoolaeghe.ses.impl;

import com.bdoolaeghe.ses.api.EntityId;
import com.bdoolaeghe.ses.api.Event;
import com.bdoolaeghe.ses.api.Entity;

public interface EventStoreRepository<ENTITY_ID extends EntityId, ENTITY extends Entity<ENTITY_ID, EVENT_TYPE>, EVENT_TYPE extends Event<ENTITY>> {
    ENTITY load(ENTITY_ID entityId);
    ENTITY save(ENTITY entity);
}
