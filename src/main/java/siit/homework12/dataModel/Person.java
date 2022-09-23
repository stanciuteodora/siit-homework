package siit.homework12.dataModel;

import java.time.LocalDate;

/**
 * This is a person.
 */
public class Person {
    public String firstName;
    public String lastName;
    public LocalDate dateOfBirth;

    /**
     * Creates a person.
     *
     * @param firstName   the first name of the person
     * @param lastName    the last name of the person
     * @param dateOfBirth the date of birth
     */

    public Person(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
