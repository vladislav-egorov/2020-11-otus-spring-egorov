import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.students.testing.dao.TaskDao;
import ru.otus.students.testing.domain.Answer;
import ru.otus.students.testing.domain.Task;
import ru.otus.students.testing.service.TaskService;
import ru.otus.students.testing.service.TaskServiceImpl;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    TaskDao taskDao;
    TaskService taskService;

    @BeforeEach
    void init() {
        taskService = new TaskServiceImpl(taskDao);
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
