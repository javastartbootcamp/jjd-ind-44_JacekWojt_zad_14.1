import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NumberTools {
    public static Map<Integer, Integer> createNumberMap(String numbersFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(numbersFile));
        int lines = countLines(numbersFile);
        Map<Integer, Integer> numberMap = new TreeMap<>();
        for (int i = 0; i < lines; i++) {
            String line = scanner.nextLine();
            Integer value = Integer.valueOf(line);
            if (numberMap.containsKey(value)) {
                Integer counter = numberMap.get(value);
                counter += 1;
                numberMap.remove(value);
                numberMap.put(value, counter);
            } else {
                numberMap.put(value, 1);
            }
        }
        return numberMap;
    }

    private static int countLines(String fileName) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int lines = 0;
            while (scanner.hasNextLine()) {
                lines++;
                scanner.nextLine();
            }
            return lines;
        }
    }

    public static void printResults(Map<Integer, Integer> numberMap) {
        for (Map.Entry<Integer, Integer> entry : numberMap.entrySet()) {
            System.out.println(entry.getKey() + " - liczba wystąpień " + entry.getValue());
        }
    }
}
