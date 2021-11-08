package com.bdoolaeghe.ses.library.domain;

import com.bdoolaeghe.ses.api.DecisionFunction;
import com.bdoolaeghe.ses.api.Entity;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.List;

import static java.util.Collections.emptyList;

@Value
@RequiredArgsConstructor
@Builder(toBuilder = true)
public class Book implements Entity<Reference, BookEvent> {

    Reference reference;
    String title;
    boolean isAvailable;
    String borrower;

    List<BookEvent> events;
    int version;

    public static Book create() {
        return new Book(null,
                null,
                true,
                null,
                emptyList(),
                0);
    }

    public List<BookEvent> getEvents() {
        return events;
    }

    @Override
    public Reference getId() {
        return reference;
    }

    @DecisionFunction
    public Book registerAs(String title) {
        if (this.title != null) {
            throw new UnsupportedOperationException("can not change title '" + this.title + "' with ' title '" + title + "'");
        }
        return new BookRegistered(title).applyOn(this);
    }

    @DecisionFunction
    public Book borrow(String borrower) {
        if (this.title == null) {
            throw new UnsupportedOperationException("can not borrow book '" + this.reference + "' as it's not registered yet");
        }
        if (! this.isAvailable) {
            throw new UnsupportedOperationException("can not borrow book '" + this.title + "' as it's already borrowed by '" +
                                                    this.borrower + "'");
        }
        return new BookBorrowed(borrower).applyOn(this);
    }

    @DecisionFunction
    public Book returnBook() {
        if (this.title == null) {
            throw new UnsupportedOperationException("can not return book '" + this.reference + "' as it's not registered yet");
        }
        if (this.isAvailable) {
            throw new UnsupportedOperationException("can not return book '" + this.title + "' as it's not borrowed yet");
        }

        return new BookReturned().applyOn(this);
    }

}
