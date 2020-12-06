package ru.otus.students.testing.service;

import org.apache.commons.lang3.StringUtils;
import ru.otus.students.testing.domain.Answer;
import ru.otus.students.testing.domain.Task;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface TaskService {
    List<Task> findAllTasks();

    default void printAllTasks() {
        List<Task> allTasks = findAllTasks();
        List<String> collect = allTasks.stream().map(this::taskToPrettyString).collect(Collectors.toList());
        System.out.println(StringUtils.join(collect, "\n"));
    }

    default String taskToPrettyString(Task task) {
        String question = task.getQuestion();
        List<Answer> answers = task.getAnswers();
        List<String> collect = IntStream.range(0, answers.size()).mapToObj(
                idx -> {
                    Answer answer = answers.get(idx);
                    // +1 for easy reading
                    return StringUtils.join(idx + 1, ".", answer.getAnswer());
                }
        ).collect(Collectors.toList());
        String join = StringUtils.join(collect, "\n");
        return StringUtils.join(question + "\n", join);
    }
}
