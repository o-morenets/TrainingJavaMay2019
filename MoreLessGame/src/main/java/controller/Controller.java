package controller;

import model.Model;
import view.View;

import java.util.Scanner;

/**
 * Created by o-morenets on 29.05.2019.
 */
public class Controller {

    private Model model;
    private View view;

    /**
     * 0-arg constructor
     * For testing purposes only
     */
    public Controller() {
    }

    /**
     * All-args constructor
     *
     * @param model model object
     * @param view  view object
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Process user commands
     */
    public void processUser() {
        Scanner sc = new Scanner(System.in);

        inputAndSetBarriers(sc);
        model.setSecretNumber();

        while (!model.isNumberGuessed(inputValidIntValueInRange(sc, model.getMinBarrier(), model.getMaxBarrier()))) {
        }

        view.printMessage(View.CONGRATULATIONS + View.LINE_SEPARATOR);
        view.printMessage(View.SECRET_VALUE_WAS + View.SPACE + model.getSecretValue() + View.LINE_SEPARATOR);
        view.printStatistics(model.getStatistics());
    }

    /**
     * Prompts user for input barrier values and takes the input data
     *
     * @param sc Scanner object
     */
    public void inputAndSetBarriers(Scanner sc) {
        int minBarrier;
        int maxBarrier;

        do {
            view.printMessage(View.INPUT_BARRIERS + View.LINE_SEPARATOR);
            view.printMessage(View.INPUT_MIN_BARRIER + View.SPACE);
            minBarrier = inputValidIntValue(sc);
            view.printMessage(View.INPUT_MAX_BARRIER + View.SPACE);
            maxBarrier = inputValidIntValue(sc);
            if (Validator.checkBarriers(minBarrier, maxBarrier)) {
                break;
            }
            view.printMessage(View.WRONG_BARRIERS + View.LINE_SEPARATOR);
        } while (true);

        setBarriers(minBarrier, maxBarrier);
    }

    /**
     * Set barriers
     * if maxBarrier < minBarrier, swaps their values
     *
     * @param minBarrier lower bound
     * @param maxBarrier higher bound
     */
    private void setBarriers(int minBarrier, int maxBarrier) {
        if (maxBarrier > minBarrier) {
            model.setInitialBarriers(minBarrier, maxBarrier);
        } else {
            model.setInitialBarriers(maxBarrier, minBarrier);
        }
    }

    /**
     * Prompts user for input a valid integer and takes an input data
     *
     * @param sc Scanner object
     * @return valid integer value
     */
    private int inputValidIntValue(Scanner sc) {
        while (!sc.hasNextInt()) {
            view.printMessage(View.INVALID_INT_VALUE + View.LINE_SEPARATOR);
            sc.nextLine();
            view.printMessage(View.INPUT_INT_VALUE + View.SPACE);
        }
        int returnValue = sc.nextInt();
        sc.nextLine();
        return returnValue;
    }

    /**
     * Prompts user for input an integer in given range and takes an input data
     *
     * @param sc         Scanner object
     * @param minBarrier min barrier range
     * @param maxBarrier max barrier range
     * @return valid integer in given range
     */
    public int inputValidIntValueInRange(Scanner sc, int minBarrier, int maxBarrier) {
        int playerNumber;
        do {
            view.printMessage(View.INPUT_INT_VALUE_IN_RANGE + View.SPACE + "(" + minBarrier + ", " + maxBarrier + "): ");
            playerNumber = inputValidIntValue(sc);
            if (Validator.isNumberInRange(playerNumber, model.getMinBarrier(), model.getMaxBarrier())) {
                break;
            }
            view.printMessage(View.WRONG_RANGE + View.LINE_SEPARATOR);
        } while (true);

        return playerNumber;
    }

    // Model & View Setters

    public void setModel(Model model) {
        this.model = model;
    }

    public void setView(View view) {
        this.view = view;
    }
}
