package se.melindasw.gardenchatapi.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.melindasw.gardenchatapi.exceptions.IncorrectRequestException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class MessageController {

  private final MessageService service;

  @Autowired
  public MessageController(MessageService service) {
    this.service = service;
  }

  @PostMapping("/postmessage")
  public String postMessage(@RequestBody MessageDTO message) {
    if (message.getSender() == null || message.getMessage() == null) {
      throw new IncorrectRequestException();
    }
    LocalDateTime timestamp = LocalDateTime.now();
    Message m = new Message(message.getMessage(), message.getSender(), timestamp);
    return service.addMessage(m);
  }

  @GetMapping("/getallmessages")
  public List<MessageDTO> getAllMessages() {
    return service.getAllMessages();
  }

  @GetMapping("/getonemessage/{id}")
  public MessageDTO getOneMessage(@PathVariable Long id) {
    return service.getOneMessage(id);
  }

  @DeleteMapping("/deletemessage/{id}")
  public String deleteOneMessage(@PathVariable Long id) {
    return service.deleteMessage(id);
  }
}
