package com.franca.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.franca.model.Book;

public class BookDao {

	public static void save(Book book) {
		EntityManager entity = ConnectionFactory.getConnection();
		entity.getTransaction().begin();

		entity.persist(book);

		entity.getTransaction().commit();
		entity.close();
	}

	public static void remove(int id) {
		EntityManager entity = ConnectionFactory.getConnection();
		entity.getTransaction().begin();
		Book foundBook = entity.find(Book.class, id);

		entity.remove(foundBook);

		entity.getTransaction().commit();
		entity.close();
	}

	public static void update(Book book) {
		EntityManager entity = ConnectionFactory.getConnection();
		entity.getTransaction().begin();

		Book foundBook = entity.find(Book.class, book.getId());
		//

		foundBook.setAuthor(book.getAuthor());
		foundBook.setTitle(book.getTitle());
		foundBook.setPrice(book.getPrice());
		entity.merge(foundBook);
		entity.getTransaction().commit();
		entity.close();
	}

	public static Book findById(int id) {
		EntityManager entity = ConnectionFactory.getConnection();
		entity.getTransaction().begin();
		Book foundBook = entity.find(Book.class, id);
		entity.close();
		if (null == foundBook) {
			return null;
		} else
			return foundBook;
	}

	public static Book findByAuthor(String author) {
		EntityManager entity = ConnectionFactory.getConnection();
		entity.getTransaction().begin();
		String sql = "SELECT b FROM book AS b WHERE b.author = :title";
		Book foundBook = entity.find(Book.class, author);
		entity.close();
		if (null == foundBook) {
			return null;
		} else
			return foundBook;
	}

	@SuppressWarnings("unchecked")
	public static List<Book> getList() {
		EntityManager entity = ConnectionFactory.getConnection();
		entity.getTransaction().begin();

		return entity.createQuery("FROM " + Book.class.getName()).getResultList();

	}

}
