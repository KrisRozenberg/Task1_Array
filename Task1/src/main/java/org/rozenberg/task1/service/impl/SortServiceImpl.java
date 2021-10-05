package org.rozenberg.task1.service.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rozenberg.task1.entity.IntArray;
import org.rozenberg.task1.exception.CustomException;
import org.rozenberg.task1.service.SortService;

public class SortServiceImpl implements SortService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void bubbleSort(IntArray array) throws CustomException {
        if (array == null) {
            logger.log(Level.ERROR, "Bubble sort is failed: input parameter is null");
            throw new CustomException("Bubble sort is failed: input parameter is null");
        }

        int[] arr = array.getData();
        for (int j = arr.length-1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
        array.setData(arr);
        logger.log(Level.INFO, "Bubble sort completed successfully. The sorted array: " + array);
    }

    @Override
    public void mergeSort(IntArray array, int left, int right) throws CustomException {
        if (array == null) {
            logger.log(Level.ERROR, "Merge sort is failed: input parameter is null");
            throw new CustomException("Merge sort is failed: input parameter is null");
        }
        if (left < 0 || right >= array.getData().length) {
            logger.log(Level.ERROR, "Merge sort is failed: index out of bounds");
            throw new CustomException("Merge sort is failed: index out of bounds");
        }

        int delimiter = left + ((right - left) / 2) + 1;
        int[] arr = array.getData();

        if (delimiter > 0 && right > (left + 1)) {
            mergeSort(array, left, delimiter - 1);
            mergeSort(array, delimiter, right);
            arr = array.getData();
        }

        int[] buffer = new int[right - left + 1];
        int marker = left;
        for (int i = 0; i < buffer.length; i++) {

            if (delimiter > right || arr[marker] < arr[delimiter]) {
                buffer[i] = arr[marker];
                marker++;
            } else {
                buffer[i] = arr[delimiter];
                delimiter++;
            }
        }
        System.arraycopy(buffer, 0, arr, left, buffer.length);
        array.setData(arr);
        if (buffer.length == arr.length) {
            logger.log(Level.INFO, "Merge sort completed successfully. The sorted array: " + array);
        }
    }

    @Override
    public void quickSort(IntArray array, int leftBorder, int rightBorder) throws CustomException{
        if (array == null) {
            logger.log(Level.ERROR, "Quick sort is failed: input parameter is null");
            throw new CustomException("Quick sort is failed: input parameter is null");
        }
        if (leftBorder < 0 || rightBorder >= array.getData().length) {
            logger.log(Level.ERROR, "Quick sort is failed: index out of bounds");
            throw new CustomException("Quick sort is failed: index out of bounds");
        }

        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int[] arr = array.getData();
        int pointer = arr[(leftMarker + rightMarker) / 2];
        do {
            while (arr[leftMarker] < pointer) {
                leftMarker++;
            }
            while (arr[rightMarker] > pointer) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    int tmp = arr[leftMarker];
                    arr[leftMarker] = arr[rightMarker];
                    arr[rightMarker] = tmp;
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        array.setData(arr);
        if (leftMarker < rightBorder) {
            quickSort(array, leftMarker, rightBorder);
        }
        else if (leftBorder < rightMarker) {
            quickSort(array, leftBorder, rightMarker);
        }
        else {
            logger.log(Level.INFO, "Quick sort completed successfully. The sorted array: " + array);
        }
    }
}
