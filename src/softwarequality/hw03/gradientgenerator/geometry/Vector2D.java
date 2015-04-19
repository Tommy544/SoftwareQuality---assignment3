package softwarequality.hw03.gradientgenerator.geometry;

import java.awt.*;

/**
 * Created on 19.04.2015.
 *
 * @author Vladimir Caniga
 */
public class Vector2D {

    public double dx;
    public double dy;

    Vector2D(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public double getSize() {
        return Math.sqrt(dx * dx + dy * dy);
    }

    public Vector2D getUnitVector() {
        double size = this.getSize();

        return new Vector2D(dx / size, dy / size);
    }

    public double scalarProduct(Vector2D vect) {
        if (vect == null) {
            throw new NullPointerException("vect must not be null.");
        }

        return dx * vect.dx + dy * vect.dy;
    }

    public static Vector2D vectorFromTwoPoints(Point startPoint, Point endPoint) {
        if (startPoint == null || endPoint == null) {
            throw new NullPointerException("startPoint and endPoint must not be null.");
        }

        int dx = endPoint.x - startPoint.x;
        int dy = endPoint.y - startPoint.y;

        return new Vector2D(dx, dy);
    }
}
