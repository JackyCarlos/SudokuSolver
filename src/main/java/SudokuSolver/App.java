package SudokuSolver;
import SudokuSolver.GUI.*;
import SudokuSolver.Algorithm.*;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        boolean visualize = true;

        if (args.length == 2 && args[0].equals("visualize") && args[1].equals("false")) {
            visualize = false;
        } 

        int[] exampleField = {
              // an easy Sudoku ..
              5, 3, 0,  0, 7, 0,  0, 0, 0,
              6, 0, 0,  1, 9, 5,  0, 0, 0,
              0, 9, 8,  0, 0, 0,  0, 6, 0,

              8, 0, 0,  0, 6, 0,  0, 0, 3,
              4, 0, 0,  8, 0, 3,  0, 0, 1,
              7, 0, 0,  0, 2, 0,  0, 0, 6,

              0, 6, 0,  0, 0, 0,  2, 8, 0,
              0, 0, 0,  4, 1, 9,  0, 0, 5,
              0, 0, 0,  0, 8, 0,  0, 7, 9

              /* .. a little bit harder one
              0, 4, 0,  9, 2, 0,  0, 0, 0,
              0, 2, 0,  0, 0, 0,  0, 0, 0,
              0, 0, 0,  0, 0, 0,  0, 1, 3,

              0, 0, 0,  4, 3, 0,  0, 0, 2,
              2, 5, 8,  0, 0, 6,  0, 0, 0,
              0, 0, 4,  1, 0, 0,  0, 0, 9,

              0, 0, 0,  0, 0, 0,  5, 8, 0,
              8, 0, 9,  0, 7, 3,  0, 0, 0,
              0, 0, 0,  0, 0, 1,  0, 3, 0
              */
        };

        SudokuField field = new Field(exampleField);
        Solver solver = new Solver(field);
        GUIobserver observer = new PrettyGUI(solver);
        solver.registerGUIobserver(observer);

        solver.solveSudoku(0, visualize);
    }
}
