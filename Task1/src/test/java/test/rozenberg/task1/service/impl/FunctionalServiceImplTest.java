package test.rozenberg.task1.service.impl;

import org.rozenberg.task1.exception.CustomException;
import org.rozenberg.task1.service.impl.FunctionalServiceImpl;
import org.rozenberg.task1.entity.IntArray;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FunctionalServiceImplTest {
    FunctionalServiceImpl functionalService;
    IntArray testArray = new IntArray(new int[]{5, 8, -3, 0});

    @BeforeClass
    public void setUp() {
        functionalService = new FunctionalServiceImpl();
    }

    @Test()
    public void testFindMax_positive() throws CustomException {
        int actual = functionalService.findMax(testArray);
        int expected = 8;
        assertEquals(actual, expected, "FindMax test failed");
    }
    @Test (expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp =
            "Finding max operation cannot be applied: input parameter is null")
    public void testFindMax_nullPointerException() throws CustomException {
        functionalService.findMax(null);
    }
    @Test()
    public void testFindMin_positive() throws CustomException {
        int actual = functionalService.findMin(testArray);
        int expected = -3;
        assertEquals(actual, expected, "FindMin test failed");
    }
    @Test (expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp =
            "Finding min operation cannot be applied: input parameter is null")
    public void testFindMin_nullPointerException() throws CustomException {
        functionalService.findMin(null);
    }
    @Test()
    public void testFindAverage_positive() throws CustomException {
        double actual = functionalService.findAverage(testArray);
        double expected = 2.5;
        assertEquals(actual, expected, 0.001, "FindAverage test failed");
    }
    @Test (expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp =
            "Finding average operation cannot be applied: input parameter is null")
    public void testFindAverage_nullPointerException() throws CustomException {
        functionalService.findAverage(null);
    }
    @Test()
    public void testFindSum_positive() throws CustomException {
        int actual = functionalService.findSum(testArray);
        int expected = 10;
        assertEquals(actual, expected, "FindSum test failed");
    }
    @Test (expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp =
            "Finding sum operation cannot be applied: input parameter is null")
    public void testFindSum_nullPointerException() throws CustomException {
        functionalService.findSum(null);
    }
    @Test()
    public void testCountPositive_positive() throws CustomException {
        int actual = functionalService.countPositive(testArray);
        int expected = 2;
        assertEquals(actual, expected, "CountPositive test failed");
    }
    @Test (expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp =
            "Counting positive numbers operation cannot be applied: input parameter is null")
    public void testCountPositive_nullPointerException() throws CustomException {
        functionalService.countPositive(null);
    }
    @Test()
    public void testCountNegative_positive() throws CustomException {
        int actual = functionalService.countNegative(testArray);
        int expected = 1;
        assertEquals(actual, expected, "CountNegative test failed");
    }
    @Test (expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp =
            "Counting negative numbers operation cannot be applied: input parameter is null")
    public void testCountNegative_nullPointerException() throws CustomException {
        functionalService.countNegative(null);
    }
    @Test()
    public void testExcludeNegative_positive() throws CustomException {
        IntArray actual = functionalService.excludeNegative(testArray);
        IntArray expected = new IntArray(new int[]{5, 8, 0, 0});
        assertEquals(actual.getData(), expected.getData(), "ExcludeNegative test failed");
    }
    @Test (expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp =
            "Excluding negative numbers operation cannot be applied: input parameter is null")
    public void testExcludeNegative_nullPointerException() throws CustomException {
        functionalService.excludeNegative(null);
    }

    @AfterClass
    public void tearDown() {
        functionalService = null;
    }
}

