package model;

import mediator.ChatMediator;

public abstract class User {

	public String name;
	public ChatMediator chatMediator;

	public User(ChatMediator chatMediator, String name) {
		this.chatMediator = chatMediator;
		this.name = name;
	}

	public abstract void receive(User user,String message);

	public abstract void send(String message);
}
