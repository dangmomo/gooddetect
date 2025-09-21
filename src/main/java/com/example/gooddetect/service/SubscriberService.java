package com.example.gooddetect.service;

import com.example.gooddetect.model.Subscriber;

import java.util.List;
import java.util.Optional;

public interface SubscriberService {
    Subscriber save(Subscriber s);
    List<Subscriber> findAll();
    Optional<Subscriber> findById(Integer id);
    void deleteById(Integer id);
}
