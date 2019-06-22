import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountFrequencies {

    /**
     * Frequencies of numbers from ArrayList using loops
     *
     * @param list list of integers
     * @return numbers frequencies map
     */
    private static Map<Integer, Long> freqMapJava7(ArrayList<Integer> list) {
        Map<Integer, Long> frequencies = new TreeMap<>();
        for (Integer num : list) {
            Long count = frequencies.get(num);
            if (count == null) {
                count = 0L;
            }
            frequencies.put(num, count + 1);
        }
        return frequencies;
    }

    /**
     * Frequencies of numbers from ArrayList using streams
     *
     * @param list list of integers
     * @return numbers frequencies map
     */
    private static Map<Integer, Long> freqMapJava8(ArrayList<Integer> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    /**
     * Helper method. Prints a map
     *
     * @param frequencies frequencies map
     */
    private static void printMap(Map<Integer, Long> frequencies) {
        frequencies.forEach((k, v) -> System.out.println(k + " - " + v));
    }

    /**
     * Runner function
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4, 5, -6, 4, 5, 3, 4, 2, 4, 5, 7));

        System.out.println("Java7");
        Map<Integer, Long> freqMapJava7 = freqMapJava7(list);
        printMap(freqMapJava7);

        System.out.println("Java8");
        Map<Integer, Long> freqMapJava8 = freqMapJava8(list);
        printMap(freqMapJava8);
    }
}
