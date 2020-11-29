package ru.otus.students.testing.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Answer {
    private final String answer;
    private final Boolean isItRight;
}
