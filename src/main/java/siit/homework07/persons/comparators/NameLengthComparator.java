package siit.homework07.persons.comparators;

import siit.homework07.persons.Person;

import java.util.Comparator;

/**
 * Compares 2 {@link Person} by name( in name length order - example: Ionel > Vio).
 */
public class NameLengthComparator implements Comparator<Person> {
    /**
     * Compares by name( in name length order - example: Ionel > Vio).
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return the string length comparison between the persons' names
     */
    @Override
    public int compare(Person o1, Person o2) {
        int o1Length = o1.getName().length();
        int o2Length = o2.getName().length();
        return o1Length - o2Length;
    }
}
