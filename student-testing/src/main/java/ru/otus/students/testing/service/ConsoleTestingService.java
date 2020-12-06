package ru.otus.students.testing.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.students.testing.domain.Answer;
import ru.otus.students.testing.domain.Task;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class ConsoleTestingService implements TestingService {

    private final TaskService taskService;
    private final Integer rightAnswersCount;
    private final String failMessage;
    private final String successMessage;


    public List<Task> getAllTasks() {
        return taskService.findAllTasks();
    }

    public Integer getRightAnswersCount() {
        return rightAnswersCount;
    }

    public void testingFailed() {
        System.out.println(failMessage);
    }

    public void testingSuccess() {
        System.out.println(successMessage);
    }

    public boolean testTask(Task task) {
        String printed = taskService.taskToPrettyString(task);
        System.out.println(printed);
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        int answerId = Integer.parseInt(answer) - 1;
        Answer chosenAnswer = task.getAnswers().get(answerId);
        return chosenAnswer.getIsItRight();
    }
}
