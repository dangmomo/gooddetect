package com.example.gooddetect.service;

import com.example.gooddetect.model.EmailSent;

import java.util.List;
import java.util.Optional;

public interface EmailSentService {
    EmailSent save(EmailSent e);
    List<EmailSent> findAll();
    Optional<EmailSent> findById(Integer id);
    void deleteById(Integer id);
}
