package org.rozenberg.task1.service;

import org.rozenberg.task1.entity.IntArray;
import org.rozenberg.task1.exception.CustomException;

public interface FunctionalService {
    int findMax(IntArray array) throws CustomException;
    int findMin(IntArray array) throws CustomException;
    double findAverage(IntArray array) throws CustomException;
    int findSum(IntArray array) throws CustomException;
    int countPositive(IntArray array) throws CustomException;
    int countNegative(IntArray array) throws CustomException;
    IntArray excludeNegative(IntArray array) throws CustomException;
}
