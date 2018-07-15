package pl.coderslab.warsztat5.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import pl.coderslab.warsztat5.entity.Book;

@Repository
@Service
public interface BookService {

	public List<Book> getList();
	public void setList(List<Book> list);
	
	public Book selectBook(long id);
	public boolean addBook(Book book);
	public boolean updateBook(Book book);
	public boolean deleteBook(long id);
}
