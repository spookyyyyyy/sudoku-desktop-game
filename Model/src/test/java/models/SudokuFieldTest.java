package models;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import sudoku.model.models.SudokuField;

public class SudokuFieldTest {

    @Test
    void testCompareTo() {
        SudokuField field1 = new SudokuField(1);
        SudokuField field2 = new SudokuField(2);
        SudokuField field3 = new SudokuField(3);

        assertDoesNotThrow(() -> {
            assertTrue(field1.compareTo(field2) < 0);
            assertTrue(field2.compareTo(field3) < 0);
            assertTrue(field1.compareTo(field3) < 0);
        });

        assertDoesNotThrow(() -> {
            assertTrue(field2.compareTo(field1) > 0);
            assertTrue(field3.compareTo(field2) > 0);
            assertTrue(field3.compareTo(field1) > 0);
        });
    }

    @Test
    void testEqualsAndClone() {
        SudokuField field1 = new SudokuField(5);
        SudokuField field2 = new SudokuField(5);
        
        assertTrue(field1.equals(field2));
        assertTrue(field1.equals(field1));
        assertFalse(field1.equals(null));
        assertFalse(field1.equals("string"));
        
        SudokuField cloned = field1.clone();
        assertEquals(field1, cloned);
    }
}
