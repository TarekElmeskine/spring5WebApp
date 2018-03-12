package be.elmeskine.spring5demo.boostrap;

import be.elmeskine.spring5demo.model.Author;
import be.elmeskine.spring5demo.model.Book;
import be.elmeskine.spring5demo.model.Publisher;
import be.elmeskine.spring5demo.repository.AuthorRepository;
import be.elmeskine.spring5demo.repository.BookRepository;
import be.elmeskine.spring5demo.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Publisher publisher = new Publisher("Glenat", "Rue vital riethuisen");
        publisherRepository.save(publisher);

        Book book = new Book("Tarek et sa vie", publisher);
        Book book2 = new Book("Sabrina et sa vie", publisher);
        Author author = new Author("Tarek", "Elmeskine");


        book.getAuthors().add(author);
        book2.getAuthors().add(author);

        authorRepository.save(author);
        bookRepository.save(book);
        bookRepository.save(book2);


    }
}
