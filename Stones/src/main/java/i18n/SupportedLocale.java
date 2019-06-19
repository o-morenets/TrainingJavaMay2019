package i18n;

import java.util.Locale;

/**
 * SupportedLocale
 *
 * Created by oleksii.morenets@gmail.com on 18.06.2019
 */
public enum SupportedLocale {

    EN (new Locale("en")),
    UA (new Locale("uk"));

    private final Locale locale;

    SupportedLocale(Locale locale) {
        this.locale = locale;
    }

    // Getters & Setters

    public Locale getLocale() {
        return locale;
    }
}