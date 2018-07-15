package pl.coderslab.warsztat5.exercises;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class MemoryBookService implements BookService{
	private List<Book> list;

	@PostConstruct
	public void initialize() {
		list = new ArrayList<>();
		list.add(new Book(1L, "9788324631766", "Thinking	in	Java", "Bruce	Eckel", "Helion", "programming"));
		list.add(new Book(2L, "9788324627738", "Rusz	glowa,	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
				"programming"));
		list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
				"programming"));
	}
	
	public MemoryBookService() {
		list = new ArrayList<>();
		list.add(new Book(1L, "9788324631766", "Thinking	in	Java", "Bruce	Eckel", "Helion", "programming"));
		list.add(new Book(2L, "9788324627738", "Rusz	glowa,	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
				"programming"));
		list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
				"programming"));
	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

	public Book selectBook(long id) {
		for (Book book : list) {
			if (book.getId() == id) {
				return book;
			}
		}
		System.out.println("Id: " + id + " does not exist in the list");
		return null;
	}

	public boolean addBook(Book book) {
		for (Book bookIterator : list) {
			if (bookIterator.getId() == book.getId()) {
				System.out.println("Given id already exists.");
				return false;
			}
		}
		list.add(book);
		return true;
	}

	public boolean updateBook(Book book) {
		for (Book bookIterator : list) {
			if (bookIterator.getId() == book.getId()) {
				list.remove(bookIterator);
				break;
			}
		}
		list.add(book);
		return true;
	}

	public boolean deleteBook(long id) {
		for (Book bookIterator : list) {
			if (bookIterator.getId() == id) {
				list.remove(bookIterator);
				return true;
			}
		}
		System.out.println("No id found.");
		return false;
	}
}