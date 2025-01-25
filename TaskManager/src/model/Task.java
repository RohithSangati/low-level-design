package model;

import java.util.Date;

public class Task {

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}

	private int id;
	private String title;
	private String description;
	private Priority priority;
	private TaskStatus taskStatus;
	private User createdBy;
	private User assignedTo;
	private Date createdDate;

	public Task(String title, String description, Priority priority, User createdBy) {
		this.id = generateId();
		this.title = title;
		this.description = description;
		this.priority = priority;
		this.taskStatus = TaskStatus.PENDING;
		this.createdBy = createdBy;
		this.createdDate = new Date();
		this.assignedTo = null;
	}

	private int generateId() {
		return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
	}

	public void assignTask(User user) {
		this.assignedTo = user;
		this.taskStatus = TaskStatus.PENDING;
		user.addTaskToHistory(this);
	}

	public void markTaskAsCompleted() {
		this.taskStatus = TaskStatus.COMPLETED;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Priority getPriority() {
		return priority;
	}

	public TaskStatus getTaskStatus() {
		return taskStatus;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", priority=" + priority
				+ ", taskStatus=" + taskStatus + ", createdBy=" + createdBy + ", assignedTo=" + assignedTo
				+ ", createdDate=" + createdDate + "]";
	}

}
