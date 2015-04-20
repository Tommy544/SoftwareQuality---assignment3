package softwarequality.hw03.gradientgenerator.utils;

/**
 * Custom exception used in InputParser
 *
 * Created on 19.04.2015.
 *
 * @author Vladimir Caniga
 * @author Jakub Smolar
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
