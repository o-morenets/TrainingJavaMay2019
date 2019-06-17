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
    UA (new Locale("uk", "UA")),
    RU (new Locale("ru", "RU"));

    private final Locale locale;

    SupportedLocale(Locale locale) {
        this.locale = locale;
    }

    public Locale getLocale() {
        return locale;
    }
}