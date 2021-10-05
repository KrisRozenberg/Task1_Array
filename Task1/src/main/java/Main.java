import org.rozenberg.task1.entity.IntArray;
import org.rozenberg.task1.conversion.Conversion;
import org.rozenberg.task1.exception.CustomException;
import org.rozenberg.task1.reading.FileReading;
import org.rozenberg.task1.service.FunctionalService;
import org.rozenberg.task1.service.impl.FunctionalServiceImpl;
import org.rozenberg.task1.service.impl.SortServiceImpl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException, CustomException {
//        Scanner sc = new Scanner(new FileReader("input.txt"));
//        while (sc.hasNext()) {
//            System.out.println(sc.nextLine());
//        }
        FileReading read = new FileReading();
        String str = read.readOneLine("src\\main\\resources\\textfiles\\input.txt");
        IntArray array = new IntArray(Conversion.convertStringToIntArray(str));
        FunctionalServiceImpl functionalService = new FunctionalServiceImpl();
//        System.out.println(functionalService.excludeNegative(array));

//        int[] zero = {3, 5, 6};
//        IntArray arr = new IntArray(zero);
//        zero[0] = 1;
//        System.out.println(arr);
//        int[] smp = arr.getData();
//        smp[2] = 0;
//        System.out.println(arr);
//        arr.setData(smp);
//        System.out.println(arr);
//        smp[1] = 6;
//        System.out.println(arr);

//        Path path = Paths.get("textfiles\\input.txt").toAbsolutePath();
//        URL url = Main.class.getResource("textfiles\\input.txt");
//        Path path = Paths.get(url.toURI());

//        SortServiceImpl sortService = new SortServiceImpl();
//        int[] exa = {3, -9, 12, 0, 2};
//        IntArray arr1 = new IntArray(exa);
//        IntArray arr2 = new IntArray(exa);
//        IntArray arr3 = new IntArray(exa);
//        sortService.bubbleSort(arr1);
//        sortService.mergeSort(arr2, 0, arr2.getData().length-1);
//        sortService.quickSort(arr3, 0, arr3.getData().length-1);
//        System.out.println();
//        System.out.println(arr1);
//        System.out.println(arr2);
//        System.out.println(arr3);
    }
}
