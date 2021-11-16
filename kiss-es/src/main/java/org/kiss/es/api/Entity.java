package org.kiss.es.api;

import java.util.List;

public interface Entity<ENTITY_ID, EVENT_TYPE> {
    ENTITY_ID getId();
    List<EVENT_TYPE> getEvents();
    int getVersion();
}
