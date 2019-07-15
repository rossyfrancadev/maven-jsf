package com.franca.controller;

import java.util.List;

import com.franca.dao.BookDao;
import com.franca.model.Book;

public class BookController {

	public static List<Book> getList() {
		return BookDao.getList();
	}

	public static void save(Book book) {
		Book foundBook = BookDao.findById(book.getId());
		if (null == foundBook) {
			BookDao.save(book);
		} else
			BookDao.update(book);
	}

	public static void update(Book book) {
		// TODO: Colocar lógica para testar se o objeto está vazio
		BookDao.update(book);

	}

	public static Book find(int id) {
		return BookDao.findById(id);
	}

	public static void deleteBook(int id) {
		BookDao.remove(id);
	}
}
