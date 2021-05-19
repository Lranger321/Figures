package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Double.NaN;

public class PointCalculator {

    private final Random random = new Random();


    public PointCoordinates getPoint(PointCoordinates firstPoint, PointCoordinates secondPoint) {
        return new PointCoordinates((firstPoint.getX() + secondPoint.getX()) / 2,
                (firstPoint.getY() + secondPoint.getY()) / 2);
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
