package ru.otus.boot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.boot.config.QuestionsConfig;
import ru.otus.boot.domain.Answer;
import ru.otus.boot.domain.Task;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class ConsoleTestingService implements TestingService {

    private final TaskService taskService;
    private final QuestionsConfig questionsConfig;
    private final MessageSourceService messageSourceService;

    public List<Task> getAllTasks() {
        return taskService.findAllTasks();
    }

    public Integer getRightAnswersCount() {
        return questionsConfig.getAnswers();
    }

    public void onTestingFailed() {
        System.out.println(messageSourceService.getMessageWithOutArgs("fail"));
    }

    public void onTestingSuccess() {
        System.out.println(messageSourceService.getMessageWithOutArgs("success"));
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
        System.out.println(messageSourceService.getMessageWithOutArgs("hello"));
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
