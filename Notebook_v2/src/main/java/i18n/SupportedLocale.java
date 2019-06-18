package i18n;

import java.util.Locale;

/**
 * SupportedLocale
 *
 * Created by oleksii.morenets@gmail.com on 04.06.2019
 */
public enum SupportedLocale {

    EN (new Locale("en", "EN")),
    DE (new Locale("de", "DE")),
    RU (new Locale("ru", "RU")),
    UA (new Locale("uk", "UA"));

    private final Locale locale;

    SupportedLocale(Locale locale) {
        this.locale = locale;
    }

    // Getters & Setters

    public Locale getLocale() {
        return locale;
    }
}