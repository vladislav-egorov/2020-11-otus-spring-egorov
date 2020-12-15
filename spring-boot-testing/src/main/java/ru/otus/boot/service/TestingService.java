package ru.otus.boot.service;

import ru.otus.boot.domain.Task;

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
