package com.taskManager.Task;

import com.taskManager.Task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(TaskApplication.class, args);
	}
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public  void  run(String... args) throws Exception {
//		Task task = new Task();
//		task.setTitle("Complete Assignment");
//		task.setAssignee("Amisha");
//		task.setDescription("Complete the SpringBoot course");
//		task.setStatus("PENDING");
//		taskRepository.save(task);
//
//		Task task1 = new Task();
//		task1.setTitle("Book Tickets");
//		task1.setAssignee("Amisha");
//		task1.setDescription("Book Tickets to NY");
//		task1.setStatus("PENDING");
//		taskRepository.save(task1);

	}

}
