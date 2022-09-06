package palvelinohjelmointi.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import palvelinohjelmointi.bookstore.domain.Book;
import palvelinohjelmointi.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			//Log.info("save couple of books");
			repository.save(new Book("TestiKirja1","TestiKirjailija1","TestiISBN1",1000,100));
			repository.save(new Book("TestiKirja2","TestiKirjailija2","TestiISBN2",2000,200));
			
			//Log.info("fetch all books");
			for (Book book : repository.findAll()) {
				//Log.info(book.toString());
				System.out.println(book.toString());
			}
		};
	}
}
