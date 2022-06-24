package siit.homework01;
public class PrimeNumbers {
    private int number;
    public PrimeNumbers(int theNumber) {
        number = theNumber;
    }
    private boolean verifyPrimeNumber(int numberToTest) {
        int i = 2;
        while (i < numberToTest) {
            if (numberToTest % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }
    public void displayPrimeNumbers() {
        int i = 2;
        while (i < number) {
            if (verifyPrimeNumber(i)) {
                System.out.println(i);
            }
            i++;
        }
    }
}

