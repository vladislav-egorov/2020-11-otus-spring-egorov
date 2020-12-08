package ru.otus.students.testing.service;

import ru.otus.students.testing.domain.Task;

import java.util.List;

public interface TestingService {
    void startTesting();

    String askName();

    Integer getRightAnswersCount();

    void onTestingSuccess();

    boolean startTestingFromTask(Task task);

    List<Task> getAllTasks();

    void onTestingFailed();
}
