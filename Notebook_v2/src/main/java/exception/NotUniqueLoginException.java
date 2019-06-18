package exception;

/**
 * Represents the case when login is not unique in the database
 */
public class NotUniqueLoginException extends Exception {

    private String login;

    public NotUniqueLoginException(String message, String login) {
        super(message + ": " + login);
        this.login = login;
    }

    // Getters & Setters

    public String getLogin() {
        return login;
    }
}
