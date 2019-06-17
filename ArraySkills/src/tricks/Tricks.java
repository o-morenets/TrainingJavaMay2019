package tricks;

public class Tricks {

    public static void main(String[] args) {
        System.out.println(oddOrNot(-43)); // false, but -43 is odd
        System.out.println(oddOrNotFixed(-43)); // true
    }

    /* Not correct! */
    public static boolean oddOrNot(int num) {
        return num % 2 == 1;
    }

    /* Correct */
    public static boolean oddOrNotFixed(int num) {
        System.out.println(num & 1);
		return (num & 1) != 0;
    }

}
