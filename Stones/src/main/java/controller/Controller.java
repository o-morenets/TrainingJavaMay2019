package controller;

import i18n.SupportedLocale;
import model.Riviere;
import model.entity.Gemstone;
import view.View;
import view.menu.MainMenu;
import view.menu.GenericMenu;

import java.util.*;
import java.util.regex.Pattern;

import static controller.RegEx.REGEX_MENU_CHOICE;
import static controller.RegEx.REGEX_MENU_NUMBER;
import static controller.RegEx.REGEX_NUMBER;
import static view.TextConstants.*;

public class Controller {

    private final Riviere model;
    private final View view;

    /**
     * Constructor
     *
     * @param model Model object
     * @param view  View object
     */
    public Controller(Riviere model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Process user input and validation
     */
    public void processUser(){
        Scanner sc = new Scanner(System.in);

        view.printlnMessage(MESSAGE_WELCOME);

        boolean goodbye = false;
        do {
            GenericMenu<MainMenu> menuMain = new GenericMenu<>(MainMenu.class);
            view.printMenu(menuMain.getSortedMenu());

            int userChoice = Integer.parseInt(userInput(sc, PROMPT_MENU, STRING_EMPTY, REGEX_MENU_CHOICE));
            MainMenu[] mainMenuValues = MainMenu.values();

            if (userChoice < 0 || userChoice > mainMenuValues.length - 1) {
                view.printlnMessage(WARNING_INVALID_CHOICE);
            } else {
                MainMenu mainMenu = mainMenuValues[userChoice];

                switch (mainMenu) {
                    case ITEM_CREATE_NEW_RIVIERE:
                        model.createNewRiviere();
                        break;

                    case ITEM_ADD_STONE:
                        addStone(sc);
                        break;

                    case ITEM_PRINT_RIVIERE:
                        view.printRiviere(model);
                        break;

                    case ITEM_SORT_STONES:
                        view.printList(model.sortByCost());
                        break;

                    case ITEM_FILTER_BY_TRANSPARENCY_RANGE:
                        filterByTransparency(sc);
                        break;

                    case ITEM_CHANGE_LANGUAGE:
                        changeLanguage(sc);
                        break;

                    case ITEM_EXIT:
                        goodbye = true;
                        break;
                }
            }
        } while (!goodbye);

        view.printMessage(MESSAGE_GOODBYE);
    }

    /**
     * Get a stone from user and add it to the riviere
     *
     * @param sc scanner object
     */
    private void addStone(Scanner sc) {
        GenericMenu<Gemstone> gemstoneMenu = new GenericMenu<>(Gemstone.class);
        view.printMenu(gemstoneMenu.getSortedMenu());

        int userChoice = Integer.parseInt(userInput(sc, PROMPT_MENU, STRING_EMPTY, REGEX_NUMBER));
        Gemstone[] stonesMenuValues = Gemstone.values();

        if (userChoice < 0 || userChoice > stonesMenuValues.length - 1) {
            view.printlnMessage(WARNING_INVALID_CHOICE);
        } else {
            model.addStone(Gemstone.values()[userChoice]);
        }
    }

    /**
     * Get transparency range from user and show filtered riviere
     *
     * @param sc scanner object
     */
    private void filterByTransparency(Scanner sc) {
        int transparencyLow = Integer.parseInt(userInput(sc, PROMPT_INPUT_LOWER_RANGE, HINT_LOWER_RANGE, REGEX_NUMBER));
        int transparencyHigh = Integer.parseInt(userInput(sc, PROMPT_INPUT_HIGHER_RANGE, HINT_HIGHER_RANGE, REGEX_NUMBER));
        view.printList(model.findByTransparencyRange(transparencyLow, transparencyHigh));
    }

    /**
     * Change the language of user interface

     * @param sc scanner object
     */
    private void changeLanguage(Scanner sc) {
        view.printlnMessage();

        SupportedLocale[] supportedLocales = SupportedLocale.values();
        for (SupportedLocale locale : supportedLocales) {
            view.printlnMessage(String.valueOf(locale.ordinal() + 1), DOT, SPACE, locale.name());
        }
        int localeOrdinal = Integer.parseInt(userInput(sc, PROMPT_CHOOSE_LANGUAGE, STRING_EMPTY, REGEX_MENU_NUMBER)) - 1;
        if (localeOrdinal < 0 || localeOrdinal >= supportedLocales.length) {
            view.printlnMessage(WARNING_INVALID_CHOICE);
        } else {
            view.changeResourceBundleForLocale(supportedLocales[localeOrdinal].getLocale());
        }
    }

    /**
     * Get input from user
     *
     * @param sc     scanner object
     * @param prompt text prompt
     * @param regEx  input pattern
     * @return validated string as user input
     */
    private String userInput(Scanner sc, String prompt, String hint, String regEx) {
        String userInput;
        boolean isInputValid;

        do {
            view.printMessage(prompt, SPACE, hint, COLONS, SPACE);
            userInput = sc.nextLine();
            isInputValid = validateInput(userInput, regEx);
            if (!isInputValid) {
                view.printlnMessage(WARNING_NOT_MATCH_PATTERN);
            }
        } while (!isInputValid);

        return userInput;
    }

    /**
     * Validate user input
     *
     * @param userInput user input
     * @param regEx     input pattern
     * @return true if user input is valid, false otherwise
     */
    private boolean validateInput(String userInput, String regEx) {
        return Pattern.compile(view.getFromBundle(regEx)).matcher(userInput).matches();
    }
}
