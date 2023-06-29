package com.taskManager.Task.services.Impl;

import com.taskManager.Task.Dto.TaskDto;
import com.taskManager.Task.exception.ResourceNotFoundException;
import com.taskManager.Task.mapper.TaskMapper;
import com.taskManager.Task.model.Task;
import com.taskManager.Task.repository.TaskRepository;
import com.taskManager.Task.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;
    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(TaskMapper::maptoTaskDto)
                .collect(Collectors.toList());
    }
    @Override
    public TaskDto createTask(TaskDto taskDto) {
        Task task = TaskMapper.mapToTask(taskDto);
        Task savedTask = taskRepository.save(task);
        return TaskMapper.maptoTaskDto(savedTask);
    }
    @Override
    public TaskDto getTaskById(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not exist with id: " + taskId));
        TaskDto taskDto = TaskMapper.maptoTaskDto(task);
        return taskDto;
    }
    @Override
    public TaskDto updateTask(Long taskId, TaskDto taskDto) {

        Task existingTask = taskRepository.findById(taskId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not exist with id: " + taskId));

        existingTask.setTitle(taskDto.getTitle());
        existingTask.setStatus(taskDto.getStatus());
        existingTask.setDescription(taskDto.getDescription());
        existingTask.setAssignee(taskDto.getAssignee());

        taskRepository.save(existingTask);
        return TaskMapper.maptoTaskDto(existingTask);
    }
    @Override
    public void deleteTask(Long taskId) {

        Task existingTask = taskRepository.findById(taskId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not exist with id: " + taskId));

        taskRepository.deleteById(taskId);
    }


}
