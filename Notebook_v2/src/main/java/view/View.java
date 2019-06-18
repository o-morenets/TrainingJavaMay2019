package view;

import i18n.SupportedLocale;
import model.Model;
import model.entity.Record;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import static view.TextConstants.*;

/**
 * Created by o-morenets on 03.06.2019
 */
public class View {

    /** Bundle file */
    public static final String BUNDLE_FILE = "messages";

    private ResourceBundle bundle;

    /**
     * Constructs View object with bundle based on default locale (from supported locales list)
     */
    public View() {
        SupportedLocale currentLocale = SupportedLocale.UA;
        changeResourceBundleForLocale(currentLocale.getLocale());
    }

    /**
     * Initializes ResourceBundle for specified locale
     * @param locale locale
     */
    public void changeResourceBundleForLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(BUNDLE_FILE, locale);
    }

    /**
     * Prints the message combined from words
     * If message not found in bundle, prints it "as is"
     *
     * @param words words to print
     */
    public void printMessage(String... words) {
        for (String word : words) {
            if (word != null) {
                try {
                    System.out.print(getFromBundle(word));
                } catch (MissingResourceException e) {
                    System.out.print(word);
                }
            }
        }
    }

    /**
     * Prints the message combined from words followed by LINE_END character
     * If message not found in bundle, prints it "as is"
     *
     * @param words words to print
     */
    public void printlnMessage(String... words) {
        printMessage(words);
        printMessage(LINE_END);
    }

    /**
     * Get the value from bundle for given string key
     * @param str string key
     * @return the value from bundle for given string key
     */
    public String getFromBundle(String str) {
        return bundle.getString(str);
    }

    /**
     * Prints all model records
     * @param model model data structure
     */
    public void printNotebook(Model model) {
        for (Record record : model.getRecords()) {
            printlnMessage(FIELD_LOGIN, COLONS, SPACE, record.getLogin());
            printlnMessage(FIELD_FIRSTNAME, COLONS, SPACE, record.getFirstName());
            printlnMessage(FIELD_LASTNAME, COLONS, SPACE, record.getLastName());
            printlnMessage(FIELD_MIDDLENAME, COLONS, SPACE, record.getMiddleName());
            printlnMessage(FIELD_FULLNAME, COLONS, SPACE, record.getFullName());
            printlnMessage(FIELD_NICKNAME, COLONS, SPACE, record.getNickName());
            printlnMessage(FIELD_COMMENT, COLONS, SPACE, record.getComment());
            printlnMessage(FIELD_GROUP, COLONS, SPACE, record.getGroup().toString());
            printlnMessage(FIELD_PHONE_HOME, COLONS, SPACE, record.getHomePhone());
            printlnMessage(FIELD_PHONE_CELL, COLONS, SPACE, record.getCellPhone());
            printlnMessage(FIELD_PHONE_CELL2, COLONS, SPACE, record.getCellPhone2());
            printlnMessage(FIELD_EMAIL, COLONS, SPACE, record.getEmail());
            printlnMessage(FIELD_SKYPE, COLONS, SPACE, record.getSkype());

            printlnMessage(FIELD_ADDRESS_FULL, COLONS, SPACE, record.getFullAddress());

            printlnMessage(FIELD_DATE_RECORD_CREATED,
                    COLONS,
                    SPACE,
                    String.valueOf(record.getDateRecordCreated()
                            .format(DateTimeFormatter.ofPattern(getFromBundle(FORMAT_DATE_OUTPUT)))));

            printlnMessage(FIELD_DATE_RECORD_UPDATED,
                    COLONS,
                    SPACE,
                    String.valueOf(record.getDateRecordUpdated()
                            .format(DateTimeFormatter.ofPattern(getFromBundle(FORMAT_DATE_OUTPUT)))));
        }
    }
}