import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.students.testing.domain.Task;
import ru.otus.students.testing.service.TaskService;

import java.util.List;

public class TaskServiceTest {
    private ClassPathXmlApplicationContext context;
    private TaskService taskService;

    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext("/spring-context.xml");
        taskService = context.getBean(TaskService.class);
    }

    @After
    public void after() {
        context.close();
    }

    @Test
    public void allCsvRecordsIsNotNull() {
        List<Task> allTasks = taskService.findAllTasks();
        Assert.assertNotNull(allTasks);
    }

    @Test
    public void firstQuestionIs() {
        String knownQuestion = "Which one number is simple?";
        List<Task> allTasks = taskService.findAllTasks();
        Task task = allTasks.get(0);
        String question = task.getQuestion();
        Assert.assertEquals(knownQuestion, question);
    }

    @Test
    public void secondQuestionIsNot() {
        String knownQuestion = "Which one number is simple?";
        List<Task> allTasks = taskService.findAllTasks();
        Task task = allTasks.get(1);
        String question = task.getQuestion();
        Assert.assertNotEquals(knownQuestion, question);
    }
}