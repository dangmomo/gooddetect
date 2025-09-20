package com.example.gooddetect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LangController {

    @GetMapping("/change-language")
    public String changeLanguage(@RequestParam String lang,
                                 @RequestParam(required = false, defaultValue = "/") String redirect) {
        // trả về redirect kèm lang để interceptor bắt được
        return "redirect:" + redirect + "?lang=" + lang;
    }
}
