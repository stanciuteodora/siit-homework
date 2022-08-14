package siit.homework08.persons.comparators;

import siit.homework08.persons.Student;

import java.time.LocalDate;
import java.util.Comparator;

/**
 * Compares 2 {@link Student} by date of birth.
 */
public class BirthDateComparator implements Comparator<Student> {
    /**
     * Compares by date of birth.
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return the comparator value, negative if less, positive if greater
     */
    @Override
    public int compare(Student o1, Student o2) {
        LocalDate o1BirthDay = o1.getDateOfBirth();
        LocalDate o2BirthDay = o2.getDateOfBirth();
        return o1BirthDay.compareTo(o2BirthDay);
    }
}
