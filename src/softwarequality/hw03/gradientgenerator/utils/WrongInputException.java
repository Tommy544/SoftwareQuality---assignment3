package softwarequality.hw03.gradientgenerator.utils;

/**
 * Created by vcaniga on 4/19/15.
 */
public class WrongInputException extends Exception {

    public WrongInputException() {
        super();
    }

    public WrongInputException(Throwable cause) {
        super(cause);
    }

    public WrongInputException(String message) {
        super(message);
    }

    public WrongInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
