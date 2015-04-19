package softwarequality.hw03.gradientgenerator.utils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created on 20.04.2015.
 *
 * @author Vladimir Caniga
 */
public class WrongInputExceptionTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    public static void exceptionThrower(int type) throws WrongInputException {
        switch (type) {
            case 0:
                throw new WrongInputException();
            case 1:
                throw new WrongInputException(new NullPointerException());
            case 2:
                throw new WrongInputException("Just an exception.");
            case 3:
                throw new WrongInputException("Null pointer exception.", new NullPointerException());
        }
    }

    @Test
    public void wrongInputExceptionEmptyTest() throws WrongInputException {
        expectedException.expect(WrongInputException.class);
        exceptionThrower(0);
    }

    @Test
    public void wrongInputExceptionThrowableTest() throws WrongInputException {
        try {
            exceptionThrower(1);
            fail();
        } catch (WrongInputException e) {
            assertSame(NullPointerException.class, e.getCause().getClass());
        }
    }

    @Test
    public void wrongInputExceptionMessageTest() throws WrongInputException {
        try {
            exceptionThrower(2);
            fail();
        } catch (WrongInputException e) {
            assertEquals("Just an exception.", e.getMessage());
        }
    }

    @Test
    public void wrongExceptionMessageThrowableTest() throws WrongInputException {
        try {
            exceptionThrower(3);
            fail();
        } catch (WrongInputException e) {
            assertEquals("Null pointer exception.", e.getMessage());
            assertSame(NullPointerException.class, e.getCause().getClass());
        }
    }

}