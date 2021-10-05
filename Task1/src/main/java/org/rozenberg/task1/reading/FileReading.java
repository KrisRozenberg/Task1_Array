package org.rozenberg.task1.reading;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rozenberg.task1.exception.CustomException;
import org.rozenberg.task1.validation.Validation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class FileReading {
    private static final Logger logger = LogManager.getLogger();

    public String readOneLine(String filePath) throws CustomException {
        if (filePath == null) {
            logger.log(Level.FATAL, "Input filepath is null");
            throw new CustomException("Input filepath is null");
        }

        File file = new File(filePath);
        if (file.isDirectory()) {
            logger.log(Level.FATAL, "Provided file is a directory");
            throw new CustomException("Provided file is a directory");
        }
        if (!file.exists()) {
            logger.log(Level.FATAL, "Provided file does not exist");
            throw new CustomException("Provided file does not exist");
        }
        if (file.length() == 0) {
            logger.log(Level.FATAL, "Provided file is empty");
            throw new CustomException("Provided file is empty");
        }

        Path path = Paths.get(filePath);
        String str;

//        ClassLoader loader = getClass().getClassLoader();
//        URL resource = loader.getResource(pathToFile);
//        Path path = Paths.get(resource.toURI());

        try(Stream<String> allLines = Files.lines(path)) {
            str = allLines
                    .filter(Validation::isValid)
                    .findFirst()
                    .get();
        } catch (IOException e) {
            logger.log(Level.ERROR, "Error while reading file");
            throw new CustomException("Error while reading file");
        } catch (NoSuchElementException e) {
            logger.log(Level.ERROR, "No valid strings");
            throw new CustomException("No valid strings");
        }

        logger.log(Level.INFO, filePath + "file reading is complete. The result string: " + str);
        return str;
    }
}
