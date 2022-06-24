package siit.homework01;

public class MaxDigit {
    private int number;

    public MaxDigit(int theNumber) {
        number = theNumber;
    }
    public int maxDigit(){
        int maxDigit;
        maxDigit = number % 10;
        while (number > 0) {
            number = number/10;
            int currentDigit;
            currentDigit = number % 10;
            if (maxDigit < currentDigit) {
                maxDigit = currentDigit;
            }
        }
        return maxDigit;
    }
}
