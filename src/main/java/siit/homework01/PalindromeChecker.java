package siit.homework01;

public class PalindromeChecker {
    private int number;

    public PalindromeChecker(int myNumber) {
        number = myNumber;
    }

    public boolean verifyPalindrome () {
        String numberAsString= Integer.toString(number);
        int i = 0;
        while (i<numberAsString.length()) {
            if (numberAsString.charAt(i)!= numberAsString.charAt(numberAsString.length()-(i+1))) {
                return false;
            }
            i++;
        }

        return true;
    }
}

