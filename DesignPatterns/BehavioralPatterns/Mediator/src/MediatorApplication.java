import mediator.ChatMediator;
import mediator.ChatMediatorImpl;
import model.User;
import model.UserImpl;

public class MediatorApplication {

	public static void main(String[] args) {

		ChatMediator chatApp = new ChatMediatorImpl();

		User user1 = new UserImpl(chatApp, "Dora babu");
		User user2 = new UserImpl(chatApp, "Moulika");
		User user3 = new UserImpl(chatApp, "Rohith");

		chatApp.addUser(user1);
		chatApp.addUser(user2);
		chatApp.addUser(user3);

		user1.send("Hello Every one");

		System.out.println("=============================");

		user2.send("Hi there!!!!");

		System.out.println("=============================");

		user3.send("Elaaraku vanakkam!!!!");

	}

}