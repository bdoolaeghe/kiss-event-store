package org.kiss.es.library.domain;

import org.kiss.util.Util;
import lombok.*;

@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class BookReturned implements BookEvent {

    @Override
    public Book applyOn(Book book) {
        return book.toBuilder()
                .borrower(null)
                .isAvailable(true)
                .events(Util.append(book.getEvents(), this))
                .build();
    }

}
