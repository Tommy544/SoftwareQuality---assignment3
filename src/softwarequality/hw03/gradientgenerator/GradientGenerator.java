package softwarequality.hw03.gradientgenerator;

import softwarequality.hw03.gradientgenerator.geometry.Vector2D;
import softwarequality.hw03.gradientgenerator.utils.InputParser;
import softwarequality.hw03.gradientgenerator.utils.Settings;
import softwarequality.hw03.gradientgenerator.utils.WrongInputException;

import java.awt.*;

/**
 * Created on 19.04.2015.
 *
 * @author Vladimir Caniga
 */
public class GradientGenerator {

    public static String generateLinear(int width, int height, char[] colors, Point startPoint, Point endPoint) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("width and height must not be lower than zero.");
        }
        if (colors.length == 0) {
            throw new IllegalArgumentException("colors must contain at least one color.");
        }
        if (startPoint == null || endPoint == null) {
            throw new NullPointerException("startPoint and endPoint must not be null.");
        }

        StringBuilder sb = new StringBuilder();
        Vector2D startToEndVector = Vector2D.vectorFromTwoPoints(startPoint, endPoint);
        Vector2D startToEndUnitVector = startToEndVector.getUnitVector();
        double startToEndVectorSize = startToEndVector.getSize();

        // Iterate through rows and columns
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                Vector2D startToActualVector = Vector2D.vectorFromTwoPoints(startPoint, new Point(column, row));
                double distance = startToActualVector.scalarProduct(startToEndUnitVector);

                if (distance < 0) {
                    sb.append(colors[0]);
                } else if (distance > startToEndVectorSize) {
                    sb.append(colors[colors.length - 1]);
                } else {
                    sb.append(colors[(int) (distance * (colors.length - 1) / startToEndVectorSize)]);
                }
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    public static String generateRadial(int width, int height, char[] colors, Point centerPoint, double radius) {
        if (width < 0 || height < 0 || radius < 0) {
            throw new IllegalArgumentException("width, height and radius must not be lower than zero.");
        }
        if (colors.length == 0) {
            throw new IllegalArgumentException("colors must contain at least one color.");
        }
        if (centerPoint == null) {
            throw new NullPointerException("startPoint and endPoint must not be null.");
        }

        StringBuilder sb = new StringBuilder();

        // Iterate through rows and columns
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                // Distance from this coordinate to center
                double dist = centerPoint.distance(column, row);
                dist /= radius;
                dist *= colors.length;
                sb.append(colors[Math.min((int) dist, colors.length - 1)]);
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    public static String getProgramUsage() {

        return "Program usage:" + System.lineSeparator() + "num_columns num_rows" + System.lineSeparator()
                + "colors (for example: .,:;xXQ)" + System.lineSeparator() + "Two options:" + System.lineSeparator()
                + "\t'radial' center_x center_y radius" + System.lineSeparator()
                + "\t'linear' start_x start_y end_x end_y" + System.lineSeparator();
    }

    public static void main(String[] args) {
        InputParser inputParser = new InputParser();
        Settings settings;
        try {
            settings = inputParser.getSettings();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
            if (e.getCause() != null) {
                System.out.println(e.getCause().getMessage());
            }
            System.out.print(getProgramUsage());
            return;
        }

        switch (settings.type) {
            case "linear":
                System.out.print(generateLinear(settings.width, settings.height, settings.colors,
                        settings.startPoint, settings.endPoint));
                break;
            case "radial":
                System.out.print(generateRadial(settings.width, settings.height, settings.colors,
                        settings.startPoint, settings.radius));
                break;
            default:
                System.out.println("Wrong input: " + settings.type);
                System.out.print(getProgramUsage());
                break;
        }

    }
}
