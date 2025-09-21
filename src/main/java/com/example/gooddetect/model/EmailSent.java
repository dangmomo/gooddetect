package com.example.gooddetect.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "EmailSent")
public class EmailSent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "subscriberID")
    private Subscriber subscriber;

    private String subject;
    private LocalDateTime timeSent;

    @Column(columnDefinition = "TEXT")
    private String content;

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Subscriber getSubscriber() { return subscriber; }
    public void setSubscriber(Subscriber subscriber) { this.subscriber = subscriber; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public LocalDateTime getTimeSent() { return timeSent; }
    public void setTimeSent(LocalDateTime timeSent) { this.timeSent = timeSent; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}

