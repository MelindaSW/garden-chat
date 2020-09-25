package se.melindasw.gardenchatapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class IncorrectRequestAdvice {

  @ResponseBody
  @ExceptionHandler(IncorrectRequestException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String incorrectRequestHandler(IncorrectRequestException incorrectReq) {
    return incorrectReq.getMessage();
  }
}
