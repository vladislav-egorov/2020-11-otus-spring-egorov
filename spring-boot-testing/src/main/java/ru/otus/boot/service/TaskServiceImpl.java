package ru.otus.boot.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.otus.boot.dao.TaskDao;
import ru.otus.boot.domain.Answer;
import ru.otus.boot.domain.Task;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskDao taskDao;

    @Override
    public List<Task> findAllTasks() {
        return taskDao.findAll();
    }

    @Override
    public String taskToPrettyString(Task task) {
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
