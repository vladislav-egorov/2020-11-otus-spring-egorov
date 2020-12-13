package ru.otus.boot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.boot.config.ApplicationConfig;

@Service
@RequiredArgsConstructor
public class MessageSourceService {

    private final MessageSource messageSource;
    private final ApplicationConfig applicationConfig;

    public String getMessageWithOutArgs(String code) {
        return messageSource.getMessage(code, new String[0], applicationConfig.getLocale());
    }
}
