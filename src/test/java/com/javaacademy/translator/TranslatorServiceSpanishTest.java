package com.javaacademy.translator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static com.javaacademy.translator.Language.SPANISH;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles({"spanish"})
public class TranslatorServiceSpanishTest {
    @Autowired
    private TranslatorService translatorService;

    @Test
    public void successTranslateHello() {
        String result = translatorService.translate("Привет", SPANISH);
        String expected = "Hola";

        assertEquals(expected, result);
    }




}
