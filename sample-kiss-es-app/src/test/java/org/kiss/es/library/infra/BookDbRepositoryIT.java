package org.kiss.es.library.infra;

import org.junit.jupiter.api.Test;
import org.kiss.es.library.domain.Book;
import org.kiss.es.library.domain.BookBorrowed;
import org.kiss.es.library.domain.BookRegistered;
import org.kiss.es.library.infra.configuration.TestDbEventStoreConfiguration;
import org.kiss.es.library.infra.configuration.TestDbEventStoreConfiguration.DockerPostgresDatasourceInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
@ContextConfiguration(
        classes = TestDbEventStoreConfiguration.class,
        initializers = DockerPostgresDatasourceInitializer.class
)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@EnableAutoConfiguration
@Testcontainers
class BookDbRepositoryIT {

    @Autowired
    BookDbRepository repository;

    @Test
    void should_save_and_reload_an_entity() {
        // Given
        Book e = Book.create()
                .registerAs("the title");

        // When
        Book savedEntity = repository.save(e);
        Book reloadedEntity = repository.load(savedEntity.getId());

        // Then
        assertThat(reloadedEntity).isEqualToIgnoringGivenFields(e, "reference", "version");
        assertThat(reloadedEntity.getId()).isNotNull();

        // When
        Book borrowedBook = reloadedEntity.borrow("mike");
        savedEntity = repository.save(borrowedBook);
        reloadedEntity = repository.load(savedEntity.getId());

        // Then
        assertThat(reloadedEntity).isEqualToIgnoringGivenFields(borrowedBook, "version");
        assertThat(reloadedEntity.getEvents())
                .hasOnlyElementsOfTypes(
                        BookRegistered.class,
                        BookBorrowed.class
                );
    }

}
