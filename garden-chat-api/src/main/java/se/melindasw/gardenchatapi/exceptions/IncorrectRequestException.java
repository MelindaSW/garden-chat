package se.melindasw.gardenchatapi.exceptions;

public class IncorrectRequestException extends RuntimeException {
  public IncorrectRequestException() {
    super("Request is incorrect. One or more parameters are missing");
  }
}
