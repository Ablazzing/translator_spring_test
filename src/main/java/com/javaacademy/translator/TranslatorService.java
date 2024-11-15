package com.javaacademy.translator;

import com.javaacademy.translator.dictionary.Dictionary;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@Slf4j
public class TranslatorService {
    private Map<Language, Dictionary> dictionariesMap;
    @Value("${app.name}")
    @Getter
    private String appName;

    public TranslatorService(List<Dictionary> dictionaries) {
        dictionariesMap = new HashMap<>();
        dictionaries.forEach(dictionary -> dictionariesMap.put(dictionary.getLanguage(), dictionary));
    }

    public String translate(String wordOriginal, Language language) {
        if (!dictionariesMap.containsKey(language)) {
            return "Перевод на такой язык не поддерживается";
        }
        Dictionary dictionary = dictionariesMap.get(language);
        return dictionary.getTranslate(wordOriginal);
    }

    public void addTranslate(String wordRussian, Language language, String wordTranslate) {
        getDictionary(language)
                .ifPresent((dictionary -> dictionary.addTranslate(wordRussian, wordTranslate)));
    }

    public int countWords(Language language) {
        Dictionary dictionary = getDictionary(language)
                .orElseThrow(() -> new RuntimeException("Нет словаря под такой язык"));
        return dictionary.countWords();
    }

    private Optional<Dictionary> getDictionary(Language language) {
        return Optional.ofNullable(dictionariesMap.get(language));
    }
}
