package com.example.gooddetect.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Subscriber")
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;
    private Boolean status; // true = đã trả lời
    private LocalDateTime timeSent;
    private Boolean flag;   // true = đã thành khách

    @OneToMany(mappedBy = "subscriber", cascade = CascadeType.ALL)
    private List<EmailSent> emailsSent;

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }

    public LocalDateTime getTimeSent() { return timeSent; }
    public void setTimeSent(LocalDateTime timeSent) { this.timeSent = timeSent; }

    public Boolean getFlag() { return flag; }
    public void setFlag(Boolean flag) { this.flag = flag; }

    public List<EmailSent> getEmailsSent() { return emailsSent; }
    public void setEmailsSent(List<EmailSent> emailsSent) { this.emailsSent = emailsSent; }
}

