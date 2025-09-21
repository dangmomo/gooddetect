package com.example.gooddetect.service.impl;

import com.example.gooddetect.model.EmailSent;
import com.example.gooddetect.repository.EmailSentRepository;
import com.example.gooddetect.repository.SubscriberRepository;
import com.example.gooddetect.service.EmailSentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailSentServiceImpl implements EmailSentService {

    private final EmailSentRepository repo;

    public EmailSentServiceImpl(@Qualifier("emailSentRepository") EmailSentRepository repo) {
        this.repo = repo;
    }
    @Override
    public EmailSent save(EmailSent e) { return repo.save(e); }

    @Override
    public List<EmailSent> findAll() { return (List<EmailSent>) repo.findAll(); }

    @Override
    public Optional<EmailSent> findById(Integer id) { return repo.findById(id); }

    @Override
    public void deleteById(Integer id) { repo.deleteById(id); }
}
