package SudokuSolver.Algorithm;

import SudokuSolver.GUI.*;

public class Solver {
    private SudokuField field;
    private GUIobserver observer;

    public Solver(final SudokuField field) {
        this.field = field;
    }

    public SudokuField getField() {
        return field;
    }

    public void registerGUIobserver(GUIobserver observer) {
        this.observer = observer;
    }

    // recursive method for solving a given sudoku from its starting position.
    public boolean solveSudoku(final int n, boolean visualize) {
        // as soon as we are at the end of our game field, we should have a solution worth seeing.
        if(n > 80) {
            field.printField();

            return true;
        }

        // if the field we are working on has a number bigger than zero
        // it is a given number we are not allowed to change. In this case we simply continue with our recursion.
        if(field.getNumber(n) > 0) {
            return solveSudoku(n + 1, visualize);
        } else {
            // let's try all nine possible numbers for our field.
            for(int i = 1; i < 10; i++) {
                field.setNumber(n, i);
                if (observer != null) observer.informChangedField(n);

                if (visualize) {
                    try { Thread.sleep(100); } catch (InterruptedException e) {}
                }

                // we need to check if the number is valid.
                // if so we might have the right number and continue with the recursion.
                if(!field.inRow(n) && !field.inColumn(n) && !field.inBox(n)) {
                    if(solveSudoku(n + 1, visualize)) return true;
                }
            }

            // if no number led to a correct solution we leave this recursion call
            // and reset the value of our field to zero.
            field.setNumber(n, 0);
            if (observer != null) observer.informChangedField(n);
            if (visualize) {
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }

            return false;
        }
    }
}
