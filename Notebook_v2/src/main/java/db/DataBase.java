package db;

import java.util.stream.Stream;

/**
 * Represents in-memory database of notebook records
 */
public enum DataBase {

    RECORD_ONE("qwe"),
    RECORD_TWO("Nick"),
    RECORD_THREE("i386");

    private String login;

    DataBase(String login) {
        this.login = login;
    }

    /**
     * Check whether login is unique to the database
     *
     * @param login login to be verified
     * @return true if login is unique, false otherwise
     */
    public static boolean isLoginUnique(String login) {
        return Stream.of(values()).noneMatch(e -> e.getLogin().equals(login));
    }

    // Getters & Setters

    public String getLogin() {
        return login;
    }
}
