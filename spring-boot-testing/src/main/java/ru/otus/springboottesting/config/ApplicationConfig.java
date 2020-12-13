package ru.otus.springboottesting.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.springboottesting.dao.TaskDao;
import ru.otus.springboottesting.dao.TaskDaoCsv;

@Configuration
@RequiredArgsConstructor
@PropertySource("classpath:application.properties")
public class ApplicationConfig {


    @Bean
    public TaskDao taskDao(@Value("${questions.file}") String csvFileName) {
        return new TaskDaoCsv(csvFileName);
    }

    @Bean
    public Integer rightAnswersCount(@Value("${questions.answers}") Integer rightAnswersCount) {
        return rightAnswersCount;
    }

    @Bean
    public String failMessage(@Value("${questions.message.fail}") String failMessage) {
        return failMessage;
    }

    @Bean
    public String successMessage(@Value("${questions.message.success}") String successMessage) {
        return successMessage;
    }

    @Bean
    public String helloMessage(@Value("${questions.message.hello}") String helloMessage) {
        return helloMessage;
    }

}
