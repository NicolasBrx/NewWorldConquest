package tools;

/**
 * 
 * @author Nicolas Brax
 */
public class WCException extends Exception {

    public WCException(String message) {
        super(message);
    }

    public WCException(String message, Throwable throwable) {
        super(message, throwable);
    }
}