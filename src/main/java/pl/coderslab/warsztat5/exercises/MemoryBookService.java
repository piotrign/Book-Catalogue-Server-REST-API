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

	public int selectBook(List<Book> list, int id) {
		
		int foundId = 0;
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == id) {
				return foundId = i;
			}else {
				System.out.println("Id: " + id + " does not exist in the list");
			}
		}
		return foundId;
	}
}