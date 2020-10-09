package se.melindasw.gardenchatapi.jms;

import com.google.gson.Gson;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.util.Map;

@Component
public class Listener {

  @JmsListener(destination = "inbound.garden.queue")
  @SendTo("outbound.garden.queue")
  public String receiveMessage(final TextMessage jsonMessage) throws JMSException {
    String messageData = null;
    System.out.println("Received message " + jsonMessage);
    String response = null;
    if (jsonMessage != null) {
      messageData = ((TextMessage) jsonMessage).getText();
      Map map = new Gson().fromJson(messageData, Map.class);
      response = "Hello " + map.get("name");
    }
    System.out.println("Queueresponse" + response);
    return response;
  }

  @JmsListener(destination = "inbound.garden.topic")
  @SendTo("outbound.garden.topic")
  public String receiveMessageFromTopic(final TextMessage jsonMessage) throws JMSException {
    String messageData;
    System.out.println("Received message " + jsonMessage);
    String response = null;
    if (jsonMessage != null) {
      messageData = ((TextMessage) jsonMessage).getText();
      Map map = new Gson().fromJson(messageData, Map.class);
      response = "Hello " + map.get("name");
    }
    System.out.println("Topicresponse" + response);
    return response;
  }
}
