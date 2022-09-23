package siit.homework12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import siit.homework10.dataAccess.RaceResultParser;
import siit.homework12.dataModel.Person;
import siit.homework12.dataModel.PersonParser;

public class PersonParserTest {
    @Test
    public void happyCase() {
        // data preparation
        String string = "Diana,Taurasi,1982,6,11";

        // test execution
        PersonParser parser = new PersonParser();
        Person person = parser.parsePerson(string);

        // assertions
        Assertions.assertEquals("Diana", person.getFirstName());
        Assertions.assertEquals("Taurasi", person.getLastName());
        Assertions.assertEquals(1982, person.getDateOfBirth().getYear());
        Assertions.assertEquals(6, person.getDateOfBirth().getMonthValue());
        Assertions.assertEquals(11, person.getDateOfBirth().getDayOfMonth());
    }

    @Test
    public void testNoFirstName() {
        // data preparation
        String string = ",Taurasi,1982,6,11";

        // test execution
        PersonParser parser = new PersonParser();
        Person person = parser.parsePerson(string);

        // assertions
        Assertions.assertEquals("", person.getFirstName());
        Assertions.assertEquals("Taurasi", person.getLastName());
        Assertions.assertEquals(1982, person.getDateOfBirth().getYear());
        Assertions.assertEquals(6, person.getDateOfBirth().getMonthValue());
        Assertions.assertEquals(11, person.getDateOfBirth().getDayOfMonth());
    }

    @Test
    public void testNoYear() {
        // data preparation
        String string = "Diana,Taurasi,,6,11";

        // test execution
        PersonParser parser = new PersonParser();

        // assertions
        Assertions.assertThrows(NumberFormatException.class, () -> parser.parsePerson(string));
    }
}
