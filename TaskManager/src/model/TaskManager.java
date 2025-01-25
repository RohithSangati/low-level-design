package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManager {

	public Map<Integer, Task> tasks;
	public Map<Integer, User> users;

	private static TaskManager taskManagerInstance;

	private TaskManager() {
		tasks = new HashMap<>();
		users = new HashMap<>();
	}

	public User createUser(String name) {
		User user = new User(name);
		users.put(user.getId(), user);
		return user;
	}

	public static TaskManager getTaskManagerInstance() {
		if (taskManagerInstance == null) {
			synchronized (TaskManager.class) {
				taskManagerInstance = new TaskManager();
			}
		}
		return taskManagerInstance;
	}

	public Task createTask(String name, String description, Priority priority, User user) {
		Task task = user.createTask(name, description, priority);
		tasks.put(task.getId(), task);
		return task;
	}

	public void updateTask(Task updatedTask) {
		Task currentTask = tasks.get(updatedTask.getId());
		synchronized (currentTask) {
			if (currentTask != null) {
				currentTask.setDescription(updatedTask.getDescription());
				currentTask.setPriority(updatedTask.getPriority());
				currentTask.setTaskStatus(updatedTask.getTaskStatus());
				currentTask.setTitle(updatedTask.getTitle());
			}
		}
		System.out.println("Task successfully updated");
	}

	public void deleteTask(Task task) {
		for (User user : users.values()) {
			if (user.equals(task.getAssignedTo())) {
				user.deleteTaskFromHistory(task);
				System.out.println("Successfully deleted task");
			}
		}
		tasks.remove(task.getId());
	}

	public void assignTask(Task task, User user) {
		task.assignTask(user);
		System.out.println(task.getTitle() + " Successfully assigned to user - " + user.getName());
	}

	public List<Task> searchTasks(String term) {
		List<Task> res = new ArrayList<>();
		for (Task task : tasks.values()) {
			if (task.getTitle().contains(term) || task.getDescription().contains(term)) {
				res.add(task);
			}
		}
		return res;
	}

	public List<Task> filterTasks(Priority priority, User user, Date createdFrom, Date createdTo) {
		List<Task> res = new ArrayList<>();
		for (Task task : tasks.values()) {
			if (task.getPriority() == priority || task.getAssignedTo().equals(user)
					|| (task.getCreatedDate().compareTo(createdFrom) >= 0
							&& task.getCreatedDate().compareTo(createdTo) <= 0)) {
				res.add(task);
			}
		}
		return res;
	}

	public void markAsComplete(Task task) {
		task.markTaskAsCompleted();
	}

	public Map<Integer, Task> getTasks() {
		return tasks;
	}

	public Map<Integer, User> getUsers() {
		return users;
	}

}
