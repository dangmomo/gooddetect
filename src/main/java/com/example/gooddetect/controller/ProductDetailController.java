package com.example.gooddetect.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductDetailController {
    @GetMapping("product")
    public String index(HttpServletRequest request, Model model) {
        model.addAttribute("currentUri", request.getRequestURI());
        return "product";
    }
}
