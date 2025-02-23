package model;

public class Notification {

	private String information;
	private NotificationType notificationType;
	private User toUser;
	private Integer id;

	public Notification(String information, NotificationType notificationType, User toUser) {
		super();
		this.information = information;
		this.notificationType = notificationType;
		this.toUser = toUser;
		this.id = this.generateId();
	}

	public Integer getId() {
		return id;
	}

	private int generateId() {
		return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
	}

	public String getInformation() {
		return information;
	}

	public NotificationType getNotificationType() {
		return notificationType;
	}

	public User getToUser() {
		return toUser;
	}

}
