package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PointCalculator {

    private final Random random = new Random();

    // 0.5 if 3 points = fractal
    // 0.25 interesting thing

    private static final Double DIVIDER = 0.49;


    public PointCoordinates getPoint(PointCoordinates firstPoint, PointCoordinates secondPoint) {
        return new PointCoordinates((firstPoint.getX() + secondPoint.getX()) * DIVIDER,
                (firstPoint.getY() + secondPoint.getY()) * DIVIDER);
    }

    public List<PointCoordinates> getRandomPoints(Double width, Double height, int count) {
        //get center
        double widthCenter = width / 2;
        double heightCenter = height / 2;
        double radius = Math.min(width / 2.5, height / 2.5);

        List<PointCoordinates> points = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            double y =  Math.pow(-1, i) * Math.round((random.nextDouble() * 1000) % radius);
            System.out.println(y);
            double x = countX(y, radius);
            System.out.println((x+widthCenter)+"  "+(y+heightCenter));
            points.add(new PointCoordinates(x + widthCenter, y + heightCenter));
        }

        return points;
    }

    private Double countX(Double y, Double r) {
        return Math.pow(-1, random.nextInt() % 2) * Math.sqrt(Math.pow(r,2) - Math.pow(y,2));
    }


}
