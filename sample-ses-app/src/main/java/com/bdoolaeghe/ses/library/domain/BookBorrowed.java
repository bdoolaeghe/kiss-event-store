package com.bdoolaeghe.ses.library.domain;

import com.bdoolaeghe.util.Util;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class BookBorrowed implements BookEvent {

    private String borrower;

    @Override
    public Book applyOn(Book book) {
        return book.toBuilder()
                .borrower(borrower)
                .isAvailable(false)
                .events(Util.append(book.getEvents(), this))
                .build();
    }

}
