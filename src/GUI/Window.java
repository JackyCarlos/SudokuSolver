package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ScheduledExecutorService;

public class Window extends JFrame {

    static final Color prettyGrey = new Color(0x89, 0x89, 0x89);

    private Window(final String title) {
        //setSize(900, 1000);
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLocation(400, 400);
        setBackground(prettyGrey);
        setTitle(title);

        setVisible(true);

    }


    public static void main(String[] args) {
        JFrame window = new Window("SUDOKU-SOLVER 2D");

        JButton j = new JButton("Klick mich!!!");

        window.setLayout(new BorderLayout());
        window.add(j, BorderLayout.CENTER);

        /*JPanel panel = new JPanel();
        panel.setSize(900, 900);
        panel.setLayout(new GridLayout(1, 2));
        GridBagConstraints gbc = new GridBagConstraints();

        Interface intface = new Interface();
        JPanel trulala = new JPanel();

        panel.add(intface);
        panel.add(trulala);


        //window.add(panel);
        //window.setContentPane(panel);
        window.getContentPane().add(panel);
        window.repaint();

        Scene scene = new Scene();*/

    }



}
