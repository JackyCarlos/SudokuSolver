package SudokuSolver.Algorithm;

public interface SudokuField {
    boolean inRow(int i);
    boolean inColumn(int i);
    boolean inBox(int i);
    void setNumber(int index, int number);
    int getNumber(int index);
    void printField();
}
