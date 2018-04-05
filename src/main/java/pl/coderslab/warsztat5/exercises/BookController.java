package pl.coderslab.warsztat5.exercises;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping("/books")
public class BookController {

	@Autowired
	private MemoryBookService bookService;

	@RequestMapping("/hello")
	public String hello() {
		return "{hello:	World}";
	}

	@RequestMapping("/books")
	public Book helloBook() {

		return new Book(1L, "9788324631766", "Thinking	in	Java", "Bruce	Eckel", "Helion", "programming");
	}

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookService.getList();
	}

	@GetMapping("/books/{id}")
	public Book getOneBook(long id) {
		Book selectedBook = bookService.selectBook(id);
		if(selectedBook != null) {
			
			return selectedBook;
		}
		new ResponseEntity<String>("No id found", HttpStatus.NOT_FOUND);
		return null;
	}

	@PostMapping("/books/")
	public ResponseEntity<String> addBook(@RequestBody Book book) {
		if (bookService.addBook(book)) {
			return new ResponseEntity<String>("K", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("not K", HttpStatus.CONFLICT);
	}

	@PutMapping("/books/{id}")
	public void updateBook(@PathVariable long id, @RequestParam String isbn, @RequestParam String title,
			@RequestParam String author, @RequestParam String publisher, @RequestParam String type) {
		if(bookService.updateBook(id, isbn, title, author, publisher, type)) {
			return ResponseEntity<String>("K", HttpStatus.OK);
		}
		return bookService.addBook();
	}

	@DeleteMapping("/books/{id}")
	public ResponseEntity<String> removeBook(@RequestBody Book book) {
		if (bookService.deleteBook(book)) {
			return new ResponseEntity<String>("K", HttpStatus.OK);
		}
		return new ResponseEntity<String>("No id found", HttpStatus.NOT_FOUND);
	}
}
