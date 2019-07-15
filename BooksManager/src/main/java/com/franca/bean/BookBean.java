package com.franca.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;

import com.franca.controller.BookController;
import com.franca.model.Book;

@ManagedBean(name = "bookBean")
@SessionScoped
public class BookBean {
	private Book book;

	public BookBean() {
		this.book = new Book();
	}

	public void saveBook() {
		BookController.save(this.book);
		this.book = new Book();
	}

	public List<Book> getList() {
		return BookController.getList();
	}

	public void editBook(Book book) {
		this.book = book;

	}

	public void deleteBook(Book book) {
		BookController.deleteBook(book.getId());
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
