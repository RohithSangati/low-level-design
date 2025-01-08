import java.util.ArrayList;

import iterator.Iterator;
import model.Book;
import model.Library;

public class IteratorApplication {

	public static void main(String[] args) {

		Library library = new Library(new ArrayList<>());

		library.addBook(new Book("DS & Algo", 200));

		library.addBook(new Book("Ramayana", 300));

		library.addBook(new Book("The Iron Man", 100));

		Iterator bookIterator = library.createIterator();

		while (bookIterator.hasNext()) {
			Book book = (Book) bookIterator.next();
			System.out.println(book.bookName + ":" + book.price);
		}

	}

}