package rf01.com.company.controller;

import rf01.com.company.view.View;
import rf01.com.company.view.TextConstant;

import java.util.Scanner;

/**
 * Created by student on 26.09.2017.
 */
public class InputNoteNoteBook {
    private View view;
    private Scanner sc;

    private String firstName;
    private String login;

    public InputNoteNoteBook(View view, Scanner sc) {
        this.view = view;
        this.sc = sc;
    }

    public void inputNote() {
        UtilityController utilityController =
                new UtilityController(sc, view);
        String str = (String.valueOf(View.bundle.getLocale()).equals("ua"))
                ? RegexContainer.REGEX_NAME_UKR : RegexContainer.REGEX_NAME_LAT;

        this.firstName =
                utilityController.inputStringValueWithScanner
                        (TextConstant.FIRST_NAME, str);
        this.login =
                utilityController.inputStringValueWithScanner
                        (TextConstant.LOGIN_DATA, RegexContainer.REGEX_LOGIN);
    }
}
