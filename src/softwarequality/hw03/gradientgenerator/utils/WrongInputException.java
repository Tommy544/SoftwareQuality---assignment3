package softwarequality.hw03.gradientgenerator.utils;

/**
 * Created on 19.04.2015.
 *
 * @author Vladimir Caniga
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
