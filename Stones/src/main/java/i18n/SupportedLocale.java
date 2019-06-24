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

    /** Stores locale for enum item */
    private final Locale locale;

    /**
     * Constructs enum item with specified locale
     * @param locale locale
     */
    SupportedLocale(Locale locale) {
        this.locale = locale;
    }

    /**
     * Returns default locale
     * @return default locale
     */
    public static SupportedLocale getDefault() {
        return SupportedLocale.UA;
    }

    // Getters & Setters

    public Locale getLocale() {
        return locale;
    }
}