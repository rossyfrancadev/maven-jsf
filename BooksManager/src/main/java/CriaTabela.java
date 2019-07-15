import java.util.List;

import com.franca.dao.BookDao;
import com.franca.model.Book;

public class CriaTabela {

	public static void main(String[] args) {

		Book newBook = new Book();
		newBook.setId(3);
		newBook.setAuthor("AdenosPrington");
		newBook.setPrice(31);
		newBook.setTitle("Chonicles");

		// BookDao.save(newBook);
		// BookDao.update(newBook);
		// BookDao.remove(1);
		// Book foundBook = BookDao.getBook(3);
		// System.out.println("author: " + foundBook.getAuthor());
		List<Book> listBooks = BookDao.getList();

		for (Book aBook : listBooks) {
			System.out.println(aBook.getTitle() + "," + aBook.getAuthor() + "," + aBook.getPrice());
		}

	}

}
