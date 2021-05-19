package interfaces;

import util.Drawer;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CanvasForm extends JFrame {

    private Thread drawer;

    public CanvasForm(int w, int h, final int count) {
        super("Frame");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(w, h);
        setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent we) {
                drawer = new Thread(new Drawer(getGraphics(),count, (double) getWidth(),(double) getHeight()));
                drawer.start();
            }

            @Override
            public void windowClosing(WindowEvent e) {
                drawer.stop();
            }
        });
    }


}
