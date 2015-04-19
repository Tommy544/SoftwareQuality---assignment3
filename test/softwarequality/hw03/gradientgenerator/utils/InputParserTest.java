package softwarequality.hw03.gradientgenerator.utils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * Created on 19.04.2015.
 *
 * @author Vladimir Caniga
 */
public class InputParserTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void getSettingsRadialTest() throws Exception {
        String input = "60 70" + System.lineSeparator() + " .,:;xXQ@" + System.lineSeparator() + "radial 15 20 25" +
                System.lineSeparator();
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        InputParser inputParser = new InputParser();
        Settings settings = inputParser.getSettings();

        assertEquals(70, settings.height);
        assertEquals(60, settings.width);
        assertEquals(" .,:;xXQ@", String.valueOf(settings.colors));
        assertEquals("radial", settings.type);
        assertEquals(15, settings.startPoint.x);
        assertEquals(20, settings.startPoint.y);
        assertEquals(25, settings.radius, 0.000001);
    }

    @Test
    public void getSettingsLinearTest() throws Exception {
        String input = "65 75" + System.lineSeparator() + "abcdef" + System.lineSeparator() + "linear 15 20 55 60" +
                System.lineSeparator();
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        InputParser inputParser = new InputParser();
        Settings settings = inputParser.getSettings();

        assertEquals(75, settings.height);
        assertEquals(65, settings.width);
        assertEquals("abcdef", String.valueOf(settings.colors));
        assertEquals("linear", settings.type);
        assertEquals(15, settings.startPoint.x);
        assertEquals(20, settings.startPoint.y);
        assertEquals(55, settings.endPoint.x);
        assertEquals(60, settings.endPoint.y);
    }

    @Test
    public void getSettingsIllegalHeightParameter() throws WrongInputException {
        String input = "65 aa" + System.lineSeparator() + "abcdef" + System.lineSeparator() + "linear 15 20 55 60" +
                System.lineSeparator();
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        InputParser inputParser = new InputParser();
        expectedException.expect(WrongInputException.class);
        inputParser.getSettings();
    }

    @Test
    public void getSettingsIllegalStartPointParameter() throws WrongInputException {
        String input = "65 70" + System.lineSeparator() + "abcdef" + System.lineSeparator() + "linear aa 20 55 60" +
                System.lineSeparator();
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        InputParser inputParser = new InputParser();
        expectedException.expect(WrongInputException.class);
        inputParser.getSettings();
    }

    @Test
    public void getSettingsIllegalEndPointParameter() throws WrongInputException {
        String input = "65 70" + System.lineSeparator() + "abcdef" + System.lineSeparator() + "linear 15 20 55 aa" +
                System.lineSeparator();
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        InputParser inputParser = new InputParser();
        expectedException.expect(WrongInputException.class);
        inputParser.getSettings();
    }

    @Test
    public void getSettingsIllegalRadiusParameter() throws WrongInputException {
        String input = "65 70" + System.lineSeparator() + "abcdef" + System.lineSeparator() + "radial 15 20 aa" +
                System.lineSeparator();
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        InputParser inputParser = new InputParser();
        expectedException.expect(WrongInputException.class);
        inputParser.getSettings();
    }

    @Test
    public void getSettingsMissingHeightParameter() throws WrongInputException {
        String input = "65" + System.lineSeparator() + "abcdef" + System.lineSeparator() + "radial 15 20 20" +
                System.lineSeparator();
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        InputParser inputParser = new InputParser();
        expectedException.expect(WrongInputException.class);
        inputParser.getSettings();
    }

    @Test
    public void getSettingsMissingRadiusParameter() throws WrongInputException {
        String input = "65 70" + System.lineSeparator() + "abcdef" + System.lineSeparator() + "radial 15 20" +
                System.lineSeparator();
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        InputParser inputParser = new InputParser();
        expectedException.expect(WrongInputException.class);
        inputParser.getSettings();
    }

}