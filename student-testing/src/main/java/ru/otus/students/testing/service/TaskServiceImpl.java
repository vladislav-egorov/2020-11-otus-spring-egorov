package ru.otus.students.testing.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.students.testing.dao.TaskDao;
import ru.otus.students.testing.domain.Task;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskDao taskDao;

    @Override
    public List<Task> findAllTasks() {
        return taskDao.findAll();
    }

}
