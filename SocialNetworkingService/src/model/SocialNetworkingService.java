package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SocialNetworkingService {

	HashMap<String, User> usersMap;
	HashMap<Integer, FriendRequest> friendRequests;
	HashMap<User, List<Notification>> notifications;
	HashMap<Integer, Post> posts;

	private static SocialNetworkingService socialNetworkingSerive;

	private SocialNetworkingService() {
		usersMap = new HashMap<String, User>();
		friendRequests = new HashMap<Integer, FriendRequest>();
		notifications = new HashMap<User, List<Notification>>();
		posts = new HashMap<Integer, Post>();
	}

	public static SocialNetworkingService getInstance() {
		if (socialNetworkingSerive == null) {
			synchronized (SocialNetworkingService.class) {
				socialNetworkingSerive = new SocialNetworkingService();
			}
		}
		return socialNetworkingSerive;
	}

	private boolean isEmailExists(String email) {
		return usersMap.containsKey(email);
	}

	private void sendNotification(NotificationType notificationType, User from, User to) {
		String content = "Unknow notification";
		switch (notificationType) {
		case NotificationType.FRIENDREQUEST:
			content = "Friend request received from " + from.getName();
			break;
		case NotificationType.LIKE:
			content = from.getName() + " Liked/Unliked your post";
			break;
		case NotificationType.COMMENT:
			content = from.getName() + " commented your post";
			break;
		default:
			break;
		}
		Notification notification = new Notification(content, notificationType, to);
		if (notifications.get(to) == null) {
			notifications.put(to, new ArrayList<Notification>());
		}
		notifications.get(to).add(notification);
		System.out.println("Successfully sent notification " + content + " to " + to.getName());
	}

	public void registerUser(String name, String email, String password) {
		if (isEmailExists(email)) {
			System.out.println("User with given email already exists,Please User different email");
			return;
		}
		User user = new User(name, email, password);
		this.usersMap.put(user.getEmail(), user);
		System.out.println("User -" + name + " successfully registered,Please login to get the services");
	}

	public boolean login(String email, String password) {
		if (isEmailExists(email)) {
			if (this.validatePassword(password, usersMap.get(email).getPassword())) {
				System.out.println("User successfully logged in!!!!!");
				return true;
			} else {
				System.out.println("Invalid password!");
			}
		} else {
			System.out.println("Given email not found in our data base");
		}
		return false;
	}

	private boolean validatePassword(String currPassword, String storedPassword) {
		String[] passwordArray = storedPassword.split(":");
		String hashedCurrPass = User.hashPassword(currPassword, passwordArray[1]);
		return passwordArray[0].equals(hashedCurrPass);
	}

	public void updateProfile(User user, String name, String profilePictureUrl, String bio, String interests) {
		if (name != null) {
			user.setName(name);
		}
		if (profilePictureUrl != null) {
			user.setProfilePictureUrl(profilePictureUrl);
		}
		if (bio != null) {
			user.setBio(bio);
		}
		if (interests != null) {
			user.setInterests(interests);
		}
	}

	public User getUserByEmail(String email) {
		return this.usersMap.get(email);
	}

	public void SendFriendRequest(User from, User to) {
		FriendRequest request = new FriendRequest(from, to, FriendRequestStatus.PENDING);
		System.out.println("Successfully sent friend request from " + from.getName() + " to " + to.getName());
		this.friendRequests.put(request.getId(), request);
		sendNotification(NotificationType.FRIENDREQUEST, from, to);
	}

	public List<FriendRequest> getAllFriendRequests(User user) {
		List<FriendRequest> pendingRequests = new ArrayList<>();
		for (FriendRequest friendRequest : this.friendRequests.values()) {
			if (friendRequest.getFriendRequestStatus() == FriendRequestStatus.PENDING
					&& friendRequest.getTo().equals(user)) {
				pendingRequests.add(friendRequest);
			}
		}
		return pendingRequests;
	}

	public void acceptFriendRequest(FriendRequest friendRequest) {
		friendRequest.setFriendRequestStatus(FriendRequestStatus.ACCEPTED);
		friendRequest.getTo().addFriend(friendRequest.getFrom());
		friendRequest.getFrom().addFriend(friendRequest.getTo());
		System.out.println("Successfully accepted friend request");
	}

	public void rejectFriendRequest(FriendRequest friendRequest) {
		friendRequest.setFriendRequestStatus(FriendRequestStatus.REJECTED);
		System.out.println("Successfully rejected friend request");
	}

	public void createPost(String content, List<String> mediaUrls, User from) {
		Post post = new Post(content, mediaUrls, from);
		this.posts.put(post.getId(), post);
		from.addPost(post);
		System.out.println("Successfully posted post by " + from.getName());
	}

	public List<Post> getAllPosts(User user) {
		List<User> friends = user.getFriends();
		friends.add(user);
		HashSet<User> friendSet = new HashSet<>(friends);
		List<Post> postsToReturn = new ArrayList<>();
		for (Post post : this.posts.values()) {
			if (friendSet.contains(post.getPostedBy())) {
				postsToReturn.add(post);
			}
		}
		Collections.sort(postsToReturn, new Comparator<Post>() {
			public int compare(Post post1, Post post2) {
				return post2.getTimeStamp().compareTo(post1.getTimeStamp());
			}
		});
		return postsToReturn;
	}

	public void clickLike(Post post, User user) {
		post.clickLike(user);
		sendNotification(NotificationType.LIKE, user, post.getPostedBy());
	}

	public void addComment(Post post, User user, String commentText) {
		Comment comment = new Comment(commentText, post, user);
		this.posts.get(post.getId()).addComment(comment);
		System.out
				.println("Successfully added comment for the post " + post.getId() + " by the user " + user.getName());
		sendNotification(NotificationType.COMMENT, user, post.getPostedBy());
	}

}
