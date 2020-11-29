package ru.otus.students.testing.service;

import ru.otus.students.testing.domain.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAllTasks();

    String taskToPettyString(Task task);
}
