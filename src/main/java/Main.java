import interfaces.MainForm;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        createView();
    }


    private static void createView() {

        JFrame frame = new JFrame();
        frame.setSize(600, 400);
        frame.add(new MainForm().getMainPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}
