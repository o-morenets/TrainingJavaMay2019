package view;

public interface TextConstants {

    /* Text constants */

    String STRING_EMPTY = "";
    String SPACE = " ";
    String COLONS = ":";
    String DOT = ".";
    String LINE_END = System.lineSeparator();


    /* Messages */

    String MESSAGE_WELCOME = "message.welcome";
    String MESSAGE_THANK_YOU = "message.thankYou";


    /* Prompts & Questions*/

    String PROMPT_ADDRESS = "prompt.inputAddress";
    String CHOOSE_LANGUAGE = "prompt.chooseLanguage";
    String QUESTION_YES_NO_PHONE2 = "question.yesNoPhone2";


    /* Warnings */

    String WARNING_NOT_MATCH_PATTERN = "warning.notMatchPattern";
    String WARNING_INVALID_CHOICE = "warning.invalidChoice";
    String WARNING_NOT_UNIQUE_LOGIN = "warning.notuniquelogin";


    /* Main menu */

    String PROMPT_MENU = "menu.prompt";

    enum MainMenu {
        ITEM_EXIT(100, "menu.item.exit"),
        ITEM_ADD_RECORD(1, "menu.item.addRecord"),
        ITEM_CHANGE_LANGUAGE(2, "menu.item.changeLanguage"),
        ITEM_PRINT_NOTEBOOK(3, "menu.item.printNotebook");

        private int sortOrder;
        private String bundleKey;

        MainMenu(int sortOrder, String bundleKey) {
            this.sortOrder = sortOrder;
            this.bundleKey = bundleKey;
        }

        // Getters & Setters

        public int getSortOrder() {
            return sortOrder;
        }

        public String getBundleKey() {
            return bundleKey;
        }
    }


    /* Formats */

    String FORMAT_DATE_INPUT = "format.dateInput";
    String FORMAT_DATE_OUTPUT = "format.dateOutput";


    /* Field names */

    String FIELD_LOGIN = "field.login";
    String FIELD_FIRSTNAME = "field.firstname";
    String FIELD_LASTNAME = "field.lastname";
    String FIELD_MIDDLENAME = "field.middlename";
    String FIELD_FULLNAME = "field.fullname";
    String FIELD_NICKNAME = "field.nickname";
    String FIELD_COMMENT = "field.comment";
    String FIELD_GROUP = "field.group";
    String FIELD_PHONE_HOME = "field.phone.home";
    String FIELD_PHONE_CELL = "field.phone.cell";
    String FIELD_PHONE_CELL2 = "field.phone.cell2";
    String FIELD_EMAIL = "field.email";
    String FIELD_SKYPE = "field.skype";
    String FIELD_ADDRESS_FULL = "field.address.full";
    String FIELD_ADDRESS_POSTAL_CODE = "field.address.postalCode";
    String FIELD_ADDRESS_CITY = "field.address.city";
    String FIELD_ADDRESS_STREET = "field.address.street";
    String FIELD_ADDRESS_HOME_NUMBER = "field.address.homeNumber";
    String FIELD_ADDRESS_APARTMENT_NUMBER = "field.address.apartmentNumber";
    String FIELD_DATE_RECORD_CREATED = "field.date.recordCreated";
    String FIELD_DATE_RECORD_UPDATED = "field.date.recordUpdated";


    /* Field hints */

    String HINT_LOGIN = "hint.login";
    String HINT_FIRST_NAME = "hint.firstname";
    String HINT_LAST_NAME = "hint.lastname";
    String HINT_MIDDLE_NAME = "hint.middlename";
    String HINT_NICK_NAME = "hint.nickname";
    String HINT_COMMENT = "hint.comment";
    String HINT_GROUP = "hint.group";
    String HINT_HOME_PHONE = "hint.phone.home";
    String HINT_CELL_PHONE = "hint.phone.cell";
    String HINT_YES_NO = "hint.yes.no";
    String HINT_CELL_PHONE_2 = "hint.phone.cell2";
    String HINT_EMAIL = "hint.email";
    String HINT_SKYPE = "hint.skype";
    String HINT_ADDRESS_POSTAL_CODE = "hint.address.postalCode";
    String HINT_ADDRESS_CITY = "hint.address.city";
    String HINT_ADDRESS_STREET = "hint.address.street";
    String HINT_ADDRESS_HOME_NUMBER = "hint.address.homeNumber";
    String HINT_ADDRESS_APARTMENT_NUMBER = "hint.address.apartmentNumber";
    String HINT_DATE = "hint.date";
}
