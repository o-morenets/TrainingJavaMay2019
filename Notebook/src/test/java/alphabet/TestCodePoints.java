package alphabet;

import org.junit.Test;

import java.util.stream.Stream;

public class TestCodePoints {

    @Test
    public void ukr() {
        String ukrUpperAlphabet = "ЙЦУКЕНГШЩЗХЇФІВАПРОЛДЖЄЯЧСМИТЬБЮҐ";
        String ukrLowerAlphabet = "йцукенгшщзхїфівапролджєячсмитьбюґ";
        Stream<Integer> intsUpper = ukrUpperAlphabet.chars().boxed();
        Stream<Integer> intsLower = ukrLowerAlphabet.chars().boxed();

        Stream.concat(intsUpper, intsLower).sorted().forEach(c -> System.out.println((char)c.intValue() + " - " + c));
    }

    @Test
    public void rus() {
        String rusUpperAlphabet = "ЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮЁ";
        String rusLowerAlphabet = "йцукенгшщзхъфывапролджэячсмитьбюё";
        Stream<Integer> intsUpper = rusUpperAlphabet.chars().boxed();
        Stream<Integer> intsLower = rusLowerAlphabet.chars().boxed();

        Stream.concat(intsUpper, intsLower).sorted().forEach(c -> System.out.println((char)c.intValue() + " - " + c));
    }
}
