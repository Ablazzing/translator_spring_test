package com.javaacademy.translator.dictionary;

import com.javaacademy.translator.Language;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("spanish")
public class SpanishDictionary extends Dictionary {

    @PostConstruct
    public void init() {
        addTranslate("Привет", "Hola");
        addTranslate("Красный", "Rojo");
    }

    public SpanishDictionary() {
        super(Language.SPANISH);
    }
}
