package com.javaacademy.translator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class TranslatorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TranslatorApplication.class, args);
		TranslatorService translatorService = context.getBean(TranslatorService.class);
		String resultEnglish = translatorService.translate("Привет", Language.ENGLISH);
		log.info(resultEnglish);
		String resultSpanish = translatorService.translate("Привет", Language.SPANISH);
		log.info(resultSpanish);
	}

}
