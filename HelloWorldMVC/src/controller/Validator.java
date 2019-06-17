package controller;

class Validator {

    /**
     * Check whether testString matches the pattern
     *
     * @param testString string for testing
     * @param pattern    pattern for testing
     * @return true if testString matches the pattern, false otherwise
     */
    static boolean isEqual(String testString, String pattern) {
        return testString.equals(pattern);
    }

}
