package siit.homework07.comparators;

import siit.homework07.persons.Employee;
import siit.homework07.persons.Person;
import siit.homework07.persons.Student;
import siit.homework07.persons.comparators.NameComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NameComparatorTest {

    @Test
    public void testDifferent() {
        NameComparator comparator = new NameComparator();
        Person p1 = new Employee("Ana", 30);
        Person p2 = new Student("Ion", 20);
        int actual = comparator.compare(p1, p2);
        Assertions.assertTrue(actual < 0);
    }

    @Test
    public void testEqual() {
        NameComparator comparator = new NameComparator();
        Person p1 = new Employee("Ion", 35);
        Person p2 = new Student("Ion", 35);
        int expected = 0;
        int actual = comparator.compare(p1, p2);
        Assertions.assertEquals(expected, actual);
    }

}
