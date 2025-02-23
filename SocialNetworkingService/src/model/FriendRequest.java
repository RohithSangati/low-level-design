package model;

public class FriendRequest {

	private User from;
	private User to;
	private FriendRequestStatus friendRequestStatus;
	private Integer id;

	public FriendRequest(User from, User to, FriendRequestStatus friendRequestStatus) {
		super();
		this.from = from;
		this.to = to;
		this.friendRequestStatus = friendRequestStatus;
		this.id = this.generateId();
	}

	private int generateId() {
		return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
	}

	public User getFrom() {
		return from;
	}

	public void setFrom(User from) {
		this.from = from;
	}

	public User getTo() {
		return to;
	}

	public void setTo(User to) {
		this.to = to;
	}

	public FriendRequestStatus getFriendRequestStatus() {
		return friendRequestStatus;
	}

	public void setFriendRequestStatus(FriendRequestStatus friendRequestStatus) {
		this.friendRequestStatus = friendRequestStatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
