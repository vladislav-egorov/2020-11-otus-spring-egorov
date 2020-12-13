package ru.otus.springboottesting.service;


import ru.otus.springboottesting.domain.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAllTasks();

    String taskToPrettyString(Task task);
}
