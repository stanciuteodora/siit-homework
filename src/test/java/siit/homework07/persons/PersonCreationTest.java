package siit.homework07.persons;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonCreationTest {
    @Test
    public void testHappyPerson() {
        Person p = new Employee("Teo", 20);
        Assertions.assertEquals(p.getName(), "Teo");
        Assertions.assertEquals(p.getAge(), 20);
    }

    @Test
    public void testWithNullName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Employee(null, 2));
    }

    @Test
    public void testWithNullAge() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Employee("Teo", null));
    }

    @Test
    public void testWithNegativeAge() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Employee("Teo", -1));
    }
}
