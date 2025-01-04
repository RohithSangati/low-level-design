package model;

import mediator.ChatMediator;

public class UserImpl extends User {

	public UserImpl(ChatMediator chatMediator, String name) {
		super(chatMediator, name);
	}

	public void receive(User user,String message) {
		System.out.println("User " + user.name + " sent message and "+this.name+" Received Message -" + message);
	}

	public void send(String message) {
		this.chatMediator.sendMessage(this, message);
	}

}
