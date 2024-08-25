package tp1.control.Exceptions;

public class CommandParseException extends Exception{

    public CommandParseException(String err){
        super(err);
    }

    public CommandParseException() {
    }

    public CommandParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommandParseException(Throwable cause) {
        super(cause);
    }

    public CommandParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
