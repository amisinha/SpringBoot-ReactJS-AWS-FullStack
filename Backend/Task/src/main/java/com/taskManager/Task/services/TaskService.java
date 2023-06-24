package com.taskManager.Task.services;

import com.taskManager.Task.Dto.TaskDto;


import java.util.List;
public interface TaskService {
    List<TaskDto> getAllTasks();
    TaskDto createTask (TaskDto task);
    TaskDto getTaskById(Long taskId);
    TaskDto updateTask(Long taskId, TaskDto task);
    void deleteTask(Long taskId);
}

