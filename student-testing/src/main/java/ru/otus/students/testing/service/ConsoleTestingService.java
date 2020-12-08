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
    private final String helloMessage;


    public List<Task> getAllTasks() {
        return taskService.findAllTasks();
    }

    public Integer getRightAnswersCount() {
        return rightAnswersCount;
    }

    public void onTestingFailed() {
        System.out.println(failMessage);
    }

    public void onTestingSuccess() {
        System.out.println(successMessage);
    }

    @Override
    public void startTesting() {
        askName();
        long rightAnswers = getAllTasks().stream()
                .map(this::startTestingFromTask)
                .filter(answer -> answer)
                .count();
        if (rightAnswers >= getRightAnswersCount()) {
            onTestingSuccess();
        } else {
            onTestingFailed();
        }
    }

    public String askName() {
        System.out.println(helloMessage);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public boolean startTestingFromTask(Task task) {
        String printed = taskService.taskToPrettyString(task);
        System.out.println(printed);
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        int answerId = Integer.parseInt(answer) - 1;
        Answer chosenAnswer = task.getAnswers().get(answerId);
        return chosenAnswer.getIsItRight();
    }
}
