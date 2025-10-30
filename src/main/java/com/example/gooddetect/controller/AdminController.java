//package com.example.gooddetect.controller;
//
//import com.example.gooddetect.service.SubscriberService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequestMapping("/admin")
//public class AdminController {
//
//    private final SubscriberService subscriberService;
//
//    public AdminController(SubscriberService subscriberService) {
//        this.subscriberService = subscriberService;
//    }
//
//    @GetMapping("/send-confirmation")
//    public String sendSubscriberConfirmation(@RequestParam("email") String email) {
//        subscriberService.sendSubscriberConfirmation(email);
//        return "redirect:/admin/subscribers?sent=true"; // hoặc trả về trang thông báo
//    }
//}
//
