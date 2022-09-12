package palvelinohjelmointi.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import palvelinohjelmointi.bookstore.domain.Book;
import palvelinohjelmointi.bookstore.domain.BookRepository;
import palvelinohjelmointi.bookstore.domain.Category;
import palvelinohjelmointi.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger Log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {

			Log.info("create categories");
			crepository.save(new Category("Good Books"));
			crepository.save(new Category("Bad Books"));
			crepository.save(new Category("Forbidden Books"));
			
			Log.info("create books");
			repository.save(new Book("TestiKirja1","TestiKirjailija1","TestiISBN1",crepository.findByName("Good Books").get(0),1000,100));
			repository.save(new Book("TestiKirja2","TestiKirjailija2","TestiISBN2",crepository.findByName("Good Books").get(0),2000,200));
			repository.save(new Book("TestiKirja3","TestiKirjailija3","TestiISBN3",crepository.findByName("Bad Books").get(0),3000,300));
			repository.save(new Book("TestiKirja4","TestiKirjailija4","TestiISBN4",crepository.findByName("Forbidden Books").get(0),4000,400));
			
			Log.info("fetch all books");
			for (Book book : repository.findAll()) {
				Log.info(book.toString());
				
			}
		};
	}
}
