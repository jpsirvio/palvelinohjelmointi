package palvelinohjelmointi.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
	//List<Book> findByLastName(String author);
}