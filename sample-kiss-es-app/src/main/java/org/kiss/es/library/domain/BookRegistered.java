package org.kiss.es.library.domain;

import org.kiss.util.Util;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class BookRegistered implements BookEvent {

    private String title;

    @Override
    public Book applyOn(Book book) {
        return book.toBuilder()
                .title(title)
                .events(Util.append(book.getEvents(), this))
                .build();
    }

}
