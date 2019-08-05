package com.myzone.demoapp.bootstrap;

import com.myzone.demoapp.model.Author;
import com.myzone.demoapp.model.Book;
import com.myzone.demoapp.model.Publisher;
import com.myzone.demoapp.repositories.AuthorRepository;
import com.myzone.demoapp.repositories.BookRepository;
import com.myzone.demoapp.repositories.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    /*
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }
    */

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234");
        Publisher publisher = new Publisher("Harper Collections", "New Ave 12, New York");
        eric.getBooks().add(ddd);
        ddd.setPublisher(publisher);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(publisher);
        bookRepository.save(ddd);



        Author rod = new Author("Rod", "Jhonson");
        Book noEJB = new Book("JEE Development without EJB", "2344343");
        Publisher publisher1 = new Publisher("Work", "London");
        rod.getBooks().add(noEJB);
        noEJB.setPublisher(publisher1);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        publisherRepository.save(publisher1);
        bookRepository.save(noEJB);

    }
}
