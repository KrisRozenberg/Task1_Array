package org.rozenberg.task1.service;

import org.rozenberg.task1.entity.IntArray;
import org.rozenberg.task1.exception.CustomException;

public interface SortService {
    void bubbleSort(IntArray array) throws CustomException;
    void mergeSort(IntArray array, int left, int right) throws CustomException;
    void quickSort(IntArray array, int leftBoarder, int rightBoarder) throws CustomException;
}
