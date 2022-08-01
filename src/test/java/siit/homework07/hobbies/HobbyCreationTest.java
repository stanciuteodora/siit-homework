package siit.homework07.hobbies;

import siit.homework07.addresses.Address;
import siit.homework07.addresses.Country;
import siit.homework07.hobbies.Hobby;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class HobbyCreationTest {
    @Test
    public void testHappyHobby(){
        Country romania = new Country("Romania", "RO");
        Country austria = new Country("Austria", "AT");

        List<Address> skiingAddresses = new ArrayList<>();
        skiingAddresses.add(new Address(romania));
        skiingAddresses.add(new Address(austria));

        Hobby skiing = new Hobby("skiing", 10, skiingAddresses);
        Assertions.assertEquals(skiing.getHobby(), "skiing");
        Assertions.assertEquals(skiing.getFrequency(), 10);
        Assertions.assertEquals(skiing.getLocation(),skiingAddresses );
    }
    @Test
    public void testWithNullHobby(){
        Country romania = new Country("Romania", "RO");
        Country austria = new Country("Austria", "AT");

        List<Address> skiingAddresses = new ArrayList<>();
        skiingAddresses.add(new Address(romania));
        skiingAddresses.add(new Address(austria));

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Hobby(null, 10,
                skiingAddresses));
    }
    @Test
    public void testWithNullFrequency(){
        Country romania = new Country("Romania", "RO");
        Country austria = new Country("Austria", "AT");

        List<Address> skiingAddresses = new ArrayList<>();
        skiingAddresses.add(new Address(romania));
        skiingAddresses.add(new Address(austria));

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Hobby("skiing", null,
                skiingAddresses));
    }@Test
    public void testWithNullLocation(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Hobby("skiing", 10,
                null));
    }
}
