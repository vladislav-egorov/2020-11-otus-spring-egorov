package ru.otus.students.testing;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.students.testing.domain.Task;
import ru.otus.students.testing.service.TaskService;

import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        TaskService taskService = context.getBean(TaskService.class);
        List<Task> allTasks = taskService.findAllTasks();
        List<String> collect = allTasks.stream().map(taskService::taskToPettyString).collect(Collectors.toList());
        System.out.println(StringUtils.join(collect, "\n"));
        context.close();
    }
}
