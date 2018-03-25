package pl.coderslab.warsztat5.exercises;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@RequestMapping("/helloBook")
	public Book helloBook() {

		return new Book(1L, "9788324631766", "Thinking	in	Java", "Bruce	Eckel", "Helion", "programming");
	}

	@RequestMapping("/getAllBooks")
	public List<Book> getAllBooks() {
		List allBooks = bookService.getList();
		return allBooks;
	}
	
	@RequestMapping("/getOneBook")
	public int getOneBook(int id, List<Book> list) {
		int book = bookService.selectBook(list, id);
		
		return book;
		
	}
}
