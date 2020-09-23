package se.melindasw.gardenchatapi.message;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @Column(nullable = false)
    public String sender;
    @Column(nullable = false)
    public String message;
    public LocalDate timestamp;

    public Message() {}

    public Message(String sender, String message, LocalDate timestamp) {
        this.sender = sender;
        this.message = message;
        this.timestamp = timestamp;
    }
}
