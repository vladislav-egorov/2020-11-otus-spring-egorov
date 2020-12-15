package ru.otus.boot.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.otus.boot.dao.TaskDao;
import ru.otus.boot.domain.Answer;
import ru.otus.boot.domain.Task;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest
public class TaskServiceTest {

    @Mock
    TaskDao taskDao;
    @InjectMocks
    TaskServiceImpl taskService;

    @BeforeEach
    void init() {
        List<Answer> answers = List.of(
                new Answer("answer1", true),
                new Answer("answer2", false)
        );
        Task testTask = new Task("First task", answers);
        when(taskDao.findAll()).thenReturn(List.of(testTask));
    }

    @Test
    void tasksAreNotNullAndNotEmpty() {
        assertThat(taskService.findAllTasks()).isNotNull().isNotEmpty();
    }


    @Test
    void firstTaskRightAnswerIs() {
        Task task = taskService.findAllTasks().get(0);
        Answer answer = task.getAnswers().get(0);
        assertTrue(answer.getIsItRight());
    }
}