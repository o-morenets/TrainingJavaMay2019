package regex;

import i18n.SupportedLocale;
import org.junit.Assert;
import org.junit.Test;
import view.View;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static controller.RegularExpressions.*;

public class TestRegex {

    private String[][] dateCorrect = {
            {"1900/1/1", "2070/12/31"},
            {"1/1/1900", "01/01/2019", "31/12/2070"},
            {"1.1.1900", "01.01.1954", "31.12.2015"},
            {"1-1-1900", "01-01-1900", "31-12-2004"}
    };

    private String[][] dateIncorrect = {
            {"19/1/1", "2019-15-14", "2019/13/01"},
            {"32/01/1900", "1/13/1025", "01-01-2015"},
            {"32.01.2015", "01.13.2014", "1 травня 2014"},
            {"32-01-2014", "01-13-2541", "01-мая-1974"}
    };

    private String[][] yesCorrect = {
            {"Y", "y"},
            {"J", "j"},
            {"Т", "т"},
            {"Д", "д"}
    };

    private String[][] yesIncorrect = {
            {"Yes", "yes", "Yeah!"},
            {"Ja", "ja", "Natürlich!"},
            {"Так", "так", "Авжеж!"},
            {"Да", "да", "Конечно!"}
    };

    private String[][] yesNoCorrect = {
            {"Y", "y", "N", "n"},
            {"J", "j", "N", "n"},
            {"Т", "т", "Н", "н"},
            {"Д", "д", "Н", "н"}
    };

    private String[][] yesNoIncorrect = {
            {"Yes", "yes", "Yeah!", "No", "no", "Oh, Nooo!"},
            {"Ja", "ja", "Natürlich!", "Nein", "nicht", "Kein!"},
            {"Так", "так", "Авжеж!", "Ні", "нє", "Авжеж ні!"},
            {"Да", "да", "Конечно!", "Нет", "нет", "Конечно нет!"}
    };

    private String[][] groupCorrect = {
            {"FRIENDS", "FAMILY", "COWORKERS"},
            {"FRIENDS", "FAMILY", "COWORKERS"},
            {"FRIENDS", "FAMILY", "COWORKERS"},
            {"FRIENDS", "FAMILY", "COWORKERS"}
    };

    private String[][] groupIncorrect = {
            {"friends", "family", "coworkers"},
            {"friends", "family", "coworkers"},
            {"friends", "family", "coworkers"},
            {"friends", "family", "coworkers"}
    };

    private String[][] numberCorrect = {
            {"0", "1", "01"},
            {"99", "08", "70"},
            {"33", "44", "55"},
            {"2", "4", "9"}
    };

    private String[][] numberIncorrect = {
            {"", "000", "123"},
            {"100", "ONE", "two"},
            {"million", "Google", "543"},
            {"-0.98", "-1", "999"}
    };

    private String[][] nameCorrect = {
            {"John", "Li", "Anna", "Twentyoneletternameee"},
            {"Albert", "Christophorus", "Bärbel", "Hansjörg", "Hansjürgen"},
            {"Ян", "Ілля", "Євгеній", "Ґреґ", "Гаїна", "Ізяслав", "В'ячеслав"},
            {"Ьзнак", "Ъзнак", "Ыгорь", "Даздраперма", "Ли"}
    };

    private String[][] nameIncorrect = {
            {"J", "john", "Twentytwoletternameeee", "Hansjürgen"},
            {"Ädolf", "Ömen", "Üwe", "Zweiundzwanzigbuchstab"},
            {"ізя", "євгеній", "ґрег", "Я", "Ім'ядвадцятидвозначнеє"},
            {"ьзнак", "ъзнак", "ыгорь", "Двадцатиоднозначноеимя", ""}
    };

    private String[][] nickNameCorrect = {
            {"John", "Lee", "Anna", "TenLetters"},
            {"Albert", "Ädolf", "Bärbel", "Hansjörg", "Hansjürgen"},
            {"Яна", "Ілля", "Євгеній", "Ґреґ", "Гаїна", "Ізяслав", "В'ячеслав"},
            {"Ьзнак", "Ъзнак", "Ыгорь", "Олимпиада8", "Лиза"}
    };

