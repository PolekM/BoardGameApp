package pl.boardgame.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(PublisherException.class)
    public ResponseEntity<?> publisherHandler(PublisherException publisherException){

        Error e = new Error(publisherException.getMessage(),publisherException.getCause(),HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(GameTypeException.class)
    public ResponseEntity<?> gameTypeHandler(GameTypeException gameTypeException){

        Error e = new Error(gameTypeException.getMessage(),gameTypeException.getCause(),HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
