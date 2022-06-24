package siit.homework01;

public class SmallestNumber {
    private int[] numbers;

    public SmallestNumber(int[] theNumbers) {
        numbers = theNumbers;
    }
    public int genMinimum(){
        int i;
        i = 0;
        int min;
        min = numbers[i];
        while (i < numbers.length-1) {
            if (min > numbers[i+1]) {
                min = numbers[i+1];
            }
            i++;
        }
        return min;
    }
}
