package siit.homework01;
public class MyArray {
    private int[] numbers;
    private int size;
    public MyArray() {
        numbers = new int[1000];
        size = 0;
    }
    public void add(int number) {
        numbers[size] = number;
        size++;
    }
    public int[] getNumbers() {
        return numbers;
    }
    public int getNumber(int index) {
        return numbers[index];
    }
    public int getSize() {
        return size;
    }
    @Override
    public String toString() {
        String s = "MyArray{ numbers: [ ";
        for (int i = 0; i < size - 1; i++) {
            s = s + numbers[i] + ",";
        }
        s = s + numbers[size - 1];
        s = s + " ]}";
        return s;
    }
}
