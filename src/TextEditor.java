import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditor {
    static JFrame getDefaultFrame() {
        JFrame jFrame = new JFrame();
        Dimension dim = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        jFrame.setBounds(dim.width / 3, dim.height / 3, dim.width / 3, dim.height / 3);
        jFrame.setTitle("Text Editor");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return jFrame;
    }

    public static void main(String[] args) {

        JMenuItem[] items1 = new JMenuItem[]{new JMenuItem("Синий"), new JMenuItem("Красный"), new JMenuItem("Чёрный")};
        JMenuItem[] items2 = new JMenuItem[]{new JMenuItem("Times New Roman"), new JMenuItem("MS Sans Serif"), new JMenuItem("Courier New")};

        JFrame jFrame = getDefaultFrame();

        JTextArea jTextArea = new JTextArea();
        jTextArea.setLineWrap(true);
        jFrame.add(jTextArea);

        JMenu colors = new JMenu("Цвета");
        JMenu fonts = new JMenu("Шрифты");

        for (JMenuItem item : items1) {
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (item.getText()) {
                        case ("Синий"):
                            jTextArea.setForeground(Color.BLUE);
                            break;
                        case ("Красный"):
                            jTextArea.setForeground(Color.RED);
                            break;
                        case ("Чёрный"):
                            jTextArea.setForeground(Color.BLACK);
                            break;
                    }
                }
            });
            colors.add(item);
        }

        for (JMenuItem item : items2) {
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (item.getText()) {
                        case ("Times New Roman"):
                            jTextArea.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 14));
                            break;
                        case ("MS Sans Serif"):
                            jTextArea.setFont(Font.getFont(Font.SANS_SERIF));
                            break;
                        case ("Courier New"):
                            jTextArea.setFont(new Font("Courier New", Font.BOLD, 14));
                            break;
                    }
                }
            });
            fonts.add(item);
        }

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(colors);
        menuBar.add(fonts);
        jFrame.setJMenuBar(menuBar);

        jFrame.setVisible(true);
    }
}
