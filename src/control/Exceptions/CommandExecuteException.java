package tp1.control.Exceptions;

public class CommandExecuteException extends Exception{

    public CommandExecuteException(String err){
        super(err);
    }

    public CommandExecuteException() {
    }

    public CommandExecuteException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommandExecuteException(Throwable cause) {
        super(cause);
    }

    public CommandExecuteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
