package com.taskManager.Task.controller;

import com.taskManager.Task.Dto.TaskDto;
import com.taskManager.Task.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {

    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks(){
        List<TaskDto> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }
    //create Tasks
    @PostMapping
    public ResponseEntity<TaskDto> createTask(@Valid @RequestBody TaskDto task) {
        TaskDto taskDto = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskDto);
    }
    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable("taskId") Long taskId){
        TaskDto task = taskService.getTaskById(taskId);
        return ResponseEntity.ok(task);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<TaskDto> updateTask(@Valid @PathVariable("taskId") Long taskId,
                                                      @RequestBody TaskDto employeeDetails) {
        TaskDto updateTask = taskService.updateTask(taskId, employeeDetails);
        return ResponseEntity.ok(updateTask);
    }
    @DeleteMapping("{task_id}")
    public ResponseEntity<String> deleteTask(@PathVariable("task_id") Long taskId){
        taskService.deleteTask(taskId);
        return ResponseEntity.ok(String.format("Task %s deleted successfully!", taskId));
    }
}
