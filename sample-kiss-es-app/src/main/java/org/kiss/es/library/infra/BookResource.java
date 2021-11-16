package org.kiss.es.library.infra;

import org.kiss.es.library.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.kiss.es.library.domain.Reference.reference;

@RestController
@RequestMapping("/books")
public class BookResource {

    private BookDbRepository repository;

    @Autowired
    public BookResource(BookDbRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Book register(@RequestParam String title) {
        var book = Book.create().registerAs(title);
        return repository.save(book);
    }

    @PostMapping("/{reference}/borrow")
    public Book borrow(@PathVariable String reference, @RequestParam String borrower) {
        var book = repository.load(reference(reference));
        return repository.save(book.borrow(borrower));
    }

    @PostMapping("/{reference}/return")
    public Book returnBook(@PathVariable String reference) {
        var book = repository.load(reference(reference));
        return repository.save(book.returnBook());
    }

    @GetMapping("/{reference}")
    public Book findByReference(@PathVariable String reference) {
        return repository.load(reference(reference));
    }





}
