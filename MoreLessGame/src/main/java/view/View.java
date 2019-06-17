package view;

import java.util.List;

/**
 * Created by o-morenets on 29.05.2019.
 */
public class View {

    /* Text constants */
    public static final String INPUT_INT_VALUE = "Input an INTEGER value:";
    public static final String INPUT_INT_VALUE_IN_RANGE = "Input an integer value in range";
    public static final String INVALID_INT_VALUE = "Invalid integer value!";
    public static final String WRONG_RANGE = "Out of range!";
    public static final String INPUT_BARRIERS = "Select barriers";
    public static final String INPUT_MIN_BARRIER = "Input MIN barrier:";
    public static final String INPUT_MAX_BARRIER = "Input MAX barrier:";
    public static final String WRONG_BARRIERS = "Wrong barriers!";
    public static final String CONGRATULATIONS = "CONGRATULATIONS !!!";
    public static final String SECRET_VALUE_WAS = "The secret value was";
    public static final String SPACE = " ";
    public static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String STATISTICS = "Statistics:";

    /**
     * Prints a message
     *
     * @param message message to be printed
     */
    public void printMessage(String message) {
        System.out.print(message);
    }

    /**
     * Prints statistics list
     *
     * @param statistics list to be printed
     */
    public void printStatistics(List<Integer> statistics) {
        printMessage(STATISTICS + LINE_SEPARATOR);
        for (Integer i : statistics) {
            System.out.println(i);
        }
    }
}
