package com.taskManager.Task.controller;

import com.taskManager.Task.Dto.TaskDto;
import com.taskManager.Task.model.Task;
import com.taskManager.Task.repository.TaskRepository;
import com.taskManager.Task.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {
    @Autowired
    public TaskService taskService;
    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks(){
        List<TaskDto> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }
    //create Tasks
    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto task) {
        TaskDto taskDto = taskService.createTask(task);
        return new ResponseEntity<>(taskDto, HttpStatus.CREATED);
    }
    @GetMapping("{task_id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable("task_id") Long taskId){
        TaskDto task = taskService.getTaskById(taskId);
        return ResponseEntity.ok(task);
    }

    @PutMapping("{task_id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable("task_id") Long taskId,
                                                      @RequestBody TaskDto employeeDetails) {
        TaskDto updateTask = taskService.updateTask(taskId, employeeDetails);
        return ResponseEntity.ok(updateTask);
    }
    @DeleteMapping("{task_id}")
    public ResponseEntity<String> deleteTask(@PathVariable("task_id") Long taskId){
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("Task deleted successfully!");
    }
}
