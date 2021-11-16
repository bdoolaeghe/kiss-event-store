package org.kiss.es.library.infra;

import org.kiss.es.api.EventStore;
import org.kiss.es.impl.AbstractDbRepository;
import org.kiss.es.library.domain.Book;
import org.kiss.es.library.domain.BookEvent;
import org.kiss.es.library.domain.Reference;
import org.springframework.stereotype.Repository;

import static org.kiss.es.library.domain.Reference.reference;
import static java.util.Collections.emptyList;

@Repository
public class BookDbRepository extends AbstractDbRepository<Reference, Book, BookEvent> {

    public BookDbRepository(EventStore<Reference, BookEvent> es) {
        super(es);
    }

    @Override
    protected Reference newEntityId() {
        return reference(super.generateEntityId());
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
