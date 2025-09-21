package com.example.gooddetect.service.impl;

import com.example.gooddetect.model.Subscriber;
import com.example.gooddetect.repository.ProductRepository;
import com.example.gooddetect.repository.SubscriberRepository;
import com.example.gooddetect.service.SubscriberService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    private final SubscriberRepository repo;

    public SubscriberServiceImpl(@Qualifier("subscriberRepository") SubscriberRepository repo) {
        this.repo = repo;
    }
    @Override
    public Subscriber save(Subscriber s) { return repo.save(s); }

    @Override
    public List<Subscriber> findAll() { return (List<Subscriber>) repo.findAll(); }

    @Override
    public Optional<Subscriber> findById(Integer id) { return repo.findById(id); }

    @Override
    public void deleteById(Integer id) { repo.deleteById(id); }
}
