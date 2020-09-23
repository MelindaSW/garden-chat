package se.melindasw.gardenchatapi.message;


import java.util.List;

public interface MessageService {
    String addMessage(Message messageDetails);
    List<MessageDTO> getAllMessages();
    MessageDTO getOneMessage(Long id);
}
