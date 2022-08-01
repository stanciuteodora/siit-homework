package siit.homework07.persons.comparators;

import siit.homework07.persons.Person;

import java.util.Comparator;

/**
 * Compares 2 {@link Person} by age.
 */
public class AgeComparator implements Comparator<Person> {
    /**
     * Younger people are considered smaller in the comparison.
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return -1 if younger, 0 if same age, 1 otherwise
     */
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getAge() < o2.getAge()) {
            return -1;
        } else if (o1.getAge().equals(o2.getAge())) {
            return 0;
        } else {
            return 1;
        }
// if we accept person with null age
//        int o1Age;
//        if (o1.getAge() == null || o1.getAge() < 0) {
//            o1Age = 0;
//        } else {
//            o1Age = o1.getAge();
//        }
//        int o2Age;
//        if (o2.getAge() == null || o2.getAge() < 0) {
//            o2Age = 0;
//        } else {
//            o2Age = o2.getAge();
//        }
    }
}
