package controller;

public class Validator {

    /**
     * Checks whether difference of minBarrier and maxBarrier is not less than 2
     *
     * @param minBarrier minBarrier value
     * @param maxBarrier maxBarrier value
     * @return true if difference of minBarrier and maxBarrier is greater than 1, false otherwise
     */
    static boolean checkBarriers(int minBarrier, int maxBarrier) {
        return Math.abs(maxBarrier - minBarrier) > 1;
    }

    /**
     * Checks whether playerValue is in range
     *
     * @param playerValue value to be checked
     * @param minBarrier  min barrier range
     * @param maxBarrier  max barrier range
     * @return true if playerValue is in range, false otherwise
     */
    static boolean isNumberInRange(int playerValue, int minBarrier, int maxBarrier) {
        return playerValue > minBarrier && playerValue < maxBarrier;
    }
}
