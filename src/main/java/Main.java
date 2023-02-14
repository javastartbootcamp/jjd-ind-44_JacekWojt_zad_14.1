import java.io.FileNotFoundException;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            String numbersFile = "numbers.txt";
            Map<Integer, Integer> numberMap = NumberTools.createNumberMap(numbersFile);
            NumberTools.printResults(numberMap);
        } catch (FileNotFoundException e) {
            System.out.println("Nie odnaleziono pliku.");
        }
    }
}
