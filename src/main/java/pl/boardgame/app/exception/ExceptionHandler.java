package pl.boardgame.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(PublisherException.class)
    public ResponseEntity<?> publisherHandler(PublisherException publisherException){
        return new ResponseEntity<>(publisherException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(GameTypeException.class)
    public ResponseEntity<?> gameTypeHandler(GameTypeException gameTypeException){
        return new ResponseEntity<>(gameTypeException.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
