package com.bdoolaeghe.ses.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class DBEventStoreIT extends AbstractDbIT {

    @Autowired
    DBEventStore<SampleId, SampleEvent> dbEventStore;

    @Test
    void should_create_save_and_reload() {
        // Given
        SampleEntity e = SampleEntity
                .create(SampleId.from("1"), 0)
                .setSampleValue("create this");
        // When
        dbEventStore.store(e.getId(), e.getEvents(), 0);
        List<SampleEvent> reloadedEvents = dbEventStore.loadEvents(e.getId());

        // Then
        Assertions.assertThat(reloadedEvents).isEqualTo(e.getEvents());
    }

}
