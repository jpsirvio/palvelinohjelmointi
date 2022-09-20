package palvelinohjelmointi.bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import palvelinohjelmointi.bookstore.domain.Book;
import palvelinohjelmointi.bookstore.domain.BookRepository;
import palvelinohjelmointi.bookstore.domain.CategoryRepository;

@RestController
public class BookRestController {
	
	@Autowired
	private BookRepository repository; 
	
	@Autowired
	private CategoryRepository crepository;
	
	// REST return list of books
	@GetMapping("/books")
	public Iterable<Book> getBooks() {
		return repository.findAll();
	}
	
	// REST find a book
	@GetMapping("/books/{id}")
	public Optional<Book> findBookRest(@PathVariable("id") Long id) {
		return repository.findById(id);
	}

	
	
}
