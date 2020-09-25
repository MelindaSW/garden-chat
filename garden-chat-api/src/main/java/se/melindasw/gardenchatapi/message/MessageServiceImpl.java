package se.melindasw.gardenchatapi.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import se.melindasw.gardenchatapi.exceptions.MessageNotFoundException;

import javax.persistence.EntityNotFoundException;
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
    MessageDTO msg = null;
    try {
      msg = convertToDTO(repo.getOne(id));
    } catch (EntityNotFoundException e) {
      throw new MessageNotFoundException(id);
    }
    return msg;
  }

  @Override
  public String deleteMessage(Long id) {
    try {
      repo.deleteById(id);
    } catch (EmptyResultDataAccessException e) {
      throw new MessageNotFoundException(id);
    }
    return "Message with id " + id + " was deleted";
  }

  public MessageDTO convertToDTO(Message message) {
    return new MessageDTO(
        message.getId(), message.getSender(), message.getMessage(), message.getTimestamp());
  }
}
