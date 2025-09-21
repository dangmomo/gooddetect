package com.example.gooddetect.controller;

import jakarta.servlet.http.HttpServletRequest;   // nếu bạn dùng Spring Boot 3
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;              // <--- phải import cái này
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpServletRequest request, Model model) {
        // đưa URL hiện tại xuống view
        model.addAttribute("currentUri", request.getRequestURI());
        return "index"; // templates/index.html
    }
}
