package iterator;

import java.util.List;

import model.Book;

public class BookIterator implements Iterator {

	int index = 0;
	List<Book> booksList;

	public BookIterator(List<Book> booksList) {
		this.booksList = booksList;
	}

	public boolean hasNext() {
		return this.index < this.booksList.size();
	}

	public Object next() {
		if (this.hasNext()) {
			return this.booksList.get(this.index++);
		}
		return null;
	}

}
