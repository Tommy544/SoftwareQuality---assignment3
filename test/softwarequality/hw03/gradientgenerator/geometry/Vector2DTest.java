package softwarequality.hw03.gradientgenerator.geometry;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.awt.*;

import static org.junit.Assert.assertEquals;

/**
 * Created on 19.04.2015.
 *
 * @author Vladimir Caniga
 */
public class Vector2DTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void getSizeTest() {
        Vector2D vector = new Vector2D(5, 6);
        double size = vector.getSize();
        assertEquals(7.8102497, size, 0.000001);

        vector = new Vector2D(2, 3.5);
        size = vector.getSize();
        assertEquals(4.0311288, size, 0.000001);
    }

    @Test
    public void getUnitVectorTest() {
        Vector2D vector = new Vector2D(5, 0);
        Vector2D unitVector = vector.getUnitVector();
        assertEquals(1, unitVector.dx, 0.000001);
        assertEquals(0, unitVector.dy, 0.000001);

        vector = new Vector2D(2, 2);
        unitVector = vector.getUnitVector();
        assertEquals(0.7071068, unitVector.dx, 0.000001);
        assertEquals(0.7071068, unitVector.dy, 0.000001);
    }

    @Test
    public void scalarProductTest() {
        Vector2D firstVector = new Vector2D(2, 3);
        Vector2D secondVector = new Vector2D(5, 6);
        double result = firstVector.scalarProduct(secondVector);
        assertEquals(28, result, 0.000001);

        firstVector = new Vector2D(5, 5);
        secondVector = new Vector2D(0.5, 2.2);
        result = secondVector.scalarProduct(firstVector);
        assertEquals(13.5, result, 0.000001);
    }

    @Test
    public void scalarProductNullArgumentTest() {
        Vector2D vector = new Vector2D(1, 2);
        expectedException.expect(NullPointerException.class);
        vector.scalarProduct(null);
    }

    @Test
    public void vectorFromTwoPointsTest() {
        Point pointA = new Point(1, 1);
        Point pointB = new Point(5, 1);
        Vector2D vector = Vector2D.vectorFromTwoPoints(pointA, pointB);
        assertEquals(4, vector.dx, 0.000001);
        assertEquals(0, vector.dy, 0.000001);
    }

    @Test
    public void vectorFromTwoPointsNullArgumentTest() {
        Point point = new Point(1, 2);
        expectedException.expect(NullPointerException.class);
        Vector2D.vectorFromTwoPoints(point, null);

        expectedException.expect(NullPointerException.class);
        Vector2D.vectorFromTwoPoints(null, point);
    }
}
