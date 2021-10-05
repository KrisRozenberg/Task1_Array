package test.rozenberg.task1.reading;

import org.rozenberg.task1.exception.CustomException;
import org.rozenberg.task1.reading.FileReading;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URISyntaxException;

import static org.testng.Assert.assertEquals;

public class FileReadingTest {
    String good_file_path = "src\\test\\resources\\textfiles\\test_1.txt";
    String empty_file_path = "src\\test\\resources\\textfiles\\test_2.txt";
    String no_valid_file_path = "src\\test\\resources\\textfiles\\test_3.txt";
    String noExisting_file_path = "src\\test\\resources\\textfiles\\test_4.txt";
    String directory_path = "src\\test\\resources\\textfiles";
    String null_path = null;

    FileReading testRead;

    @BeforeClass
    public void setUp() {
        testRead = new FileReading();
    }

    @Test
    public void testReadOneLine_positive() throws CustomException {
        String actual = testRead.readOneLine(good_file_path);
        String expected = "0 0 00         256";
        assertEquals(actual, expected, "ReadOneLine test failed");
    }
    @Test (expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "Input filepath is null")
    public void testReadOneLine_nullPointerException() throws CustomException {
        testRead.readOneLine(null_path);
    }
    @Test (expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "Provided file is a directory")
    public void testReadOneLine_isDirectoryException() throws CustomException {
        testRead.readOneLine(directory_path);
    }
    @Test (expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "Provided file does not exist")
    public void testReadOneLine_noExistingFileException() throws CustomException {
        testRead.readOneLine(noExisting_file_path);
    }
    @Test (expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "Provided file is empty")
    public void testReadOneLine_emptyFileException() throws CustomException {
        testRead.readOneLine(empty_file_path);
    }
    @Test (expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "No valid strings")
    public void testReadOneLine_noValidStringException() throws CustomException {
        testRead.readOneLine(no_valid_file_path);
    }

    @AfterClass
    public void tearDown() {
        testRead = null;
    }
}
