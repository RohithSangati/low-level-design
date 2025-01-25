import java.util.Date;

import model.Priority;
import model.Task;
import model.TaskManager;
import model.User;

class TaskManagerApplication {

	public static void main(String[] args) {

		TaskManager taskManager = TaskManager.getTaskManagerInstance();

		User user1 = taskManager.createUser("Rohith");
		User user2 = taskManager.createUser("Varalakshmi");

		Task task1 = taskManager.createTask("Task1", "Task1 description", Priority.P1, user1);

		System.out.println(task1);

		task1.assignTask(user2);

		System.out.println(task1);
		System.out.println(user2.getTaskHistory());

		task1.setDescription("description1");
		taskManager.updateTask(task1);

		System.out.println(task1);
		
		task1.markTaskAsCompleted();
		System.out.println(task1);

		Task task2 = taskManager.createTask("Task2", "Task2 description2", Priority.P2, user2);

		System.out.println(taskManager.searchTasks("Task2"));

		System.out.println(taskManager.searchTasks("description"));

		System.out.print(taskManager.filterTasks(Priority.P2, user1, new Date(), new Date()));
		
		taskManager.deleteTask(task1);
		System.out.println(user2.getTaskHistory());
		System.out.println(taskManager.getTasks());

	}

}