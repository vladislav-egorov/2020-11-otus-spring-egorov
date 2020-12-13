package ru.otus.boot.dao;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import ru.otus.boot.config.QuestionsConfig;
import ru.otus.boot.domain.Answer;
import ru.otus.boot.domain.Task;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class TaskDaoCsv implements TaskDao {

    private final QuestionsConfig questionsConfig;

    @Override
    @SneakyThrows
    public List<Task> findAll() {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(questionsConfig.getFile());
        Reader in = new InputStreamReader(resourceAsStream);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
        return StreamSupport.stream(records.spliterator(), false)
                .map(record -> {
                    List<Answer> answers = new ArrayList<>();
                    IntStream.range(1, record.size()).forEach(
                            index -> {
                                // First answer is the right one for a while
                                Answer currentAnswer = new Answer(record.get(index), index == 1);
                                answers.add(currentAnswer);
                            }
                    );
                    return new Task(record.get(0), answers);
                }).collect(Collectors.toList());
    }
}
