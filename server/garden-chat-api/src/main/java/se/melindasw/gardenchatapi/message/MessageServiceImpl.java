package se.melindasw.gardenchatapi.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
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
        Message msg = repo.findById(id).get();
        return convertToDTO(msg);
    }

    public MessageDTO convertToDTO(Message message) {
        return new MessageDTO(message.getId(), message.getSender(), message.getMessage(), message.getTimestamp());
    }
}

