package com.example.gooddetect.controller;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.core.io.ClassPathResource;

@RestController
public class SubscribeController {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/subscribe")
    public String subscribe(@RequestParam String email) {
        // Validate email đơn giản
        if (email == null || !email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
            return "Email không hợp lệ";
        }

        try {
            // Sử dụng MimeMessage để gửi email HTML
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

            String subject = "🔔 Thông báo: Có người đăng ký mới trên website AI.S";
            String formattedTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy"));

            // Tải logo từ resources
//            ClassPathResource logo = new ClassPathResource("static/assets/img/logo.png");

            String htmlContent = "<div style=\"font-family: Arial, sans-serif; max-width: 600px; margin: auto; padding: 0; background-color: #f5f5f5;\">"

                    // Header với gradient và logo
                    + "<div style='background: linear-gradient(90deg, #007bff, #00c6ff); padding: 30px 20px; text-align:center; border-top-left-radius:8px; border-top-right-radius:8px;'>"
//                    + "<img src='cid:logoImage' alt='AI.S Logo' style='max-width:120px; height:auto; margin-bottom:10px;'/>"
                    + "<h2 style='color:#fff; margin:0;'>Đơn Đăng Ký Mới</h2>"
                    + "</div>"

                    // Nội dung chính dạng card
                    + "<div style='background-color:#ffffff; padding: 25px; border-radius: 0 0 8px 8px; box-shadow: 0 4px 10px rgba(0,0,0,0.05); margin-top:-5px;'>"
                    + "<p style='font-size:16px; color:#333; margin-top:0;'><strong>Xin chào,</strong></p>"
                    + "<p style='font-size:15px; color:#555;'>Một người dùng mới đã đăng ký nhận thông tin từ trang web AI.S.</p>"

                    // Chi tiết đơn
                    + "<h4 style='color:#007bff; margin-top:25px; margin-bottom:15px;'>Chi tiết Đơn Đăng Ký:</h4>"
                    + "<ul style='list-style:none; padding:0; margin:0; font-size:15px; color:#333;'>"
                    + "<li style='margin-bottom:10px;'>📧 <strong>Email:</strong> <span style='color:#007bff;'>" + email + "</span></li>"
                    + "<li style='margin-bottom:10px;'>⏰ <strong>Thời gian:</strong> <span>" + formattedTime + "</span></li>"
                    + "</ul>"

                    // Footer
                    + "<p style='text-align:center; margin-top:25px; font-size:13px; color:#888;'>Đây là email tự động. Vui lòng không trả lời.</p>"
                    + "</div>"
                    + "</div>";

            helper.setFrom("ai.sgroup209@gmail.com", "Công Ty AI.S"); // tên công ty hiển thị
            helper.setTo("ai.sgroup209@gmail.com");
            helper.setSubject(subject);
            helper.setText(htmlContent, true);

//            // Nhúng logo
//            helper.addInline("logoImage", logo);

            mailSender.send(mimeMessage);

            return "Đã gửi mail thành công!";
        } catch (MailException e) {
            System.err.println("Lỗi khi gửi mail: " + e.getMessage());
            return "Lỗi khi gửi mail.";
        } catch (Exception e) {
            System.err.println("Lỗi khi tạo email: " + e.getMessage());
            return "Lỗi khi tạo email.";
        }
    }
}
