package com.bdoolaeghe.ses.library.infra;

import com.bdoolaeghe.ses.api.EventStore;
import com.bdoolaeghe.ses.impl.AbstractDbRepository;
import com.bdoolaeghe.ses.library.domain.Book;
import com.bdoolaeghe.ses.library.domain.BookEvent;
import com.bdoolaeghe.ses.library.domain.Reference;
import org.springframework.stereotype.Repository;

import static java.util.Collections.emptyList;

@Repository
public class BookDbRepository extends AbstractDbRepository<Reference, Book, BookEvent> {

    public BookDbRepository(EventStore<Reference, BookEvent> es) {
        super(es);
    }

    @Override
    protected Reference newEntityId() {
        return Reference.reference(super.generateEntityId());
    }

    @Override
    protected Book create(Reference reference, int version) {
        return new Book(reference,
                null,
                true,
                null,
                emptyList(),
                version);
    }
}
