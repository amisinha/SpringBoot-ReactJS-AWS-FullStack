package com.taskManager.Task.mapper;

import com.taskManager.Task.Dto.TaskDto;
import com.taskManager.Task.model.Task;

public class TaskMapper {

    public static TaskDto maptoTaskDto(Task task){
        TaskDto taskDto = new TaskDto();
        taskDto.setTask_id(task.getTask_id());
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setStatus(task.getStatus());
        taskDto.setAssignee(task.getAssignee());
        return taskDto;
    }

    public static Task mapToTask(TaskDto taskDto){
        Task task = new Task();
        task.setTask_id(taskDto.getTask_id());
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setStatus(taskDto.getStatus());
        task.setAssignee(taskDto.getAssignee());
        return task;
    }

}
