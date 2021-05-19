package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.entities.Author;
import guru.springframework.spring5webapp.entities.Book;
import guru.springframework.spring5webapp.entities.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Override
    public void run(String... args) {
        new Thread(() -> {
            Publisher publisher = new Publisher("Publisher", "Tanzania", "Dar");
            publisherRepository.save(publisher);
            Author author1 = new Author("Jonas", "Tumsifu", "Jonas");
            Book book1 = new Book("Test Book 1", "122323234");
            author1.getBooks().add(book1);
            book1.getAuthors().add(author1);
            publisher.getBooks().add(book1);
            book1.setPublisher(publisher);
            authorRepository.save(author1);
            bookRepository.save(book1);
            publisherRepository.save(publisher);
            Book book2 = new Book("Test Book 2", "122323234");
            author1.getBooks().add(book2);
            book2.getAuthors().add(author1);
            publisher.getBooks().add(book2);
            book2.setPublisher(publisher);
            bookRepository.save(book2);
            publisherRepository.save(publisher);
            Author author2 = new Author("Test2", "Two", "New2");
            Book book3 = new Book("Test Book 3", "122323234");
            book3.getAuthors().add(author2);
            book3.setPublisher(publisher);
            publisher.getBooks().add(book3);
            authorRepository.save(author2);
            bookRepository.save(book3);
            publisherRepository.save(publisher);
            Book book4 = new Book("Test Book 4", "122323234");
            book4.getAuthors().add(author2);
            book4.setPublisher(publisher);
            publisher.getBooks().add(book4);
            author2.getBooks().add(book3);
            author2.getBooks().add(book4);
            bookRepository.save(book4);
            publisherRepository.save(publisher);
            System.out.println("Started in Bootstrap");
            System.out.println("Books Count : " + bookRepository.count());
            System.out.println("Authors : " + authorRepository);
            System.out.println("Publishers : " + publisher);
            System.out.println("Publisher Books Count : " + publisher.getBooks().size());
        }).start();
    }
}
