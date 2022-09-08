package palvelinohjelmointi.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import palvelinohjelmointi.bookstore.domain.Book;
import palvelinohjelmointi.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger Log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			Log.info("save couple of books");
			repository.save(new Book("TestiKirja1","TestiKirjailija1","TestiISBN1",1000,100));
			repository.save(new Book("TestiKirja2","TestiKirjailija2","TestiISBN2",2000,200));
			repository.save(new Book("TestiKirja3","TestiKirjailija3","TestiISBN3",3000,300));
			repository.save(new Book("TestiKirja4","TestiKirjailija4","TestiISBN4",4000,400));
			
			Log.info("fetch all books");
			for (Book book : repository.findAll()) {
				Log.info(book.toString());
			}
		};
	}
}
