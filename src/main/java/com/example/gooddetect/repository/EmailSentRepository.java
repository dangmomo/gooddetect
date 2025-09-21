package com.example.gooddetect.repository;

import com.example.gooddetect.model.EmailSent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailSentRepository extends CrudRepository<EmailSent, Integer> {
    List<EmailSent> findBySubjectContaining(String keyword);
}