package util;

import lombok.AllArgsConstructor;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class Drawer implements Runnable{

    private Graphics g;

    private int pointsCount;

    private Double width;

    private Double height;

    private List<PointCoordinates> points;

    public Drawer(Graphics g, int pointsCount, Double width, Double height) {
        this.g = g;
        this.pointsCount = pointsCount;
        this.width = width;
        this.height = height;
    }

    public Drawer(Graphics g, int pointsCount, Double width, Double height, List<PointCoordinates> points) {
        this.g = g;
        this.pointsCount = pointsCount;
        this.width = width;
        this.height = height;
        this.points = points;
    }

    @Override
    public void run() {
        Random random = new Random();
        PointCalculator calculator = new PointCalculator();

        if(points == null) {
            points = calculator.getRandomPoints(width, height, pointsCount);
        }
        for(PointCoordinates point:points){
            g.drawOval((int) Math.round(point.getX()),(int) Math.round(point.getY()),5,5);
        }

        PointCoordinates startPoint = points.get(0);

        while (true){
            PointCoordinates point = calculator.getPoint(startPoint,points.get(random.nextInt(pointsCount)));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                break;
            }
            System.out.println("work");
            g.fillOval((int) Math.round(point.getX()),(int) Math.round(point.getY()),5,5);
            startPoint = point;
        }


    }
}
