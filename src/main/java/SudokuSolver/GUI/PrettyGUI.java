package SudokuSolver.GUI;

import SudokuSolver.Algorithm.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PrettyGUI extends JFrame implements GUIobserver {
    private Solver solver;
    private JTextField[][] cells = new JTextField[9][9];
    private boolean freeze = false;

    public PrettyGUI(Solver solver) {
        this.solver = solver;
        this.setTitle("Sudoku");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        JPanel boardPanel = new JPanel(new GridLayout(9, 9));
        boardPanel.setBackground(Color.WHITE);

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                JTextField cell = new JTextField();
                cell.setHorizontalAlignment(JTextField.CENTER);
                cell.setFont(new Font("Monospaced", Font.PLAIN, 24));
                cell.setEditable(false);
                cell.setBackground(Color.WHITE);
                cell.setBorder(getCellBorder(row, col));
                cell.setPreferredSize(new Dimension(50, 50)); 
                cells[row][col] = cell;
                boardPanel.add(cell);
            }
        }

        JPanel outer = new JPanel(new GridBagLayout());
        outer.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); 
        outer.add(boardPanel);

        this.setContentPane(outer);
        this.pack(); 
        this.setSize(getWidth() + 100, getHeight() + 100); 
        this.setLocationRelativeTo(null); 
        this.setVisible(true);

        updateBoard();
    }

    private Border getCellBorder(int row, int col) {
        int thick = 3;
        int thin = 1;

        int top = (row % 3 == 0) ? thick : thin;
        int left = (col % 3 == 0) ? thick : thin;
        int bottom = (row == 8) ? thick : thin;
        int right = (col == 8) ? thick : thin;

        return BorderFactory.createMatteBorder(top, left, bottom, right, Color.BLACK);
    }

    public void freeze() {
        this.freeze = true;
    }

    public void informChangedField(int index) {
        if (freeze) return;

        System.out.println("changing field at index " + index);
        int changedValue = solver.getField().get(index);

        cells[index / 9][index % 9].setText(changedValue == 0 ? "" : String.valueOf(changedValue));
    }

    private void updateBoard() {
        for (int i = 0; i < 81; i++) {
            informChangedField(i);
        }
    }
}
