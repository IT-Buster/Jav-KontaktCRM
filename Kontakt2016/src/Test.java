import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test {
    JFrame frame;

    public Test() {
        JButton button = new JButton("exit");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        JPanel panel = new JPanel();
        panel.add(button);
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocation(200,200);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Test();        
    }
}