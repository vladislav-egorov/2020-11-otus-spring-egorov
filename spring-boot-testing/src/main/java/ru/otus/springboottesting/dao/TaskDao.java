package ru.otus.springboottesting.dao;


import ru.otus.springboottesting.domain.Task;

import java.util.List;

public interface TaskDao {
    List<Task> findAll();
}
