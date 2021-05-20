package interfaces;

import util.Drawer;
import util.PointCoordinates;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class CanvasForm extends JFrame {

    private Thread drawer;

    public CanvasForm(int w, int h, final int count,boolean enterPoint) {
        super("Frame");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(w, h);
        setVisible(true);
        List<PointCoordinates> points = new ArrayList<>();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                points.add(new PointCoordinates((double) e.getX()-5,(double) e.getY()-5));
                if(points.size() == count){
                    drawer = new Thread(new Drawer(getGraphics(), count, (double) getWidth(), (double) getHeight(),points));
                    drawer.start();
                }
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent we) {
                if(!enterPoint) {
                    drawer = new Thread(new Drawer(getGraphics(), count, (double) getWidth(), (double) getHeight()));
                    drawer.start();
                }
            }

            @Override
            public void windowClosing(WindowEvent e) {
                if(drawer != null) {
                    while(!drawer.isInterrupted()) {
                        drawer.interrupt();
                    }
                }
            }
        });
    }


}
