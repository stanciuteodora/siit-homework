package siit.homework08.persons.comparators;

import siit.homework08.persons.Student;

import java.util.Comparator;

/**
 * Compares 2 {@link Student} by last name ( in lexicographical order - example: Bryant < Taurasi).
 */
public class LastNameComparator implements Comparator<Student> {
    /**
     * Compares by last name ( in lexicographical order - example: Bryant < Taurasi)
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return the string comparison between the students' names
     */
    @Override
    public int compare(Student o1, Student o2) {
        String o1LastName = o1.getLastName();
        String o2LastName = o2.getLastName();
        return o1LastName.compareTo(o2LastName);
    }
}