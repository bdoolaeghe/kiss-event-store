package com.bdoolaeghe.ses.impl;

import com.bdoolaeghe.ses.configuration.TestDbEventStoreConfiguration;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        TestDbEventStoreConfiguration.class
})
@Transactional
class DBEventStoreIT {

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
