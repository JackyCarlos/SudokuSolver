package Algorithm;

public interface SudokuField {

    boolean inRow(int i);
    boolean inColumn(int i);
    boolean inBox(int i);
    void set(int index, int number);
    int get(int index);
    void printField();
}
