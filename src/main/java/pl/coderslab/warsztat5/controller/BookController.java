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
import pl.coderslab.warsztat5.responsemsg.ResponseMsg;
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
	public ResponseEntity<Book> getOneBook(long id) {
		Book selectedBook = memoryBookService.selectBook(id);
		if (selectedBook != null) {
			return new ResponseEntity<>(selectedBook, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/add")
	public ResponseEntity<ResponseMsg> addBook(@RequestBody Book book) {
		if (memoryBookService.addBook(book)) {
			return new ResponseEntity<>(ResponseMsg.CREATED, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(ResponseMsg.BOOKEXISTS, HttpStatus.CONFLICT);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		memoryBookService.updateBook(book);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseMsg> removeBook(@RequestBody long id) {
		if (memoryBookService.deleteBook(id)) {
			return new ResponseEntity<>(ResponseMsg.BOOKDELETED, HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponseMsg.BOOKNOTFOUND, HttpStatus.NOT_FOUND);
	}
}
