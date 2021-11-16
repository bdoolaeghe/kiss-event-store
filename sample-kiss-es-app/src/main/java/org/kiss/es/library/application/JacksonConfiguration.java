package org.kiss.es.library.application;

import org.kiss.es.library.domain.BookEvent;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@Configuration
public class JacksonConfiguration {

    @JsonTypeInfo(include= As.WRAPPER_OBJECT, use= Id.NAME)
    private abstract class BookEventMixin {}

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        var mapper =  new ObjectMapper();
        // just for better readability in sample REST responses
        mapper.addMixIn(BookEvent.class, BookEventMixin.class);
        return mapper;
    }

}
