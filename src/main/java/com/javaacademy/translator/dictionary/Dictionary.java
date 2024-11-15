package com.javaacademy.translator.dictionary;

import com.javaacademy.translator.Language;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;


public abstract class Dictionary {
    private static final String WORD_NOT_EXISTS = "Отсутствует слово в словаре";
    protected Map<String, String> words = new HashMap<>();
    @Getter
    private final Language language;

    public Dictionary(Language language) {
        this.language = language;
    }

    public String getTranslate(String word) {
        if (!words.containsKey(word)) {
            return WORD_NOT_EXISTS;
        }
        return words.get(word);
    }

    public void addTranslate(String wordRussian, String wordTranslated) {
        words.put(wordRussian, wordTranslated);
    }

    public int countWords() {
        return words.size();
    }
}
