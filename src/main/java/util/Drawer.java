package util;

import lombok.AllArgsConstructor;

import java.awt.*;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class Drawer implements Runnable{

    private Graphics g;

    private int pointsCount;

    private Double width;

    private Double height;


    @Override
    public void run() {
        Random random = new Random();
        PointCalculator calculator = new PointCalculator();

        List<PointCoordinates> points  = calculator.getRandomPoints(width,height,pointsCount);

        for(PointCoordinates point:points){
            g.drawOval((int) Math.round(point.getX()),(int) Math.round(point.getY()),5,5);
        }

        PointCoordinates startPoint = points.get(0);

        while (true){
            PointCoordinates point = calculator.getPoint(startPoint,points.get(random.nextInt(pointsCount)));
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            g.fillOval((int) Math.round(point.getX()),(int) Math.round(point.getY()),5,5);
            startPoint = point;
        }


    }
}
