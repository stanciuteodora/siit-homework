package siit.homework08.persons.comparators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import siit.homework08.persons.Student;

class BirthDateComparatorTest {

    @Test
    public void testLower() {
        BirthDateComparator comparator = new BirthDateComparator();
        Student student1 = new Student("Diana", "Taurasi", 1982, 6, 11, "F", "White Mamba");
        Student student = new Student("Kobe", "Bryant", 1978, 7, 25, "M", "Black Mamba");
        int actual = comparator.compare(student, student1);
        Assertions.assertTrue(actual < 0);
    }

    @Test
    public void testGreater() {
        BirthDateComparator comparator = new BirthDateComparator();
        Student student1 = new Student("Diana", "Taurasi", 1982, 6, 11, "F", "White Mamba");
        Student student = new Student("Kobe", "Bryant", 1978, 7, 25, "M", "Black Mamba");
        int actual = comparator.compare(student1, student);
        Assertions.assertTrue(actual > 0);
    }

    @Test
    public void testEqual() {
        BirthDateComparator comparator = new BirthDateComparator();
        Student student = new Student("Diana", "Taurasi", 1982, 6, 11, "F", "White Mamba");
        Student student1 = new Student("Kobe", "Bryant", 1982, 6, 11, "M", "Black Mamba");
        int expected = 0;
        int actual = comparator.compare(student, student1);
        Assertions.assertEquals(expected, actual);
    }

}