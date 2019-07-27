package Algorithm;

public class Solver {

    private int[] field = {

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


    private Solver() {}


    public static void main(String[] args) {
        Solver solver = new Solver();

        solver.solveSudoku(0);
    }


    // Standard method for printing the sudoku game field.
    private void printField() {
        for(int i = 0; i < 81; i++) {
            if(i % 9 == 0) {
                System.out.println();
            }

            System.out.print(field[i] + " ");
        }

        System.out.println(); System.out.println();
    }


    // recursive method for solving a given sudoku from its starting position.
    private void solveSudoku(int n) {
        // as soon as we are at the end of our game field, we should have a solution worth seeing.
        if(n > 80) {
            printField();

            return;
        }

        // if the field we are working on has a number bigger than zero
        // it is a given number we are not allowed to change. In this case we simply continue with our recursion.
        if(field[n] > 0) {
            solveSudoku(n + 1);
        } else {
            // let's try all nine possible numbers for our field.
            for(int i = 1; i < 10; i++) {
                field[n] = i;

                // we need to check if the number is valid.
                // if so we might have the right number and continue with the recursion.
                if(!inRow(n) && !inColumn(n) && !inBox(n)) {
                    solveSudoku(n + 1);
                }
            }

            // if no number led to a correct solution we leave this recursion call
            // and reset the value of our field to zero.
            field[n] = 0;
        }
    }


    // checks if the value of a field is already in its row.
    private boolean inRow(int i) {
        int rowStart = i - (i % 9);

        for(int j = 0; j < 9; j++) {
            if(i != (rowStart + j) && field[rowStart + j] == field[i]) {
                return true;
            }
        }
        return false;
    }


    // checks if the value of a field is already in its column.
    private boolean inColumn(int i) {
        for(int j = 1; j < 9; j++) {
            int pos = (i + j * 9) % 81;

            if(field[i] == field[pos]) {
                return true;
            }
        }
        return false;
    }


    // checks if the value of a field is already in its box.
    private boolean inBox(int i) {
        int pos = i - ((i / 9) % 3) * 9 - (i % 3);

        for(int j = 0; j < 9; j++) {
            if(j != 0 && j % 3 == 0) {
                pos += 9;
            }

            int k = pos + (j % 3);

            if(k != i && field[i] == field[k]) {
                return true;
            }
        }
        return false;
    }
}
