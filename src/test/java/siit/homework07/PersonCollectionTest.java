package siit.homework07;

import siit.homework07.persons.Employee;
import siit.homework07.persons.Person;
import siit.homework07.persons.Student;
import siit.homework07.persons.Unemployed;
import siit.homework07.persons.comparators.AgeComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PersonCollectionTest {
    @Test
    public void treeSetAgeComparatorAscending() {
        Person person1 = new Employee("Georgel", 46);
        Person person2 = new Student("Alexandra", 30);
        Person person3 = new Unemployed("Ion", 12);
        Person person4 = new Employee("Sonia", 56);

        List<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);

        Set<Person> personsByAge = new TreeSet<>(new AgeComparator());
        personsByAge.addAll(persons);

        Person[] expectedSet = new Person[]{person3, person2, person1, person4};

        int k = 0;
        for (Person actual : personsByAge) {
            Person expected = expectedSet[k];
            k++;
            Assertions.assertEquals(actual, expected);
        }
    }


    @Test
    public void treeSetAgeComparatorDuplicate() {
        Person person1 = new Employee("Georgel", 47);
        Person person2 = new Student("Alexandra", 46);
        Person person3 = new Unemployed("Ion", 46);
        Person person4 = new Employee("Sonia", 56);

        List<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);

        Set<Person> personsByAge = new TreeSet<>(new AgeComparator());
        personsByAge.addAll(persons);

        Person[] expectedSet = new Person[]{person2, person1, person4};

        int k = 0;
        for (Person actual : personsByAge) {
            Person expected = expectedSet[k];
            k++;
            Assertions.assertEquals(actual, expected);
        }
    }

    @Test
    public void treeSetAgeComparatorEmptySet() {
        Set<Person> personsByAge = new TreeSet<>(new AgeComparator());
        Assertions.assertEquals(personsByAge.size(), 0);
    }


}
