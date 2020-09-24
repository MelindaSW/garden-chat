package se.melindasw.gardenchatapi.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

  private final MessageRepo repo;

  @Autowired
  public MessageServiceImpl(MessageRepo repo) {
    this.repo = repo;
  }

  @Override
  public String addMessage(Message messageDetails) {
    repo.save(messageDetails);
    return "Message was posted";
  }

  @Override
  public List<MessageDTO> getAllMessages() {
    List<Message> messages = repo.findAll();
    List<MessageDTO> messageDTOS = new ArrayList<>();
    for (Message msg : messages) {
      messageDTOS.add(convertToDTO(msg));
    }
    return messageDTOS;
  }

  @Override
  public MessageDTO getOneMessage(Long id) {
    Message msg;
    if (repo.findById(id).isPresent()) {
      msg = repo.findById(id).get();
      return convertToDTO(msg);
    }
    return new MessageDTO(null, "Unknown", "Unknown", LocalDateTime.now());
  }

  @Override
  public String deleteMessage(Long id) {
    repo.deleteById(id);
    return "Message with id " + id + " was deleted";
  }

  public MessageDTO convertToDTO(Message message) {
    return new MessageDTO(
        message.getId(), message.getSender(), message.getMessage(), message.getTimestamp());
  }
}
