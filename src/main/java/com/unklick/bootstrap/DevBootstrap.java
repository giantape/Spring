package com.unklick.bootstrap;

import com.unklick.model.Author;
import com.unklick.model.Book;
import com.unklick.repositories.AuthorRepository;
import com.unklick.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initializedData();
    }

    private void initializedData(){
        Author author1 = new Author("Giant", "Ape");
        Book book1 = new Book("Spring Boot", "1234", "Fischer");
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        authorRepository.save(author1);
        bookRepository.save(book1);

        Author author2 = new Author("Konstantin", "Diyahkov");
        Book book2 = new Book("Insel Java", "1337", "Fischer mann");
        author1.getBooks().add(book2);
        book1.getAuthors().add(author2);
        authorRepository.save(author2);
        bookRepository.save(book2);


    }
}
