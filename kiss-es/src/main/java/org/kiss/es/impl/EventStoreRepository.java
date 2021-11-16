package org.kiss.es.impl;

import org.kiss.es.api.EntityId;
import org.kiss.es.api.Event;
import org.kiss.es.api.Entity;

public interface EventStoreRepository<ENTITY_ID extends EntityId, ENTITY extends Entity<ENTITY_ID, EVENT_TYPE>, EVENT_TYPE extends Event<ENTITY>> {
    ENTITY load(ENTITY_ID entityId);
    ENTITY save(ENTITY entity);
}
