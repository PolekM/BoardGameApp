package pl.boardgame.app.exception;

public class GameTypeException extends Exception{

    public GameTypeException(String massage){
        super(massage);
    }

    public GameTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
