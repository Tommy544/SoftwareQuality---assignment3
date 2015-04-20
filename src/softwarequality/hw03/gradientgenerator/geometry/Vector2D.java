package softwarequality.hw03.gradientgenerator.geometry;

import java.awt.*;

/**
 * Class represents a geometrical 2D vector.
 * Provides some basic operations with vectors and points.
 *
 * Created on 19.04.2015.
 *
 * @author Vladimir Caniga
 * @author Jakub Smolar
 */
public class Vector2D {

    public double dx;
    public double dy;

    /**
     * Simple constructor.
     *
     * @param dx x component of vector
     * @param dy y component of vector
     */
    Vector2D(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Calculates and returns size of this vector.
     *
     * @return size of this vector
     */
    public double getSize() {
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Calculates and returns this vector's unit vector
     *
     * @return unit vector of this vector
     */
    public Vector2D getUnitVector() {
        double size = this.getSize();

        return new Vector2D(dx / size, dy / size);
    }

    /**
     * Calculates and returns scalar product of this vector and the vector passed as argument.
     *
     * @param vect second vector
     * @return scalar product of this vector and argument vect
     */
    public double scalarProduct(Vector2D vect) {
        if (vect == null) {
            throw new NullPointerException("vect must not be null.");
        }

        return dx * vect.dx + dy * vect.dy;
    }

    /**
     * Calculates and returns vector between two points passed as arguments.
     *
     * @param startPoint point A
     * @param endPoint   point B
     * @return vector between pints A and B
     */
    public static Vector2D vectorFromTwoPoints(Point startPoint, Point endPoint) {
        if (startPoint == null || endPoint == null) {
            throw new NullPointerException("startPoint and endPoint must not be null.");
        }

        int dx = endPoint.x - startPoint.x;
        int dy = endPoint.y - startPoint.y;

        return new Vector2D(dx, dy);
    }
}
