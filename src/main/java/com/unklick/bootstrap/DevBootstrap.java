package com.unklick.bootstrap;

import com.unklick.model.Author;
import com.unklick.model.Book;
import com.unklick.model.Publisher;
import com.unklick.repositories.AuthorRepository;
import com.unklick.repositories.BookRepository;
import com.unklick.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initializedData();
    }

    private void initializedData(){
        Publisher publisher = new Publisher();
        publisher.setName("foo");
        publisherRepository.save(publisher);

        Author author1 = new Author("Giant", "Ape");
        Book book1 = new Book("Spring Boot", "1234", publisher);
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        authorRepository.save(author1);
        bookRepository.save(book1);

        Author author2 = new Author("Konstantin", "Diyahkov");
        Book book2 = new Book("Insel Java", "1337", publisher);
        author1.getBooks().add(book2);
        book1.getAuthors().add(author2);
        authorRepository.save(author2);
        bookRepository.save(book2);


    }
}
