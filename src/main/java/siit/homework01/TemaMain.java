package siit.homework01;

public class TemaMain {
    public static void main(String[] args) {
        // Exercise 1
        System.out.println("Exercise 1");
        Sum1ToN exercise11 = new Sum1ToN(100);
        int sum11 = exercise11.sum();
        System.out.println(sum11);
        // Exercise 2
        System.out.println("Exercise 2");
        int[] theNumbers;
        theNumbers = new int[]{1, 2, 3};
        SmallestNumber exercise21 = new SmallestNumber(theNumbers);
        int min = exercise21.genMinimum();
        System.out.println(min);

        int[] theNumbers1;
        theNumbers1 = new int[]{13, 5, -1};
        SmallestNumber exercise22 = new SmallestNumber(theNumbers1);
        int min1 = exercise22.genMinimum();
        System.out.println(min1);
        // Exercise 3
        System.out.println("Exercise 3");
        MaxDigit exercise31 = new MaxDigit(12345);
        int maxDigit = exercise31.maxDigit();
        System.out.println(maxDigit);
        // Exercise 4
        System.out.println("Exercise 4");
        PalindromeChecker exercise4 = new PalindromeChecker(34543);
        boolean verifiedPalindrome = exercise4.verifyPalindrome();
        System.out.println(verifiedPalindrome);
        PalindromeChecker exercise41 = new PalindromeChecker(32543);
        boolean verifiedPalindrome1 = exercise41.verifyPalindrome();
        System.out.println(verifiedPalindrome1);
        // Exercise5
        System.out.println("Exercise 5");
        PrimeNumbers exercise51 = new PrimeNumbers(29);
        exercise51.displayPrimeNumbers();
        // Exercise5.1
        System.out.println("Exercise 5 varianta array");
        PrimeNumbersArray exercise52 = new PrimeNumbersArray(15);
        MyArray array = exercise52.getPrimeNumbers();

//        for (int i = 0; i < array.getSize(); i++) {
//            // varianta 1
//            int[] numbers = array.getNumbers();
//            System.out.println(numbers[i]);
//            // varianta 2
//            System.out.println(array.getNumbers()[i]);
//            //varianta 3
//            System.out.println(array.getNumber(i));
//        }
//        varianta 4
        System.out.println(array);
    }
}

