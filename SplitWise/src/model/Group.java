package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Group {

	private String groupId;
	private String name;
	private HashMap<String, User> members;
	private HashMap<String, Expense> expenses;

	public Group(String name) {
		super();
		this.name = name;
		this.members = new HashMap<>();
		this.expenses = new HashMap<>();
	}

	public String getGroupId() {
		return groupId;
	}

	public String getName() {
		return name;
	}

	public void addMember(User user) {
		this.members.put(user.getUserId(), user);
		System.out.println("Successfully added " + user.getName() + " to group " + this.name);
	}

	public void addExpense(Expense expense) {
		this.expenses.put(expense.getExpenseId(), expense);
		System.out.println("Successfully added expense " + expense.getExpenseId() + " to group " + this.name);
	}

	public List<User> getMembers() {
		List<User> users = new ArrayList<>();
		for (User user : this.members.values()) {
			users.add(user);
		}
		return users;
	}

}
