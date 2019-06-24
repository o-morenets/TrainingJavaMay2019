package view;

import i18n.SupportedLocale;
import model.Riviere;
import model.entity.IGemstone;

import java.util.*;

import static view.TextConstants.*;

/**
 * Represents View object for MVC pattern
 *
 * @author Oleksii Morenets
 */
public class View {

    /** Bundle filename */
    private static final String BUNDLE_FILENAME = "textMessages";

    /** ResourceBundle */
    private ResourceBundle bundle;

    /**
     * Constructs View object with bundle based on default locale (from supported locales list)
     */
    public View() {
        SupportedLocale currentLocale = SupportedLocale.getDefault();
        changeResourceBundleForLocale(currentLocale.getLocale());
    }

    /**
     * Initializes ResourceBundle for specified locale
     * @param locale locale
     */
    public void changeResourceBundleForLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(BUNDLE_FILENAME, locale);
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
     * Print whole riviere
     *
     * @param model riviere model
     */
    public void printRiviere(Riviere model) {
        printList(model.getStones());
        printlnMessage(RIVIERE_TOTAL_CARAT_WEIGHT, COLONS, SPACE, String.valueOf(model.totalCaratWeight()));
        printlnMessage(RIVIERE_TOTAL_COST, COLONS, SPACE, String.valueOf(model.totalCost()));
    }

    /**
     * Print list of gemstones
     *
     * @param list gemstones list
     */
    public void printList(List<IGemstone> list) {
        printlnMessage();

        if (list.isEmpty()) {
            printlnMessage(WARNING_LIST_IS_EMPTY);
        } else {
            for (IGemstone stone : list) {
                printlnMessage(stone.toString(), SPACE, LEFT_BRACKET,
                        STONE_CARAT_WEIGHT, COLONS, SPACE, String.valueOf(stone.getCaratWeight()), SPACE,
                        STONE_COST, COLONS, SPACE, String.valueOf(stone.getCost()), SPACE,
                        STONE_TRANSPARENCY, COLONS, SPACE, String.valueOf(stone.getTransparency()), RIGHT_BRACKET);
            }
        }
    }

    /**
     * Prints menu based on enum
     *
     * @param menu enum menu items
     */
    public void printMenu(Enum[] menu) {
        printlnMessage();

        for (Enum menuItem : menu) {
            printlnMessage(String.valueOf(menuItem.ordinal()), DOT, SPACE, menuItem.toString());
        }
    }
}
