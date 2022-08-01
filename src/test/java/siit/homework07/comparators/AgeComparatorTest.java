package siit.homework07.comparators;

import siit.homework07.persons.Employee;
import siit.homework07.persons.Person;
import siit.homework07.persons.Student;
import siit.homework07.persons.comparators.AgeComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AgeComparatorTest {
    @Test
    public void testGreater() {
        AgeComparator comparator = new AgeComparator();
        Person p1 = new Employee("Ana", 30);
        Person p2 = new Student("Ion", 20);
        int expected = 1;
        int actual = comparator.compare(p1, p2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEqual() {
        AgeComparator comparator = new AgeComparator();
        Person p1 = new Employee("Ana", 35);
        Person p2 = new Student("Ion", 35);
        int expected = 0;
        int actual = comparator.compare(p1, p2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSmaller() {
        AgeComparator comparator = new AgeComparator();
        Person p1 = new Employee("Ana", 30);
        Person p2 = new Student("Ion", 50);
        int expected = -1;
        int actual = comparator.compare(p1, p2);
        Assertions.assertEquals(expected, actual);
    }


}
