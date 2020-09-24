package se.melindasw.gardenchatapi.message;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageDTO {
  public Long id;
  public String sender;
  public String message;
  public LocalDateTime timestamp;

  public MessageDTO(Long id, String sender, String message, LocalDateTime timestamp) {
    this.id = id;
    this.sender = sender;
    this.message = message;
    this.timestamp = timestamp;
  }
}
