package siit.homework08.persons;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class StudentCreationTest {

    @Test
    public void happyCaseStudentCreationTest() {
        Student student = new Student("Diana", "Taurasi", 1982, 6, 11, "F", "White Mamba");
        Assertions.assertEquals(student.getFirstName(), "Diana");
        Assertions.assertEquals(student.getLastName(), "Taurasi");
        Assertions.assertEquals(student.getDateOfBirth().toString(), "1982-06-11");
        Assertions.assertEquals(student.getDateOfBirth(), LocalDate.parse("1982-06-11"));
        Assertions.assertEquals(student.getGender(), "F");
        Assertions.assertEquals(student.getId(), "White Mamba");
    }


    @Test
    public void happyCaseStudentCreationGenderLowerCaseTest() {
        Student student = new Student("Diana", "Taurasi", 1982, 6, 11, "f", "White Mamba");
        Assertions.assertEquals(student.getGender(), "f");
    }

    @Test
    public void nullFirstNameTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Student(null, "Taurasi", 1982, 6, 11, "F", "White Mamba"));
    }

    @Test
    public void nullLastNameTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Student("Diana", null, 1982, 6, 11, "F", "White Mamba"));
    }

    @Test
    public void nullYearOfBirthTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Student("Diana", "Taurasi", null, 6, 11, "F", "White Mamba"));
    }

    @Test
    public void yearOfBirthSmallerThan1900Test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Student("Diana", "Taurasi", 1800, 6, 11, "F", "White Mamba"));
    }

    @Test
    public void yearOfBirthTooCloseToPresentTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Student("Diana", "Taurasi", 2021, 6, 11, "F", "White Mamba"));
    }

    @Test
    public void nullMonthOfBirthTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Student("Diana", "Taurasi", 1982, null, 11, "F", "White Mamba"));
    }

    @Test
    public void nullDayOfBirthTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Student("Diana", "Taurasi", 1982, 6, null, "F", "White Mamba"));
    }

    @Test
    public void nullGenderTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Student("Diana", "Taurasi", 1982, 6, 11, null, "White Mamba"));
    }

    @Test
    public void wrongLetterGenderTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Student("Diana", "Taurasi", 1982, 6, 11, "i", "White Mamba"));
    }

    @Test
    public void nullIdTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Student("Diana", "Taurasi", 1982, 6, 11, "F", null));
    }

}
