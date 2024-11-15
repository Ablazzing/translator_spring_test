package com.javaacademy.translator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import static com.javaacademy.translator.Language.ENGLISH;
import static com.javaacademy.translator.Language.SPANISH;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles({"english"})
public class TranslatorServiceEnglishTest {
    @Autowired
    private TranslatorService translatorService;

    @Test
    public void successTranslateHello() {
        String result = translatorService.translate("Привет", ENGLISH);
        String expected = "Hello";

        assertEquals(expected, result);
    }

    @Test
    public void successAddTranslate() {
        String resultBefore = translatorService.translate("Белый", ENGLISH);
        String expectedBefore = "Отсутствует слово в словаре";
        assertEquals(expectedBefore, resultBefore);

        translatorService.addTranslate("Белый", ENGLISH, "White");

        String resultAfter = translatorService.translate("Белый", ENGLISH);
        String expectedAfter = "White";
        assertEquals(expectedAfter, resultAfter);
    }

    @Test
    public void successSizeEqualStartWordsCount() {
        int result = translatorService.countWords(ENGLISH);
        int expected = 2;

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void failTranslateHelloSpanish() {
        String result = translatorService.translate("Привет", SPANISH);
        String expected = "Перевод на такой язык не поддерживается";

        assertEquals(expected, result);
    }

    @Test
    public void checkAppName() {
        String result = translatorService.getAppName();
        String expected = "TestTranslator";
        Assertions.assertEquals(expected, result);
    }
}