    private String[][] nickNameIncorrect = {
            {"J", "jo", "Twentytwoletternameeee", "Hans#jürgen"},
            {"Christophorus", "Ömen%", "Ü", "Zweiundzwanzigbuchstab"},
            {"Ко", "!євгеній", "ґрег?", "Я", "Ім'ядвадцятидвозначнеє"},
            {"ьзнак+", "*ъзнак*", "ыгорь:", "Двадцатиоднозначноеимя", "Даздраперма"}
    };

    private String[][] emailCorrect = {
            {"asd@zxc.com", "qwe.asd@zxc.ua", "1+1@telecom.tv"},
            {},
            {},
            {}
    };

    private String[][] emailIncorrect = {
            {"a$sd@zxc.com", "qwe.as8*d@zxc.ua", "1+1.tv"},
            {},
            {},
            {}
    };

    private String[][] phoneCellCorrect = {
            {"(000) 000-00-00", "(123) 456-78-90", "(987) 321-00-12"},
            {},
            {},
            {}
    };

    private String[][] phoneCellIncorrect = {
            {"0000000000", "000 000-00-00", "(123)456-789-12"},
            {},
            {},
            {}
    };

    private String[][] phoneCell2Correct = {
            {"(000) 000-00-00", "(123) 456-78-90", "(987) 321-00-12"},
            {},
            {},
            {}
    };

    private String[][] phoneCell2Incorrect = {
            {"0000000000", "000 000-00-00", "(123)456-789-12"},
            {},
            {},
            {}
    };

    private String[][] phoneHomeCorrect = {
            {"000-00-00", "456-78-90", "321-00-12"},
            {},
            {},
            {}
    };

    private String[][] phoneHomeIncorrect = {
            {"0000000000", "000 000-00-00", "45678912"},
            {},
            {},
            {}
    };

    private String[][] skypeCorrect = {
            {"Vyacheslav.Pidgorodetskii_198-75", "skype_", "A-5426"}, {}, {}, {}
    };

    private String[][] skypeIncorrect = {
            {"Vyacheslav.Pidgorodetskii_198-752", "скайп_", "-542-A"}, {}, {}, {}
    };

    private String[][] commentCorrect = {
            {"", createComment(1), createComment(255)}, {}, {}, {}
    };

    private String[][] commentIncorrect = {
            {createComment(256)}, {}, {}, {}
    };

    private String createComment(int length) {
        return new Random().ints()
                .limit(length)
                .mapToObj(x -> String.valueOf((char) x))
                .collect(Collectors.joining());
    }

    @Test
    public void allRegexTest() {
        testRegex(REGEX_ANSWER_YES, yesCorrect, yesIncorrect);
        testRegex(REGEX_COMMENT, commentCorrect, commentIncorrect);
        testRegex(REGEX_DATE, dateCorrect, dateIncorrect);
        testRegex(REGEX_EMAIL, emailCorrect, emailIncorrect);
        testRegex(REGEX_GROUP, groupCorrect, groupIncorrect);
        testRegex(REGEX_NAME, nameCorrect, nameIncorrect);
        testRegex(REGEX_NICK_NAME, nickNameCorrect, nickNameIncorrect);
        testRegex(REGEX_NUMBER, numberCorrect, numberIncorrect);
        testRegex(REGEX_CELL_PHONE, phoneCellCorrect, phoneCellIncorrect);
        testRegex(REGEX_CELL_PHONE_2, phoneCell2Correct, phoneCell2Incorrect);
        testRegex(REGEX_HOME_PHONE, phoneHomeCorrect, phoneHomeIncorrect);
        testRegex(REGEX_SKYPE, skypeCorrect, skypeIncorrect);
        testRegex(REGEX_YES_NO, yesNoCorrect, yesNoIncorrect);
    }

    private void testRegex(String regexName, String[][] correctStrings, String[][] incorrectStrings) {
        SupportedLocale[] values = SupportedLocale.values();
        for (int i = 0; i < values.length; i++) {
            Locale locale = values[i].getLocale();
            ResourceBundle bundle = ResourceBundle.getBundle(View.BUNDLE_FILE, locale);
            String regex = bundle.getString(regexName);
            for (int j = 0; j < correctStrings[i].length; j++) {
                Assert.assertTrue(locale + ": " + regex + " " +
                        correctStrings[i][j], correctStrings[i][j].matches(regex));
            }
            for (int j = 0; j < incorrectStrings[i].length; j++) {
                Assert.assertFalse(locale + ": " + regex + " " +
                        incorrectStrings[i][j], incorrectStrings[i][j].matches(regex));
            }
        }
    }
}
