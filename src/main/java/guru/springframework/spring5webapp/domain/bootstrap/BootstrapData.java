package guru.springframework.spring5webapp.domain.bootstrap;

import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.domain.author;
import guru.springframework.spring5webapp.domain.repositories.AuthorRepositories;
import guru.springframework.spring5webapp.domain.repositories.BookRepositories;
import guru.springframework.spring5webapp.domain.repositories.PublisherRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepositories authorRepositories;
    private final BookRepositories bookRepositories;
    private final PublisherRepositories publisherRepositories;

    public BootstrapData(AuthorRepositories authorRepositories, BookRepositories bookRepositories, PublisherRepositories publisherRepositories) {
        this.authorRepositories = authorRepositories;
        this.bookRepositories = bookRepositories;
        this.publisherRepositories=publisherRepositories;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");

        publisherRepositories.save(publisher);

        System.out.println("Publisher Count: " + publisherRepositories.count());

        author eric = new author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepositories.save(eric);
        bookRepositories.save(ddd);
        publisherRepositories.save(publisher);

        author rod = new author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepositories.save(rod);
        bookRepositories.save(noEJB);
        publisherRepositories.save(publisher);

        System.out.println("Number of Books: " + bookRepositories.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
    }
}

