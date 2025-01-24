package model;

public class Comment {

	public int id;

	public String content;

	private User author;

	Comment(String content, User author) {
		this.id = generateId();
		this.content = content;
		this.author = author;
	}

	private int generateId() {
		return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
	}

	public User getAuthor() {
		return author;
	}

}
