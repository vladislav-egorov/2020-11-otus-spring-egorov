package ru.otus.students.testing.dao;

import ru.otus.students.testing.domain.Task;

import java.util.List;

public interface TaskDao {
    List<Task> findAll();
}
