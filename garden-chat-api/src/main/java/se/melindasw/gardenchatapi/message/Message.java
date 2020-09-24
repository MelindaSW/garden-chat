package se.melindasw.gardenchatapi.message;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

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

  public LocalDateTime timestamp;

  public Message() {}

  public Message(String sender, String message, LocalDateTime timestamp) {
    this.sender = sender;
    this.message = message;
    this.timestamp = timestamp;
  }
}
