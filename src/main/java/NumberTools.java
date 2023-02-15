import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NumberTools {
    public static Map<Integer, Integer> createNumberMap(String numbersFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(numbersFile));
        Map<Integer, Integer> numberMap = new TreeMap<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Integer key = Integer.valueOf(line);
            if (numberMap.containsKey(key)) {
                Integer counter = numberMap.get(key);
                counter += 1;
                numberMap.put(key, counter);
            } else {
                numberMap.put(key, 1);
            }
        }
        return numberMap;
    }

    public static void printResults(Map<Integer, Integer> numberMap) {
        for (Map.Entry<Integer, Integer> entry : numberMap.entrySet()) {
            System.out.println(entry.getKey() + " - liczba wystąpień " + entry.getValue());
        }
    }
}
