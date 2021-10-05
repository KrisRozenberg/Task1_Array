package org.rozenberg.task1.conversion;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rozenberg.task1.exception.CustomException;

import java.util.Arrays;

public class Conversion {
    private static final Logger logger = LogManager.getLogger();

    public static int[] convertStringToIntArray(String str) throws CustomException {
        if (str == null) {
            logger.log(Level.ERROR, "String parsing is failed: input parameter is null");
            throw new CustomException("String parsing is failed: input parameter is null");
        }

        String delimiter = "\\s+";
        String[] array = str.trim().split(delimiter);
        int[] res = new int[array.length];
        try {
            for (int i = 0; i < array.length; i++) {
                res[i] = Integer.parseInt(array[i]);
            }
        }
        catch(NumberFormatException e) {
            logger.log(Level.ERROR, "Provided string cannot be parsed to an integer array");
            throw new CustomException("Provided string cannot be parsed to an integer array");
        }

        logger.log(Level.INFO, "The string has been parsed to an array: " + Arrays.toString(res));
        return res;
    }
}
