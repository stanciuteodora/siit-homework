package siit.homework01;
public class PrimeNumbersArray {
    private int number;
    public PrimeNumbersArray(int theNumber) {
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
    public MyArray getPrimeNumbers() {
        MyArray foundPrimes = new MyArray();
        for (int i = 2; i < number; i++) {
            if (verifyPrimeNumber(i)) {
                foundPrimes.add(i);
            }
        }
        return foundPrimes;
    }
}

