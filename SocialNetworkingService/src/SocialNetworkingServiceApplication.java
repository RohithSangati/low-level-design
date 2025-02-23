import java.util.List;
import java.util.Scanner;

import model.FriendRequest;
import model.Post;
import model.SocialNetworkingService;
import model.User;

public class SocialNetworkingServiceApplication {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		SocialNetworkingService socialNetworkingService = SocialNetworkingService.getInstance();

		socialNetworkingService.registerUser("Rohith", "rohit.s@darwinbox.io", "Rohith@123");
		socialNetworkingService.registerUser("Moulika", "moulika.s@darwinbox.io", "Moulika@123");

		boolean isUserLogin = false;

		while (!isUserLogin) {
			System.out.println("Enter email");
			String email = sc.next();
			System.out.println("Enter password");
			String password = sc.next();
			isUserLogin = socialNetworkingService.login(email, password);
		}

		User rohith = socialNetworkingService.getUserByEmail("rohit.s@darwinbox.io");
		User moulika = socialNetworkingService.getUserByEmail("moulika.s@darwinbox.io");

		socialNetworkingService.updateProfile(moulika, "Mohitha", null, null, null);

		System.out.println(moulika.getName());

		socialNetworkingService.SendFriendRequest(rohith, moulika);

		List<FriendRequest> allRequests = socialNetworkingService.getAllFriendRequests(moulika);

		for (FriendRequest friendRequest : allRequests) {
			socialNetworkingService.acceptFriendRequest(friendRequest);
		}

		System.out.println("Rohith's friends");
		if (rohith.getFriends().size() > 0) {
			System.out.println(rohith.getFriends().get(0).getEmail());
		} else {
			System.out.println("No friends for rohith as of now");
		}

		socialNetworkingService.createPost("Post 1 from rohith", null, rohith);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		socialNetworkingService.createPost("Post 2 from rohith", null, rohith);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		socialNetworkingService.createPost("Post 3 from rohith", null, rohith);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		socialNetworkingService.createPost("Post 1 from moulika", null, moulika);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		socialNetworkingService.createPost("Post 2 from moulika", null, moulika);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<Post> allPosts = socialNetworkingService.getAllPosts(moulika);

		for (Post post : allPosts) {
			System.out.println(post.getContent());
			socialNetworkingService.clickLike(post, moulika);
			socialNetworkingService.clickLike(post, moulika);
			socialNetworkingService.addComment(post, rohith, "Ware wa post bhaii " + post.getId());
		}

	}

}