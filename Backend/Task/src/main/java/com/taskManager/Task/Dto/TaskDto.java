package com.taskManager.Task.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private long task_id;
    private String title;
    private String description;
    private String status;
    private String assignee;
//    private long user_id;

}
