package model;

import java.time.LocalDateTime;

public class Comment {

	private int id;
	private String text;
	private LocalDateTime commentOn;
	private User commentedBy;
	private Post post;

	public Comment(String text, Post post, User commentedBy) {
		super();
		this.id = this.generateId();
		this.text = text;
		this.commentOn = LocalDateTime.now();
		this.commentedBy = commentedBy;
		this.setPost(post);
	}

	private int generateId() {
		return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getCommentOn() {
		return commentOn;
	}

	public void setCommentOn(LocalDateTime commentOn) {
		this.commentOn = commentOn;
	}

	public User getCommentedBy() {
		return commentedBy;
	}

	public void setCommentedBy(User commentedBy) {
		this.commentedBy = commentedBy;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
