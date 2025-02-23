package model;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class User {

	private int id;
	private String name;
	private String email;
	private String password;
	private String profilePictureUrl;
	private String bio;
	private String interests;
	private List<User> friends;
	private List<Post> posts;

	public User(String name, String email, String password) {
		this.id = this.generateId();
		this.name = name;
		this.email = email;
		this.password = hashPassword(password);
		this.friends = new ArrayList<>();
		this.posts = new ArrayList<>();
	}

	public static String hashPassword(String password) {
		try {
			SecureRandom secureRandom = new SecureRandom();
			byte[] salt = new byte[16];
			secureRandom.nextBytes(salt);
			String saltedPassword = password + Base64.getEncoder().encodeToString(salt);
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			byte[] hash = messageDigest.digest(saltedPassword.getBytes());
			String hashedPassword = Base64.getEncoder().encodeToString(hash) + ":"
					+ Base64.getEncoder().encodeToString(salt);
			return hashedPassword;
		} catch (Exception e) {
			System.out.println("Error while hashing password");
			return null;
		}
	}

	public static String hashPassword(String password, String salt) {
		try {
			SecureRandom secureRandom = new SecureRandom();
			String saltedPassword = password + salt;
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			byte[] hash = messageDigest.digest(saltedPassword.getBytes());
			String hashedPassword = Base64.getEncoder().encodeToString(hash);
			return hashedPassword;
		} catch (Exception e) {
			System.out.println("Error while hashing password");
			return null;
		}
	}

	public void addFriend(User user) {
		if (!friends.contains(user)) {
			System.out.println("Successfully added " + user.getName() + " to " + this.getName() + " friends list");
			this.friends.add(user);
		}
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfilePictureUrl() {
		return profilePictureUrl;
	}

	public void setProfilePictureUrl(String profilePictureUrl) {
		this.profilePictureUrl = profilePictureUrl;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getBio() {
		return bio;
	}

	public String getInterests() {
		return interests;
	}

	public List<User> getFriends() {
		return friends;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void addPost(Post post) {
		this.posts.add(post);
	}

}
