package model;

import java.util.ArrayList;
import java.util.List;

public class User {

	private int id;
	private String name;
	private List<Task> taskHistory;

	public User(String name) {
		this.id = generateId();
		this.name = name;
		this.taskHistory = new ArrayList<>();
	}

	private int generateId() {
		return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
	}

	public void addTaskToHistory(Task task) {
		taskHistory.add(task);
	}

	public Task createTask(String name, String description, Priority priority) {
		System.out.println("Task successfuly created");
		Task task = new Task(name, description, priority, this);
		return task;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Task> getTaskHistory() {
		return taskHistory;
	}

	public void deleteTaskFromHistory(Task task) {
		taskHistory.remove(task);
	}

}
