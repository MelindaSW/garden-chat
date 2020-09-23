package se.melindasw.gardenchatapi.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
        LocalDate timestamp = LocalDate.now();
        Message m = new Message(message.getMessage(), message.getSender(), timestamp);
        service.addMessage(m);
        return "Message was posted";
    }

    @GetMapping("/getallmessages")
    public List<MessageDTO> getAllMessages() {
        return service.getAllMessages();
    }

    @GetMapping("/getonemessage/{id}")
    public MessageDTO getOneMessage(@PathVariable Long id) {
        return service.getOneMessage(id);
    }
}
