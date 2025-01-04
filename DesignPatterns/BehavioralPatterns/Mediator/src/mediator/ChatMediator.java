package mediator;

import model.User;

public interface ChatMediator {

	public void sendMessage(User user, String message);

	public void addUser(User user);

}
