package ru.otus.boot.dao;


import ru.otus.boot.domain.Task;

import java.util.List;

public interface TaskDao {
    List<Task> findAll();
}
