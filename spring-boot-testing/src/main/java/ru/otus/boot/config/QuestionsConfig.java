package ru.otus.boot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "questions")
public class QuestionsConfig {

    private String file;
    private Integer answers;
}
