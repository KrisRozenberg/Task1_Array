package test.rozenberg.task1.conversion;

import org.rozenberg.task1.conversion.Conversion;
import org.rozenberg.task1.exception.CustomException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ConversionTest {
    @Test
    public void testConvertStringToIntArray_positive() throws CustomException {
        int[] actual = Conversion.convertStringToIntArray("3 8549      -95   18   ");
        int[] expected = {3, 8549, -95, 18};
        assertEquals(actual, expected, "Conversion test failed");
    }

    @Test (expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp =
            "Provided string cannot be parsed to an integer array")
    public void testConvertStringToIntArray_cannotBeParsedException() throws CustomException {
        Conversion.convertStringToIntArray("3 8549   learn   -95   18   ");
    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp =
            "String parsing is failed: input parameter is null")
    public void testConvertStringToIntArray_nullPointerException() throws CustomException {
        Conversion.convertStringToIntArray(null);
    }
}
