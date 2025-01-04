package mediator;

import java.util.ArrayList;
import java.util.List;

import model.User;

public class ChatMediatorImpl implements ChatMediator {

	public List<User> users;
	
	public ChatMediatorImpl() {
		users = new ArrayList<>();
	}
	
	public void sendMessage(User user,String message) {
		for(User u : users) {
			if(!user.equals(u)) {
				u.receive(user,message);
			}
		}
	}

	public void addUser(User user) {
		this.users.add(user);
	}

}
