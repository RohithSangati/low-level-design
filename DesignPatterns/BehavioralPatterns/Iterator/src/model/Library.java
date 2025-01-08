package model;

import java.util.List;

import iterator.BookIterator;
import iterator.Iterator;

public class Library {

	List<Book> booksList;

	public Library(List<Book> booksList) {
		this.booksList = booksList;
	}

	public void addBook(Book book) {
		this.booksList.add(book);
	}

	public Iterator createIterator() {
		return new BookIterator(this.booksList);
	}

}
