package ru.otus.boot.service;


import ru.otus.boot.domain.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAllTasks();

    String taskToPrettyString(Task task);
}
