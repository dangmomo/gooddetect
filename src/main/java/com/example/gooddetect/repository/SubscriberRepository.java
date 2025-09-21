package com.example.gooddetect.repository;


import com.example.gooddetect.model.Subscriber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriberRepository extends CrudRepository<Subscriber, Integer> {
    List<Subscriber> findByEmailContaining(String keyword);
}