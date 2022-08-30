package palvelinohjelmointi.bookstore.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import palvelinohjelmointi.bookstore.domain.Book;

public class BookController {
	
	@GetMapping("/index")
	public String listBooks(Model model) {
		return "index";
	}
	
	
}
