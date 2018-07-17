package pl.coderslab.warsztat5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.warsztat5.entity.Book;
import pl.coderslab.warsztat5.service.BookService;

@EnableAutoConfiguration
@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService memoryBookService;

	@RequestMapping("/hello")
	public String hello() {
		return "{hello:	World}";
	}

	@RequestMapping("/hellobook")
	public Book helloBook() {
		return new Book(1L, "9788324631766", "Thinking	in	Java", "Bruce	Eckel", "Helion", "programming");
	}

	@GetMapping("/")
	public List<Book> getAllBooks() {
		return memoryBookService.getList();
	}

	@GetMapping("/{id}")
	public Book getOneBook(long id) {
		Book selectedBook = memoryBookService.selectBook(id);
		if (selectedBook != null) {
			return selectedBook;
		}
		new ResponseEntity<String>("No id found", HttpStatus.NOT_FOUND);
		return null;
	}

	@PostMapping("/add")
	public ResponseEntity<String> addBook(@RequestBody Book book) {
		if (memoryBookService.addBook(book)) {
			return new ResponseEntity<String>("K", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("not K", HttpStatus.CONFLICT);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		memoryBookService.updateBook(book);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeBook(@RequestBody long id) {
		if (memoryBookService.deleteBook(id)) {
			return new ResponseEntity<String>("K", HttpStatus.OK);
		}
		return new ResponseEntity<String>("No id found", HttpStatus.NOT_FOUND);
	}
}
