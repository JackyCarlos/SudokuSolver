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
    public void solveSudoku(final int n) {
        // as soon as we are at the end of our game field, we should have a solution worth seeing.
        if(n > 80) {
            field.printField();
            observer.freeze();

            return;
        }

        // if the field we are working on has a number bigger than zero
        // it is a given number we are not allowed to change. In this case we simply continue with our recursion.
        if(field.get(n) > 0) {
            solveSudoku(n + 1);
        } else {
            // let's try all nine possible numbers for our field.
            for(int i = 1; i < 10; i++) {
                field.set(n, i);
                observer.informChangedField(n);
                try { Thread.sleep(1000); } catch (InterruptedException e) {}

                // we need to check if the number is valid.
                // if so we might have the right number and continue with the recursion.
                if(!field.inRow(n) && !field.inColumn(n) && !field.inBox(n)) {
                    solveSudoku(n + 1);
                }
            }

            // if no number led to a correct solution we leave this recursion call
            // and reset the value of our field to zero.
            field.set(n, 0);
            observer.informChangedField(n);
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        }
    }
}
