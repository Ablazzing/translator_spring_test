package com.javaacademy.translator.dictionary;

import com.javaacademy.translator.Language;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("english")
public class EnglishDictionary extends Dictionary {

    @PostConstruct
    public void init() {
        addTranslate("Привет", "Hello");
        addTranslate("Красный", "Red");
    }

    public EnglishDictionary() {
        super(Language.ENGLISH);
    }
}
