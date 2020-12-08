package ru.otus.students.testing;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.students.testing.service.TestingService;

@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        TestingService testingService = context.getBean(TestingService.class);
        testingService.startTesting();
    }
}
