import Algorithm.*;

public final class Main {

    private Main() {
        throw new AssertionError("Main class not meant to be instantiated.");
    }

    public static void main(String[] args) {

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

        solver.solveSudoku(0);
    }
}
