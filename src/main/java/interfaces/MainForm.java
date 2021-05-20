package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm {
    private JPanel mainPanel;
    private JButton drawButton;
    private JTextField textCount;
    private JCheckBox enterPointCheckBox;

    public MainForm() {
        drawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                CanvasForm frame = new CanvasForm(800,800,
                        Integer.parseInt(textCount.getText()),enterPointCheckBox.isSelected());
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
