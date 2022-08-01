package siit.homework07.persons;

/**
 * This is a person.
 */
public abstract class Person {
    private String name;
    private Integer age;

    /**
     * Creates a person.
     *
     * @param name the name of the person
     * @param age  the age of the person
     * @throws IllegalArgumentException if any of the parameters is null
     */

    public Person(String name, Integer age) {
        if (name == null) {
            throw new IllegalArgumentException("everybody needs to have a name");
        }
        this.name = name;

        if (age == null || age < 0) {
            throw new IllegalArgumentException("everybody needs to have an age");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    /**
     * Two persons are considered equal if they have the same name and age.
     *
     * @param o the reference object with which to compare
     * @return true if equals, false otherwise
     */
    public boolean equals(Object o) {
        if (!(o instanceof Person)) {
            return false;
        }
        Person p2 = (Person) o;
        return this.name.equals(p2.getName()) &&
                this.age.equals(p2.getAge());
    }

    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        return 32 * name.hashCode() + age;
    }


}
