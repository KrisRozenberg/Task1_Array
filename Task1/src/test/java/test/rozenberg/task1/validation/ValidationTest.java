package test.rozenberg.task1.validation;

import org.rozenberg.task1.validation.Validation;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidationTest {
    String str_1 = " 0 0 00         256   ";
    String str_2 = "3; 8549  learnyou    -95   18   ";

    @Test
    public void testIsValid_positive() {
        assertTrue(Validation.isValid(str_1));
    }

    @Test
    public void testIsValid_negative() {
        assertFalse(Validation.isValid(str_2));
    }
}
