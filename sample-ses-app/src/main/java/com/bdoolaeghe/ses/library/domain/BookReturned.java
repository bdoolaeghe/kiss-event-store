package com.bdoolaeghe.ses.library.domain;

import com.bdoolaeghe.util.Util;
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
