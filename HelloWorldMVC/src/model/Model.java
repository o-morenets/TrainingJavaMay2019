package model;

public class Model {

    /** First string */
    private String firstString;

    /** Second string */
    private String secondString;

    /**
     * Returns two strings concatenated
     *
     * @return two strings concatenated
     */
    public String getFullString() {
        return firstString + ", " + secondString + "!";
    }

    // Getters & Setters

    public void setFirstString(String stringValue) {
        this.firstString = stringValue;
    }

    public void setSecondString(String stringValue) {
        this.secondString = stringValue;
    }
}
