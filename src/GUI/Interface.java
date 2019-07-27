package GUI;

import javax.swing.*;
import java.awt.*;

public class Interface extends JPanel {

    private JTextField[] numberFields = new JTextField[81];


    Interface() {
        setSize(900, 900);
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        setBackground(Window.prettyGrey);
        setBorder(BorderFactory.createMatteBorder(6, 6, 6, 6, Color.BLACK));

/*
        JButton solveBtn = new JButton("Solve Sudoku!");
        solveBtn.setVisible(true);
        solveBtn.setSize(50 ,50);
        solveBtn.setLocation(400, 400);
        add(solveBtn);*/



        //initTextfields();
    }


    public void paint(Graphics g) {
        super.paint(g);

        drawGrids(g);
    }


    private void drawGrids(Graphics g) {
        g.setColor(Color.BLACK);

        g.fillRect(295, 0, 10, 900);
        g.fillRect(595, 0, 10, 900);

        g.fillRect(0, 295, 900, 10);
        g.fillRect(0, 595, 900, 10);

        for(int i = 1; i < 10; i++) {
            g.fillRect(i * 100 - 3, 0, 6, 900);
            g.fillRect(0, i * 100 - 3, 900, 6);
        }
    }


    private void initTextfields() {
        for(int i = 0; i < 81; i++) {
            numberFields[i] = new JTextField();

            numberFields[i].setSize(20, 20);

            numberFields[i].setText("1");
            numberFields[i].setLocation(i % 9 * 100 + 50, (i / 9) * 100 + 50);

            add(numberFields[i]);
        }


    }
}
