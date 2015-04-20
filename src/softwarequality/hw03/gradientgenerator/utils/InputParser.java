package softwarequality.hw03.gradientgenerator.utils;

import java.awt.*;
import java.util.Scanner;

/**
 * Class defines method used for parsing user input.
 * Intended to use with GradientGenerator class.
 *
 * Created on 19.04.2015.
 *
 * @author Vladimir Caniga
 * @author Jakub Smolar
 */
public class InputParser {

    public Settings getSettings() throws WrongInputException {
        Settings settings = new Settings();

        Scanner in = new Scanner(System.in);

        String[] input = in.nextLine().split("\\s+");
        try {
            settings.width = Integer.parseInt(input[0]);
            settings.height = Integer.parseInt(input[1]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new WrongInputException("Exception while parsing width and height arguments.", e);
        }
        settings.colors = in.nextLine().toCharArray();
        String[] params = in.nextLine().split("\\s+");
        Point startPoint;
        try {
            settings.type = params[0].toLowerCase();
            startPoint = new Point(Integer.parseInt(params[1]), Integer.parseInt(params[2]));
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new WrongInputException("Exception while parsing start point x and y arguments.", e);
        }
        settings.startPoint = startPoint;
        switch (settings.type) {
            case "radial":
                try {
                    settings.radius = Double.parseDouble(params[3]);
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    throw new WrongInputException("Exception while parsing radius argument.", e);
                }
                break;
            case "linear":
                Point endPoint;
                try {
                    endPoint = new Point(Integer.parseInt(params[3]), Integer.parseInt(params[4]));
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    throw new WrongInputException("Exception while parsing end point arguments.", e);
                }
                settings.endPoint = endPoint;
                // The "radius" is now the distance between startPoint and endPoint
                settings.radius = startPoint.distance(endPoint);
                break;
        }

        return settings;
    }
}
