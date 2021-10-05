package org.rozenberg.task1.validation;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Validation {
    private static final Logger logger = LogManager.getLogger();
    private static final String REG_EX = "^\\s*-?\\d+(\\s+(-?\\d+))*\\s*$";

    public static boolean isValid(String str) throws NumberFormatException {
        logger.log(Level.INFO, "String [" + str + "] validation");
        return str.matches(REG_EX);
    }
}
