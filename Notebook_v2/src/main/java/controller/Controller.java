package controller;

import exception.NotUniqueLoginException;
import i18n.SupportedLocale;
import model.Model;
import model.entity.Group;
import model.entity.Record;
import view.View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static controller.RegularExpressions.*;
import static view.TextConstants.*;

/**
 * Created by o-morenets on 03.06.2019
 */
public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
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
            printMenu();

            int userChoice = Integer.parseInt(userInput(sc, PROMPT_MENU, STRING_EMPTY, REGEX_MENU_CHOICE));
            MainMenu[] mainMenuValues = MainMenu.values();

            if (userChoice < 0 || userChoice > mainMenuValues.length - 1) {
                view.printlnMessage(WARNING_INVALID_CHOICE);
            } else {
                view.printlnMessage();

                MainMenu mainMenu = mainMenuValues[userChoice];

                switch (mainMenu) {
                    case ITEM_ADD_RECORD:
                        addRecord(sc);
                        break;

                    case ITEM_CHANGE_LANGUAGE:
                        changeLanguage(sc);
                        break;

                    case ITEM_PRINT_NOTEBOOK:
                        view.printNotebook(model);
                        break;

                    case ITEM_EXIT:
                        goodbye = true;
                        break;
                }
            }
        } while (!goodbye);

        view.printMessage(MESSAGE_THANK_YOU);
    }

    /**
     * Print user menu
     */
    private void printMenu() {
        view.printlnMessage();

        MainMenu[] mainMenuValues = Stream.of(MainMenu.values())
                .sorted(Comparator.comparing(MainMenu::getSortOrder))
                .toArray(MainMenu[]::new);

        for (MainMenu menu : mainMenuValues) {
            view.printlnMessage(String.valueOf(menu.ordinal()), DOT, SPACE, menu.getBundleKey());
        }
    }

    /**
     * Asks user for necessary data using scanner and adds record to the model
     *
     * @param sc scanner object
     */
    private void addRecord(Scanner sc) {
        Record record = new Record();

        record.setLogin(userInput(sc, FIELD_LOGIN, HINT_LOGIN, REGEX_LOGIN));
        record.setFirstName(userInput(sc, FIELD_FIRSTNAME, HINT_FIRST_NAME, REGEX_NAME));
        record.setLastName(userInput(sc, FIELD_LASTNAME, HINT_LAST_NAME, REGEX_NAME));
        record.setMiddleName(userInput(sc, FIELD_MIDDLENAME, HINT_MIDDLE_NAME, REGEX_NAME));
        record.setNickName(userInput(sc, FIELD_NICKNAME, HINT_NICK_NAME, REGEX_NICK_NAME));
        record.setComment(userInput(sc, FIELD_COMMENT, HINT_COMMENT, REGEX_COMMENT));
        record.setGroup(Group.valueOf(userInput(sc, FIELD_GROUP, HINT_GROUP, REGEX_GROUP)));
        record.setHomePhone(userInput(sc, FIELD_PHONE_HOME, HINT_HOME_PHONE, REGEX_HOME_PHONE));
        record.setCellPhone(userInput(sc, FIELD_PHONE_CELL, HINT_CELL_PHONE, REGEX_CELL_PHONE));

        if (userInput(sc, QUESTION_YES_NO_PHONE2, HINT_YES_NO, REGEX_YES_NO)
                .matches(view.getFromBundle(REGEX_ANSWER_YES))) {

            record.setCellPhone2(userInput(sc, FIELD_PHONE_CELL2, HINT_CELL_PHONE_2, REGEX_CELL_PHONE_2));
        }

        record.setEmail(userInput(sc, FIELD_EMAIL, HINT_EMAIL, REGEX_EMAIL));
        record.setSkype(userInput(sc, FIELD_SKYPE, HINT_SKYPE, REGEX_SKYPE));

        view.printlnMessage(PROMPT_ADDRESS);

        record.getAddress().setPostalCode(Integer.parseInt(userInput(sc,
                FIELD_ADDRESS_POSTAL_CODE, HINT_ADDRESS_POSTAL_CODE, REGEX_POSTAL_CODE)));

        record.getAddress().setCity(userInput(sc, FIELD_ADDRESS_CITY, HINT_ADDRESS_CITY, REGEX_CITY));
        record.getAddress().setStreet(userInput(sc, FIELD_ADDRESS_STREET, HINT_ADDRESS_STREET, REGEX_STREET));
        record.getAddress().setHomeNumber(userInput(sc,
                FIELD_ADDRESS_HOME_NUMBER, HINT_ADDRESS_HOME_NUMBER, REGEX_HOME_NUMBER));

        record.getAddress().setApartmentNumber(userInput(sc,
                FIELD_ADDRESS_APARTMENT_NUMBER, HINT_ADDRESS_APARTMENT_NUMBER, REGEX_APARTMENT_NUMBER));

        String dateRecordCreatedStr = userInput(sc,
                FIELD_DATE_RECORD_CREATED, HINT_DATE, REGEX_DATE);

        LocalDate dateRecordCreated = LocalDate.parse(dateRecordCreatedStr,
                DateTimeFormatter.ofPattern(view.getFromBundle(FORMAT_DATE_INPUT)));

        record.setDateRecordCreated(dateRecordCreated);

        String dateRecordUpdatedStr = userInput(sc,
                FIELD_DATE_RECORD_UPDATED, HINT_DATE, REGEX_DATE);

        LocalDate dateRecordUpdated = LocalDate.parse(dateRecordUpdatedStr,
                DateTimeFormatter.ofPattern(view.getFromBundle(FORMAT_DATE_INPUT)));

        record.setDateRecordUpdated(dateRecordUpdated);

        boolean isLoginUnique = false;
        do {
            try {
                model.add(record);
                isLoginUnique = true;
            } catch (NotUniqueLoginException e) {
                view.printlnMessage(WARNING_NOT_UNIQUE_LOGIN, COLONS, SPACE, e.getLogin());
                record.setLogin(userInput(sc, FIELD_LOGIN, HINT_LOGIN, REGEX_LOGIN));
            }
        } while (!isLoginUnique);
    }

    /**
     * Change the language of user interface

     * @param sc scanner object
     */
    private void changeLanguage(Scanner sc) {
        SupportedLocale[] supportedLocales = SupportedLocale.values();
        for (SupportedLocale locale : supportedLocales) {
            view.printlnMessage(String.valueOf(locale.ordinal() + 1), DOT, SPACE, locale.name());
        }
        int localeOrdinal = Integer.parseInt(userInput(sc, CHOOSE_LANGUAGE, STRING_EMPTY, REGEX_NUMBER)) - 1;
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
