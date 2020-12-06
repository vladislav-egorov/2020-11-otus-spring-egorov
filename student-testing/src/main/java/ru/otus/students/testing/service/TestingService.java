package ru.otus.students.testing.service;

import ru.otus.students.testing.domain.Task;

import java.util.List;

public interface TestingService {
    default void startTesting() {
        long rightAnswers = getAllTasks().stream()
                .map(this::testTask)
                .filter(answer -> answer)
                .count();
        if (rightAnswers >= getRightAnswersCount()) {
            testingSuccess();
        } else {
            testingFailed();
        }
    }

    Integer getRightAnswersCount();

    void testingSuccess();

    boolean testTask(Task task);

    List<Task> getAllTasks();

    void testingFailed();
}
