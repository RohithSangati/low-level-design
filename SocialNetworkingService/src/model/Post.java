package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post {

	private int id;
	private String content;
	private List<String> mediaUrls;
	private User postedBy;
	private LocalDateTime timeStamp;
	private List<User> likes;
	private List<Comment> comments;

	public Post(String content, List<String> mediaUrls, User postedBy) {
		this.id = this.generateId();
		this.content = content;
		this.mediaUrls = mediaUrls;
		this.postedBy = postedBy;
		this.timeStamp = LocalDateTime.now();
		this.likes = new ArrayList<>();
		this.comments = new ArrayList<>();
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getMediaUrls() {
		return mediaUrls;
	}

	public void setMediaUrls(List<String> mediaUrls) {
		this.mediaUrls = mediaUrls;
	}

	public User getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(User postedBy) {
		this.postedBy = postedBy;
	}

	public void clickLike(User user) {
		if (this.likes.contains(user)) {
			this.likes.remove(user);
			System.out.println(user.getName() + " successfully reverted like for the post " + this.getId());
		} else {
			this.likes.add(user);
			System.out.println(user.getName() + " successfully likes post " + this.getId());
		}
	}

	public void addComment(Comment comment) {
		this.comments.add(comment);
	}

}
