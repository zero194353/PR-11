import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Border {

    static class MyButton {
        MyButton(JFrame jFrame, String name, JButton jButton, String borderLayout) {
            jButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    JOptionPane.showMessageDialog(jFrame, "Вы находитесь в " + name);
                }
            });

            jFrame.add(jButton, borderLayout);
        }
    }

    static JFrame getDefaultFrame() {
        JFrame jFrame = new JFrame();
        Dimension dim = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        jFrame.setBounds(dim.width / 3, dim.height / 3, dim.width / 3, dim.height / 3);
        jFrame.setTitle("Граница");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return jFrame;
    }

    public static void main(String[] args) {
        JFrame jFrame = getDefaultFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        MyButton[] myButtons = new MyButton[]{new MyButton(jFrame, "САО", new JButton("САО"), BorderLayout.NORTH),
                new MyButton(jFrame, "ВАО", new JButton("ВАО"), BorderLayout.EAST),
                new MyButton(jFrame, "ЮАО", new JButton("ЮАО"), BorderLayout.SOUTH),
                new MyButton(jFrame, "ЗАО", new JButton("ЗАО"), BorderLayout.WEST),
                new MyButton(jFrame, "ЦАО", new JButton("ЦАО"), BorderLayout.CENTER)
        };

        jFrame.setVisible(true);

    }
}

