package com.example.gooddetect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LangController {

    @GetMapping("/change-language")
    public String changeLanguage(
            @RequestParam("lang") String lang,
            @RequestParam(value = "redirect", defaultValue = "/") String redirect) {

        // ghép lại URL để interceptor của Spring bắt được ?lang=
        String targetUrl;
        if (redirect.contains("?")) {
            // nếu trang hiện tại đã có query string thì thêm &lang=
            targetUrl = redirect + "&lang=" + lang;
        } else {
            targetUrl = redirect + "?lang=" + lang;
        }

        return "redirect:" + targetUrl;
    }
}
