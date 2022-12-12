package pl.boardgame.app.exception;

public class PublisherException  extends Exception{

    public PublisherException(String massage){ super(massage);}

    public PublisherException(String message, Throwable cause) {
        super(message, cause);
    }
}
