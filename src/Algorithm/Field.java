package Algorithm;

public class Field implements SudokuField {

    private int[] field;

    // initialises a new sample field
    public Field(int[] field) {
        this.field = field;
    }

    // checks if the value of a field is already in its row.
    public boolean inRow(final int i) {
        int rowStart = i - (i % 9);

        for(int j = 0; j < 9; j++) {
            if(i != (rowStart + j) && field[rowStart + j] == field[i]) {
                return true;
            }
        }
        return false;
    }

    // checks if the value of a field is already in its column.
    public boolean inColumn(final int i) {
        for(int j = 1; j < 9; j++) {
            int pos = (i + j * 9) % 81;

            if(field[i] == field[pos]) {
                return true;
            }
        }
        return false;
    }


    // checks if the value of a field is already in its box.
    public boolean inBox(final int i) {
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

    // Standard method for printing the sudoku game field.
    public void printField() {
        for(int i = 0; i < 81; i++) {
            if(i % 9 == 0) {
                System.out.println();
            }

            System.out.print(field[i] + " ");
        }

        System.out.println("\n");
    }

    public void set(final int index, final int number) {
        field[index] = number;
    }

    public int get(final int index) {
        return field[index];
    }
}
