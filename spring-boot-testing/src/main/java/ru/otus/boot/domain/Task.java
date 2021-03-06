package ru.otus.boot.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Task {

    private final String question;
    private final List<Answer> answers;

}
