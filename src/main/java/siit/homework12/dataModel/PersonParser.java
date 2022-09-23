package siit.homework12.dataModel;

import java.time.LocalDate;

/**
 * this is a person parser
 */
public class PersonParser {
    /**
     * Creates {@link Person} given a line
     * expected format:
     * PersonFirstName, PersonLastName,PersonYearOfBirth, PersonMonthOfBirth, PersonDayOfBirth
     * example
     * Kobe,Bryant,1978,6,25
     *
     * @param line the line to parse
     * @return the person
     */
    public Person parsePerson(String line) {
        String[] elements = line.split(",");
        return new Person(elements[0], elements[1], LocalDate.of(Integer.parseInt(elements[2]), Integer.parseInt(elements[3]), Integer.parseInt(elements[4])));
    }
}
