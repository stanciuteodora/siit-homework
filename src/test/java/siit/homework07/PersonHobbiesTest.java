package siit.homework07;

import siit.homework07.addresses.Address;
import siit.homework07.addresses.Country;
import siit.homework07.hobbies.Hobby;
import siit.homework07.persons.Employee;
import siit.homework07.persons.Person;
import siit.homework07.persons.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class PersonHobbiesTest {
    @Test
    public void testSingleElement() {
        Map<Person, List<Hobby>> personHobbies = new HashMap<>();
        Person person1 = new Employee("Costel", 30);
        List<Hobby> person1Hobbies = generate2Hobbies();

        personHobbies.put(person1, person1Hobbies);

        List<Hobby> actual = personHobbies.get(person1);
        List<Hobby> expected = person1Hobbies;
        Assertions.assertEquals(personHobbies.size(), 1);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testMultipleElements() {
        Map<Person, List<Hobby>> personHobbies = new HashMap<>();
        Person person1 = new Employee("Costel", 30);
        List<Hobby> person1Hobbies = generate2Hobbies();
        Person person2 = new Student("Ioana", 20);
        List<Hobby> person2Hobbies = generate1Hobby();

        personHobbies.put(person1, person1Hobbies);
        personHobbies.put(person2, person2Hobbies);

        Assertions.assertEquals(personHobbies.size(), 2);
        Assertions.assertEquals(personHobbies.get(person1), person1Hobbies);
        Assertions.assertEquals(personHobbies.get(person2), person2Hobbies);
    }

    @Test
    public void testDuplicate() {
        Map<Person, List<Hobby>> personHobbies = new HashMap<>();
        Person person1 = new Employee("Costel", 30);
        List<Hobby> person1Hobbies = generate2Hobbies();
        Person person2 = new Student("Ioana", 20);
        List<Hobby> person2Hobbies = generate1Hobby();
        Person person3 = new Student("Ioana", 20);
        List<Hobby> person3Hobbies = generate2Hobbies();

        personHobbies.put(person1, person1Hobbies);
        personHobbies.put(person2, person2Hobbies);
        personHobbies.put(person3, person3Hobbies);

        Assertions.assertEquals(personHobbies.size(), 2);
        Assertions.assertEquals(personHobbies.get(person1), person1Hobbies);
        Assertions.assertNotEquals(personHobbies.get(person2), person2Hobbies);
        Assertions.assertEquals(personHobbies.get(person2), person3Hobbies);

    }

    private List<Hobby> generate2Hobbies() {
        List<Hobby> personHobbies = new LinkedList<>();
        personHobbies.add(new Hobby("skiing", 10, getSkiingAddresses()));
        personHobbies.add(new Hobby("hiking", 5, getHikingAddresses()));
        return personHobbies;
    }

    private List<Hobby> generate1Hobby() {
        List<Hobby> personHobbies = new LinkedList<>();
        personHobbies.add(new Hobby("skiing", 10, getSkiingAddresses()));
        return personHobbies;
    }

    private List<Address> getHikingAddresses() {
        Country austria = new Country("Austria", "AT");
        List<Address> hikingAddresses = new ArrayList<>();
        hikingAddresses.add(new Address(austria));
        return hikingAddresses;
    }

    private List<Address> getSkiingAddresses() {
        Country romania = new Country("Romania", "RO");
        Country austria = new Country("Austria", "AT");
        List<Address> skiingAddresses = new ArrayList<>();
        skiingAddresses.add(new Address(romania));
        skiingAddresses.add(new Address(austria));
        return skiingAddresses;
    }
}

