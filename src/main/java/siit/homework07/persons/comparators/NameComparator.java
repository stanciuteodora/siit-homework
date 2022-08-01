package siit.homework07.persons.comparators;

import siit.homework07.persons.Person;

import java.util.Comparator;

/**
 * Compares 2 {@link Person} by name( in lexicographical order - example: Ionel < Vio).
 */
public class NameComparator implements Comparator<Person> {
    /**
     * Compares by name( in lexicographical order - example: Ionel < Vio).
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return the string comparison between the persons' names
     */
    @Override
    public int compare(Person o1, Person o2) {
        String o1Name = o1.getName();
        String o2Name = o2.getName();
        return o1Name.compareTo(o2Name);
// if we want to allow null values for name
//        if (o1.getName() == null) {
//            return Integer.MIN_VALUE;
//        }
//        if (o2.getName() == null) {
//            return Integer.MAX_VALUE;
//        }
    }
}
