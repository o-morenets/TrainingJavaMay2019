package controller;

import model.Model;
import view.View;

import java.util.Scanner;

public class Controller {

    /** Model object */
    private Model model;

    /** View object */
    private View view;

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
     * Process user input
     */
    public void processUser() {
        Scanner sc = new Scanner(System.in);

        String firstString = inputStringByPattern(sc, View.HELLO);
        model.setFirstString(firstString);

        String secondString = inputStringByPattern(sc, View.WORLD);
        model.setSecondString(secondString);

        view.printMessage(model.getFullString());
    }

    /**
     * Ask user for word specified by <code>pattern</code>
     *
     * @param sc      Scanner object
     * @param pattern pattern word
     * @return string matching pattern
     */
    private String inputStringByPattern(Scanner sc, String pattern) {
        String returnValue;
        do {
            view.printMessage(View.PLEASE_TYPE + pattern);
            returnValue = inputStringValueWithScanner(sc);
        } while (!Validator.isEqual(returnValue, pattern));
        return returnValue;
    }

    /**
     * Ask user for a string value
     *
     * @param sc Scanner object
     * @return a string value from scanner
     */
    private String inputStringValueWithScanner(Scanner sc) {
        view.printMessage(View.INPUT_STRING_DATA);
        return sc.nextLine();
    }

}
