package ru.otus.boot.runner;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.otus.boot.service.TestingService;

@Component
@Profile("!test")
@RequiredArgsConstructor
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final TestingService testingService;

    @Override
    public void run(String... args) {
        testingService.startTesting();
    }
}
