package test.rozenberg.task1.service.impl;

import org.rozenberg.task1.entity.IntArray;
import org.rozenberg.task1.exception.CustomException;
import org.rozenberg.task1.service.impl.SortServiceImpl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SortServiceImplTest {
    SortServiceImpl sortService;
    IntArray testArray_1 = new IntArray(new int[]{5, 128, 8, -3, 0});
    IntArray testArray_2 = new IntArray(new int[]{5, 128, 8, -3, 0});
    IntArray testArray_3 = new IntArray(new int[]{5, 128, 8, -3, 0});

    @BeforeClass
    public void setUp() {
        sortService = new SortServiceImpl();
    }

    @Test
    public void testBubbleSort_positive() throws CustomException {
        sortService.bubbleSort(testArray_1);
        IntArray expected = new IntArray(new int[]{-3, 0, 5, 8, 128});
        assertEquals(testArray_1.getData(), expected.getData(), "BubbleSort test failed");
    }
    @Test (expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp =
            "Bubble sort is failed: input parameter is null")
    public void testBubbleSort_nullPointerException() throws CustomException {
        sortService.bubbleSort(null);
    }
    @Test
    public void testMergeSort_positive() throws CustomException {
        sortService.bubbleSort(testArray_2);
        IntArray expected = new IntArray(new int[]{-3, 0, 5, 8, 128});
        assertEquals(testArray_2.getData(), expected.getData(), "MergeSort test failed");
    }
    @Test (expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp =
            "Merge sort is failed: input parameter is null")
    public void testMergeSort_nullPointerException() throws CustomException {
        sortService.mergeSort(null, 0,5);
    }
    @Test (expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp =
            "Merge sort is failed: index out of bounds")
    public void testMergeSort_outOfBoundsException() throws CustomException {
        sortService.mergeSort(testArray_2, 0,5);
    }
    @Test
    public void testQuickSort_positive() throws CustomException {
        sortService.bubbleSort(testArray_3);
        IntArray expected = new IntArray(new int[]{-3, 0, 5, 8, 128});
        assertEquals(testArray_3.getData(), expected.getData(), "QuickSort test failed");
    }
    @Test (expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp =
            "Quick sort is failed: input parameter is null")
    public void testQuickSort_nullPointerException() throws CustomException {
        sortService.quickSort(null, 0,5);
    }
    @Test (expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp =
            "Quick sort is failed: index out of bounds")
    public void testQuickSort_outOfBoundsException() throws CustomException {
        sortService.quickSort(testArray_3, 0,5);
    }

    @AfterClass
    public void tearDown() {
        sortService = null;
    }
}
