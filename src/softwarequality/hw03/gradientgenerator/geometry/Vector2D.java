package softwarequality.hw03.gradientgenerator.geometry;

import java.awt.*;

/**
 * Created by vcaniga on 4/19/15.
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
        return dx * vect.dx + dy * vect.dy;
    }

    public static Vector2D vectorFromTwoPoints(Point startPoint, Point endPoint) {
        int dx = endPoint.x - startPoint.x;
        int dy = endPoint.y - startPoint.y;

        return new Vector2D(dx, dy);
    }
}
