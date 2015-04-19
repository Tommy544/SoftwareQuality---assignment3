package softwarequality.hw03.gradientgenerator.utils;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

/**
 * Created on 19.04.2015.
 *
 * @author Vladimir Caniga
 */
public class SettingsTest {

    @Test
    public void settingsEmptyTest() {
        Settings settings = new Settings();

        assertEquals(settings.width, 0);
        assertEquals(settings.height, 0);
        assertEquals(settings.colors, null);
        assertEquals(settings.endPoint, null);
        assertEquals(settings.startPoint, null);
        assertEquals(settings.radius, 0, 0.000001);
        assertEquals(settings.type, null);
    }

    @Test
    public void settingsTest() {
        Settings settings = new Settings();

        settings.width = 10;
        settings.height = 20;
        settings.colors = ".,:;xXQ@".toCharArray();
        settings.startPoint = new Point(0, 0);
        settings.endPoint = new Point(10, 10);
        settings.radius = 12.5;
        settings.type = "linear";

        assertEquals(settings.width, 10);
        assertEquals(settings.height, 20);
        assertEquals(String.valueOf(settings.colors), ".,:;xXQ@");
        assertEquals(settings.endPoint, new Point(10, 10));
        assertEquals(settings.startPoint, new Point(0, 0));
        assertEquals(settings.radius, 12.5, 0.000001);
        assertEquals(settings.type, "linear");
    }
}