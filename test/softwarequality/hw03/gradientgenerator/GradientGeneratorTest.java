package softwarequality.hw03.gradientgenerator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created on 19.04.2015.
 *
 * @author Vladimir Caniga
 */
public class GradientGeneratorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void getProgramUsageTest() {
        String expected = "Program usage:" + System.lineSeparator() + "num_columns num_rows" + System.lineSeparator()
                + "colors (for example: .,:;xXQ)" + System.lineSeparator() + "Two options:" + System.lineSeparator()
                + "\t'radial' center_x center_y radius" + System.lineSeparator()
                + "\t'linear' start_x start_y end_x end_y" + System.lineSeparator();
        String result = GradientGenerator.getProgramUsage();

        assertEquals(expected, result);
    }

    @Test
    public void generateLinearNegativeWidthTest() {
        expectedException.expect(IllegalArgumentException.class);
        GradientGenerator.generateLinear(-10, 15, ".,:;xXQ@".toCharArray(), new Point(0, 0), new Point(1, 1));
    }

    @Test
    public void generateLinearEmptyColorsTest() {
        expectedException.expect(IllegalArgumentException.class);
        GradientGenerator.generateLinear(10, 15, "".toCharArray(), new Point(0, 0), new Point(1, 1));
    }

    @Test
    public void generateLinearNullPointTest() {
        expectedException.expect(NullPointerException.class);
        GradientGenerator.generateLinear(10, 15, ".,:;xXQ@".toCharArray(), new Point(0, 0), null);
    }

    @Test
    public void generateLinearTest() {
        String expected = "...............,,,,::::;;;;;xx\n" +
                "..............,,,,::::;;;;;xxx\n" +
                ".............,,,,::::;;;;;xxxx\n" +
                "............,,,,::::;;;;;xxxxX\n" +
                "...........,,,,::::;;;;;xxxxXX\n" +
                "..........,,,,::::;;;;;xxxxXXX\n" +
                ".........,,,,::::;;;;;xxxxXXXX\n" +
                "........,,,,::::;;;;;xxxxXXXXQ\n" +
                ".......,,,,::::;;;;;xxxxXXXXQQ\n" +
                "......,,,,::::;;;;;xxxxXXXXQQQ\n" +
                ".....,,,,::::;;;;;xxxxXXXXQQQQ\n" +
                "....,,,,::::;;;;;xxxxXXXXQQQQQ\n" +
                "...,,,,::::;;;;;xxxxXXXXQQQQ@@\n" +
                "..,,,,::::;;;;;xxxxXXXXQQQQQ@@\n" +
                ".,,,,::::;;;;;xxxxXXXXQQQQ@@@@\n" +
                ",,,,::::;;;;;xxxxXXXXQQQQQ@@@@\n" +
                ",,,::::;;;;;xxxxXXXXQQQQQ@@@@@\n" +
                ",,::::;;;;;xxxxXXXXQQQQ@@@@@@@\n" +
                ",::::;;;;;xxxxXXXXQQQQ@@@@@@@@\n" +
                "::::;;;;;xxxxXXXXQQQQQ@@@@@@@@\n" +
                ":::;;;;;xxxxXXXXQQQQQ@@@@@@@@@\n" +
                "::;;;;;xxxxXXXXQQQQQ@@@@@@@@@@\n" +
                ":;;;;;xxxxXXXXQQQQ@@@@@@@@@@@@\n" +
                ";;;;;xxxxXXXXQQQQ@@@@@@@@@@@@@\n" +
                ";;;;xxxxXXXXQQQQQ@@@@@@@@@@@@@\n" +
                ";;;xxxxXXXXQQQQQ@@@@@@@@@@@@@@\n" +
                ";;xxxxXXXXQQQQ@@@@@@@@@@@@@@@@\n" +
                ";xxxxXXXXQQQQQ@@@@@@@@@@@@@@@@\n" +
                "xxxxXXXXQQQQ@@@@@@@@@@@@@@@@@@\n" +
                "xxxXXXXQQQQQ@@@@@@@@@@@@@@@@@@\n";
        String result = GradientGenerator.generateLinear(30, 30, ".,:;xXQ@".toCharArray(), new Point(5, 5), new Point(20, 20));
        assertEquals(expected, result);
    }


    @Test
    public void generateRadialNegativeWidthTest() {
        expectedException.expect(IllegalArgumentException.class);
        GradientGenerator.generateRadial(-10, 15, ".,:;xXQ@".toCharArray(), new Point(5, 5), 10);
    }

    @Test
    public void generateRadialNegativeRadiusTest() {
        expectedException.expect(IllegalArgumentException.class);
        GradientGenerator.generateRadial(10, 15, ".,:;xXQ@".toCharArray(), new Point(5, 5), -10);
    }

    @Test
    public void generateRadialEmptyColorsTest() {
        expectedException.expect(IllegalArgumentException.class);
        GradientGenerator.generateRadial(10, 15, "".toCharArray(), new Point(5, 5), 10);
    }

    @Test
    public void generateRadialNullPointTest() {
        expectedException.expect(NullPointerException.class);
        GradientGenerator.generateRadial(10, 15, ".,:;xXQ@".toCharArray(), null, 10);
    }

    @Test
    public void generateRadialTest() {
        String expected = "@@@@@@@@@@@QQQQQQQQQ@@@@@@@@@@\n" +
                "@@@@@@@@QQQQQQQQQQQQQQQ@@@@@@@\n" +
                "@@@@@@@QQQQQXXXXXXXQQQQQ@@@@@@\n" +
                "@@@@@QQQQXXXXXXXXXXXXXQQQQ@@@@\n" +
                "@@@@QQQQXXXXXxxxxxXXXXXQQQQ@@@\n" +
                "@@@QQQXXXXxxxxxxxxxxxXXXXQQQ@@\n" +
                "@@@QQXXXXxxxxxxxxxxxxxXXXXQQ@@\n" +
                "@@QQQXXXxxx;;;;;;;;;xxxXXXQQQ@\n" +
                "@QQQXXXxxx;;;;;;;;;;;xxxXXXQQQ\n" +
                "@QQXXXxxx;;;:::::::;;;xxxXXXQQ\n" +
                "@QQXXxxx;;;:::::::::;;;xxxXXQQ\n" +
                "QQQXXxx;;;:::,,,,,:::;;;xxXXQQ\n" +
                "QQXXXxx;;:::,,,,,,,:::;;xxXXXQ\n" +
                "QQXXxxx;;::,,,...,,,::;;xxxXXQ\n" +
                "QQXXxxx;;::,,.....,,::;;xxxXXQ\n" +
                "QQXXxxx;;::,,.....,,::;;xxxXXQ\n" +
                "QQXXxxx;;::,,.....,,::;;xxxXXQ\n" +
                "QQXXxxx;;::,,,...,,,::;;xxxXXQ\n" +
                "QQXXXxx;;:::,,,,,,,:::;;xxXXXQ\n" +
                "QQQXXxx;;;:::,,,,,:::;;;xxXXQQ\n" +
                "@QQXXxxx;;;:::::::::;;;xxxXXQQ\n" +
                "@QQXXXxxx;;;:::::::;;;xxxXXXQQ\n" +
                "@QQQXXXxxx;;;;;;;;;;;xxxXXXQQQ\n" +
                "@@QQQXXXxxx;;;;;;;;;xxxXXXQQQ@\n" +
                "@@@QQXXXXxxxxxxxxxxxxxXXXXQQ@@\n" +
                "@@@QQQXXXXxxxxxxxxxxxXXXXQQQ@@\n" +
                "@@@@QQQQXXXXXxxxxxXXXXXQQQQ@@@\n" +
                "@@@@@QQQQXXXXXXXXXXXXXQQQQ@@@@\n" +
                "@@@@@@@QQQQQXXXXXXXQQQQQ@@@@@@\n" +
                "@@@@@@@@QQQQQQQQQQQQQQQ@@@@@@@\n";
        String result = GradientGenerator.generateRadial(30, 30, ".,:;xXQ@".toCharArray(), new Point(15, 15), 18);
        assertEquals(expected, result);
    }

    @Test
    public void mainLinearTest() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        String input = "30 30" + System.lineSeparator() + ".,:;xXQ@" + System.lineSeparator() + "linear 0 0 20 20" +
                System.lineSeparator();
        ByteArrayInputStream is = new ByteArrayInputStream(input.getBytes());

        System.setIn(is);
        System.setOut(new PrintStream(os));

        GradientGenerator.main(new String[]{});

        String expected = "......,,,,,,::::::;;;;;xxxxxxX\n" +
                ".....,,,,,,::::::;;;;;xxxxxxXX\n" +
                "....,,,,,,::::::;;;;;xxxxxxXXX\n" +
                "...,,,,,,::::::;;;;;xxxxxxXXXX\n" +
                "..,,,,,,::::::;;;;;xxxxxxXXXXX\n" +
                ".,,,,,,::::::;;;;;xxxxxxXXXXXX\n" +
                ",,,,,,::::::;;;;;xxxxxxXXXXXXQ\n" +
                ",,,,,::::::;;;;;xxxxxxXXXXXXQQ\n" +
                ",,,,::::::;;;;;xxxxxxXXXXXXQQQ\n" +
                ",,,::::::;;;;;xxxxxxXXXXXXQQQQ\n" +
                ",,::::::;;;;;xxxxxxXXXXXXQQQQQ\n" +
                ",::::::;;;;;xxxxxxXXXXXXQQQQQQ\n" +
                "::::::;;;;;xxxxxxXXXXXXQQQQQQ@\n" +
                ":::::;;;;;xxxxxxXXXXXXQQQQQQ@@\n" +
                "::::;;;;;xxxxxxXXXXXXQQQQQQ@@@\n" +
                ":::;;;;;xxxxxxXXXXXXQQQQQQ@@@@\n" +
                "::;;;;;xxxxxxXXXXXXQQQQQQ@@@@@\n" +
                ":;;;;;xxxxxxXXXXXXQQQQQ@@@@@@@\n" +
                ";;;;;xxxxxxXXXXXXQQQQQQ@@@@@@@\n" +
                ";;;;xxxxxxXXXXXXQQQQQQ@@@@@@@@\n" +
                ";;;xxxxxxXXXXXXQQQQQQ@@@@@@@@@\n" +
                ";;xxxxxxXXXXXXQQQQQQ@@@@@@@@@@\n" +
                ";xxxxxxXXXXXXQQQQQQ@@@@@@@@@@@\n" +
                "xxxxxxXXXXXXQQQQQ@@@@@@@@@@@@@\n" +
                "xxxxxXXXXXXQQQQQQ@@@@@@@@@@@@@\n" +
                "xxxxXXXXXXQQQQQQ@@@@@@@@@@@@@@\n" +
                "xxxXXXXXXQQQQQQ@@@@@@@@@@@@@@@\n" +
                "xxXXXXXXQQQQQQ@@@@@@@@@@@@@@@@\n" +
                "xXXXXXXQQQQQQ@@@@@@@@@@@@@@@@@\n" +
                "XXXXXXQQQQQQ@@@@@@@@@@@@@@@@@@\n";

        assertEquals(expected, os.toString());
    }

    @Test
    public void mainRadialTest() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        String input = "30 30" + System.lineSeparator() + ".,:;xXQ@" + System.lineSeparator() + "radial 15 15 18" +
                System.lineSeparator();
        ByteArrayInputStream is = new ByteArrayInputStream(input.getBytes());

        System.setIn(is);
        System.setOut(new PrintStream(os));

        GradientGenerator.main(new String[]{});

        String expected = "@@@@@@@@@@@QQQQQQQQQ@@@@@@@@@@\n" +
                "@@@@@@@@QQQQQQQQQQQQQQQ@@@@@@@\n" +
                "@@@@@@@QQQQQXXXXXXXQQQQQ@@@@@@\n" +
                "@@@@@QQQQXXXXXXXXXXXXXQQQQ@@@@\n" +
                "@@@@QQQQXXXXXxxxxxXXXXXQQQQ@@@\n" +
                "@@@QQQXXXXxxxxxxxxxxxXXXXQQQ@@\n" +
                "@@@QQXXXXxxxxxxxxxxxxxXXXXQQ@@\n" +
                "@@QQQXXXxxx;;;;;;;;;xxxXXXQQQ@\n" +
                "@QQQXXXxxx;;;;;;;;;;;xxxXXXQQQ\n" +
                "@QQXXXxxx;;;:::::::;;;xxxXXXQQ\n" +
                "@QQXXxxx;;;:::::::::;;;xxxXXQQ\n" +
                "QQQXXxx;;;:::,,,,,:::;;;xxXXQQ\n" +
                "QQXXXxx;;:::,,,,,,,:::;;xxXXXQ\n" +
                "QQXXxxx;;::,,,...,,,::;;xxxXXQ\n" +
                "QQXXxxx;;::,,.....,,::;;xxxXXQ\n" +
                "QQXXxxx;;::,,.....,,::;;xxxXXQ\n" +
                "QQXXxxx;;::,,.....,,::;;xxxXXQ\n" +
                "QQXXxxx;;::,,,...,,,::;;xxxXXQ\n" +
                "QQXXXxx;;:::,,,,,,,:::;;xxXXXQ\n" +
                "QQQXXxx;;;:::,,,,,:::;;;xxXXQQ\n" +
                "@QQXXxxx;;;:::::::::;;;xxxXXQQ\n" +
                "@QQXXXxxx;;;:::::::;;;xxxXXXQQ\n" +
                "@QQQXXXxxx;;;;;;;;;;;xxxXXXQQQ\n" +
                "@@QQQXXXxxx;;;;;;;;;xxxXXXQQQ@\n" +
                "@@@QQXXXXxxxxxxxxxxxxxXXXXQQ@@\n" +
                "@@@QQQXXXXxxxxxxxxxxxXXXXQQQ@@\n" +
                "@@@@QQQQXXXXXxxxxxXXXXXQQQQ@@@\n" +
                "@@@@@QQQQXXXXXXXXXXXXXQQQQ@@@@\n" +
                "@@@@@@@QQQQQXXXXXXXQQQQQ@@@@@@\n" +
                "@@@@@@@@QQQQQQQQQQQQQQQ@@@@@@@\n";
        assertEquals(expected, os.toString());
    }

    @Test
    public void mainWrongTypeTest() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        String input = "30 30" + System.lineSeparator() + ".,:;xXQ@" + System.lineSeparator() + "nonexistent 15 15 18" +
                System.lineSeparator();
        ByteArrayInputStream is = new ByteArrayInputStream(input.getBytes());

        System.setIn(is);
        System.setOut(new PrintStream(os));

        GradientGenerator.main(new String[]{});

        String expected = "Wrong input: nonexistent" + System.lineSeparator() +
                "Program usage:" + System.lineSeparator() + "num_columns num_rows" + System.lineSeparator()
                + "colors (for example: .,:;xXQ)" + System.lineSeparator() + "Two options:" + System.lineSeparator()
                + "\t'radial' center_x center_y radius" + System.lineSeparator()
                + "\t'linear' start_x start_y end_x end_y" + System.lineSeparator();
        assertEquals(expected, os.toString());
    }

    @Test
    public void mainInvalidArgumentTest() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        String input = "30" + System.lineSeparator() + ".,:;xXQ@" + System.lineSeparator() + "radial 15 15 18" +
                System.lineSeparator();
        ByteArrayInputStream is = new ByteArrayInputStream(input.getBytes());

        System.setIn(is);
        System.setOut(new PrintStream(os));

        GradientGenerator.main(new String[]{});

        String expected = "Exception while parsing width and height arguments." + System.lineSeparator()
                + "1" + System.lineSeparator() + "Program usage:" + System.lineSeparator() + "num_columns num_rows"
                + System.lineSeparator() + "colors (for example: .,:;xXQ)" + System.lineSeparator() + "Two options:"
                + System.lineSeparator() + "\t'radial' center_x center_y radius" + System.lineSeparator()
                + "\t'linear' start_x start_y end_x end_y" + System.lineSeparator();
        assertEquals(expected, os.toString());
    }
}
