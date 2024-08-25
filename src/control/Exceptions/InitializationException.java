package tp1.control.Exceptions;

public class InitializationException extends Exception{

    public InitializationException(String err){
        super(err);
    }

    public InitializationException() {
    }

    public InitializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InitializationException(Throwable cause) {
        super(cause);
    }

    public InitializationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
