package org.rozenberg.task1.service.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rozenberg.task1.entity.IntArray;
import org.rozenberg.task1.exception.CustomException;
import org.rozenberg.task1.service.FunctionalService;

import java.util.Arrays;

public class FunctionalServiceImpl implements FunctionalService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public int findMax(IntArray array) throws CustomException {
        if (array == null) {
            logger.log(Level.ERROR, "Finding max operation cannot be applied: input parameter is null");
            throw new CustomException("Finding max operation cannot be applied: input parameter is null");
        }

        int[] data = array.getData();
        int result = Arrays.stream(data)
                .max()
                .getAsInt();

        logger.log(Level.INFO, "Found max element of the array: " + result);
        return result;
    }

    @Override
    public int findMin(IntArray array) throws CustomException {
        if (array == null) {
            logger.log(Level.ERROR, "Finding min operation cannot be applied: input parameter is null");
            throw new CustomException("Finding min operation cannot be applied: input parameter is null");
        }

        int[] data = array.getData();
        int result = Arrays.stream(data)
                .min()
                .getAsInt();

        logger.log(Level.INFO, "Found min element of the array: " + result);
        return result;
    }

    @Override
    public double findAverage(IntArray array) throws CustomException {
        if (array == null) {
            logger.log(Level.ERROR, "Finding average operation cannot be applied: input parameter is null");
            throw new CustomException("Finding average operation cannot be applied: input parameter is null");
        }

        int[] data = array.getData();
        double result = Arrays.stream(data)
                .average()
                .getAsDouble();

        logger.log(Level.INFO, "Found average of the array's elements: " + result);
        return result;
    }

    @Override
    public int findSum(IntArray array) throws CustomException {
        if (array == null) {
            logger.log(Level.ERROR, "Finding sum operation cannot be applied: input parameter is null");
            throw new CustomException("Finding sum operation cannot be applied: input parameter is null");
        }

        int[] data = array.getData();
        int result = Arrays.stream(data)
                .sum();

        logger.log(Level.INFO, "Found sum of the array's elements: " + result);
        return result;
    }

    @Override
    public int countPositive (IntArray array) throws CustomException {
        if (array == null) {
            logger.log(Level.ERROR, "Counting positive numbers operation cannot be applied: input parameter is null");
            throw new CustomException("Counting positive numbers operation cannot be applied: input parameter is null");
        }

        int[] data = array.getData();
        int result = (int) Arrays.stream(data)
                .filter(value -> value > 0)
                .count();

        logger.log(Level.INFO, "Found number of positive values in array: " + result);
        return result;
    }

    @Override
    public int countNegative (IntArray array) throws CustomException {
        if (array == null) {
            logger.log(Level.ERROR, "Counting negative numbers operation cannot be applied: input parameter is null");
            throw new CustomException("Counting negative numbers operation cannot be applied: input parameter is null");
        }

        int[] data = array.getData();
        int result = (int) Arrays.stream(data)
                .filter(value -> value < 0)
                .count();

        logger.log(Level.INFO, "Found number of negative values in array: " + result);
        return result;
    }

    @Override
    public IntArray excludeNegative (IntArray array) throws CustomException {
        if (array == null) {
            logger.log(Level.ERROR, "Excluding negative numbers operation cannot be applied: input parameter is null");
            throw new CustomException("Excluding negative numbers operation cannot be applied: input parameter is null");
        }

        int[] data = array.getData();
        data = Arrays.stream(data).map(value -> (value < 0) ? (value = 0) : value).toArray();
        IntArray result = new IntArray(data);
        logger.log(Level.INFO, "Transformed array with zero vice negative numbers: " + result);
        return result;
    }
}
