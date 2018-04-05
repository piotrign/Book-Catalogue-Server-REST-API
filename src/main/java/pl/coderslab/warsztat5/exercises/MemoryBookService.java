package pl.coderslab.warsztat5.exercises;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class MemoryBookService {
	private List<Book> list;

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
	
	public boolean updateBook(long id, String isbn, String title, String author, String publisher, String type) {
		Book updatedBook = this.selectBook(id);
		updatedBook.setIsbn(isbn);
		updatedBook.setTitle(title);
		updatedBook.setAuthor(author);
		updatedBook.setPublisher(publisher);
		updatedBook.setType(type);
		return true;
	}
	
	public boolean deleteBook(Book book) {
		for (Book bookIterator : list) {
			if (bookIterator.getId() == book.getId()) {
				list.remove(book);
				return false;
			}
		}
		System.out.println("No id found.");
		return true;
	}
}