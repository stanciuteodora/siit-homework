package siit.homework01;

public class Sum1ToN {
    // state
    private Integer number;


    // constructor
    public Sum1ToN(Integer theNumber) {

        number = theNumber;
    }

    // functions
    public int sum() {
        int sum;
        sum = number * (number + 1)/2;
        return sum;
    }

}
