package SudokuSolver;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import SudokuSolver.Algorithm.*;
import static org.junit.jupiter.api.Assertions.*;

class FieldTest {
    private Field field;

    @BeforeEach
    void setup() {
        field = new Field(
            new int [] {
            5, 3, 4,  0, 7, 0,  0, 0, 0,
            6, 0, 0,  1, 9, 5,  0, 0, 0,
            0, 9, 8,  0, 0, 0,  0, 6, 0,

            8, 0, 0,  0, 6, 0,  0, 0, 3,
            4, 0, 0,  8, 0, 3,  0, 0, 1,
            7, 0, 0,  0, 2, 0,  0, 0, 6,

            0, 6, 0,  0, 0, 0,  2, 8, 0,
            0, 0, 0,  4, 1, 9,  0, 0, 5,
            0, 0, 0,  0, 8, 0,  0, 7, 9
        });
    }

    @Test 
    void testInRow() {
        field.setNumber(3, 4);
        assertTrue(field.inRow(3));
    }

    @Test 
    void testNotInRow() {
        field.setNumber(3, 1);
        assertFalse(field.inRow(3));
    }

    @Test 
    void testInColumn() {
        field.setNumber(29, 8);
        assertTrue(field.inColumn(29));
    }

    @Test 
    void testNotInColumn() {
        field.setNumber(29, 5);
        assertFalse(field.inColumn(29));
    }

    @Test 
    void testInBox() {
        field.setNumber(18, 4);
        assertTrue(field.inBox(18));
    }

    @Test 
    void testNotInBox() {
        field.setNumber(18, 1);
        assertFalse(field.inBox(18));
    }
}
