package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by o-morenets on 29.05.2019.
 */
public class Model {

    /** Min barrier */
    private int minBarrier;

    /** Max barrier */
    private int maxBarrier;

    /** Secret value */
    private int secretValue;

    /** Statistics variable */
    private List<Integer> statistics = new ArrayList<>();

    /**
     * Checks whether number is equal to secret number
     * Sets new barrier values
     * Adds number to statistics
     *
     * @param number checked number
     * @return true if number is equal to secret number, false otherwise
     */
    public boolean isNumberGuessed(int number) {
        addToStatistics(number);

        if (number == secretValue) {
            return true;
        } else if (number > secretValue) {
            maxBarrier = number;
        } else {
            minBarrier = number;
        }
        return false;
    }

    /**
     * Adds the number to statistics list
     *
     * @param number number to be added
     */
    private void addToStatistics(int number) {
        statistics.add(number);
    }

    /**
     * Sets initial min and max barrier
     *
     * @param minBarrier min barrier
     * @param maxBarrier max barrier
     */
    public void setInitialBarriers(int minBarrier, int maxBarrier) {
        this.minBarrier = minBarrier;
        this.maxBarrier = maxBarrier;
    }

    // Getters & Setters

    public int getSecretValue() {
        return secretValue;
    }

    /**
     * Sets random secret value in range (minBarrier, maxBarrier)
     */
    public void setSecretNumber() {
        Random rnd = new Random();
        secretValue = rnd.nextInt((maxBarrier - minBarrier) - 1) + (minBarrier + 1);
    }

    public int getMinBarrier() {
        return minBarrier;
    }

    public void setMinBarrier(int minBarrier) {
        this.minBarrier = minBarrier;
    }

    public int getMaxBarrier() {
        return maxBarrier;
    }

    public void setMaxBarrier(int maxBarrier) {
        this.maxBarrier = maxBarrier;
    }

    public List<Integer> getStatistics() {
        return statistics;
    }
}
