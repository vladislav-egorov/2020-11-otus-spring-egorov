package ru.otus.students.testing.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import ru.otus.students.testing.domain.Answer;
import ru.otus.students.testing.domain.Task;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

@Getter
@AllArgsConstructor
public class TaskDaoCsv implements TaskDao {
    private final String pathToCsv;

    @Override
    @SneakyThrows
    public List<Task> findAll() {
        File csvFile = new File(getClass().getClassLoader().getResource(pathToCsv).toURI());
        Reader in = new FileReader(csvFile);
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
