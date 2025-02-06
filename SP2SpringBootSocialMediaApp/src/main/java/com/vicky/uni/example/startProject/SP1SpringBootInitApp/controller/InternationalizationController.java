package com.vicky.uni.example.startProject.SP1SpringBootInitApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class InternationalizationController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "goodMorningInternationalize")
    public String getGoodMorning() {

        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.text", null, "Default Message", locale);
    }
}
