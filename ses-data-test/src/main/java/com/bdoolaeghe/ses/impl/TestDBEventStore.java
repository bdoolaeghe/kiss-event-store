package com.bdoolaeghe.ses.impl;

import com.bdoolaeghe.ses.api.EntityId;
import com.bdoolaeghe.ses.api.Event;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

//@Repository
public class TestDBEventStore<ENTITY_ID extends EntityId, EVENT_TYPE extends Event<?>> extends DBEventStore<ENTITY_ID, EVENT_TYPE> {

    private static final String TRUNCATE_ENTITY = "TRUNCATE entity";
    private static final String TRUNCATE_EVENT = "TRUNCATE event";

    public TestDBEventStore(DataSource dataSource) {
        super(dataSource);
    }

    public void clear() {
        jdbcTemplate.execute(TRUNCATE_ENTITY);
        jdbcTemplate.execute(TRUNCATE_EVENT);
    }

}
