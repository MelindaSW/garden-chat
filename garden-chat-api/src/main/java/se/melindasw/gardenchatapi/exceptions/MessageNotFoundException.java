package se.melindasw.gardenchatapi.exceptions;

public class MessageNotFoundException extends RuntimeException {
  public MessageNotFoundException(Long id) {
    super(String.format("Message with id %d not found", id));
  }
}
