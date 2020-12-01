package ru.otus.students.testing;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.students.testing.service.TaskService;


public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        TaskService taskService = context.getBean(TaskService.class);
        taskService.printAllTasks();
    }
}
