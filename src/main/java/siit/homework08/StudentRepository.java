package siit.homework08;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import siit.homework08.persons.Student;
import siit.homework08.persons.StudentDuplicateException;
import siit.homework08.persons.comparators.BirthDateComparator;
import siit.homework08.persons.comparators.LastNameComparator;

import java.util.*;

/**
 * This is a student repository that adds, deletes, lists and sorts students.
 */
public class StudentRepository {
    private static final Logger log = LogManager.getLogger(StudentRepository.class);
    private List<Student> students;
    private Map<String, Comparator<Student>> comparators;

    public StudentRepository() {
        students = new ArrayList<>();
        comparators = new HashMap<>();
        comparators.put("LastName", new LastNameComparator());
        comparators.put("BirthDate", new BirthDateComparator());
    }

    /**
     * Adds a student in the student repository. Doesn't allow duplicates to be stored. A student is considerate a
     * duplicate if the id is identical with an id already added.
     *
     * @param studentToAdd the student which will be added
     * @throws IllegalArgumentException  if the parameter is null
     * @throws StudentDuplicateException if the student already exists
     */
    public void addStudent(Student studentToAdd) {
//        for (Student studentToIterate : students) {
//            if (studentToIterate.getId().equals(studentToAdd.getId())) {
//                throw new StudentDuplicateException("Student already exists in the repository");
//            }
//        }
        if (studentToAdd == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        Student studentInList = getById(studentToAdd.getId());
        if (studentInList != null) {
            log.log(Level.DEBUG, "Found duplicate: " + studentInList.getId());
            throw new StudentDuplicateException("Student already exists in the repository");
        }
        log.log(Level.INFO, "Adding student: " + studentToAdd);
        students.add(studentToAdd);
    }

    /**
     * Finds a student given its id.
     *
     * @param id the id of the student
     * @return the student if found, else null.
     */
    public Student getById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    /**
     * Displays the list of students in the student repository.
     *
     * @return all the students in the student repository
     */
    public List<Student> getAll() {
        return students;
    }

    /**
     * Displays the list of students in the student repository ordered by the last name or the date of birth.
     *
     * @param orderBy the comparator
     * @return a list ordered by last name or date of birth
     * @throws IllegalArgumentException if the orderBy parameter is null
     * @throws IllegalArgumentException if the orderBy parameter is not LastName or BirthDate
     */
    public List<Student> getAll(String orderBy) {
        if (orderBy == null) {
            throw new IllegalArgumentException("Order criteria cannot be null");
        }
//        if (!orderBy.equals("LastName") && !orderBy.equals("BirthDate")) {
//            throw new IllegalArgumentException("Order criteria must be 'LastName' or 'BirthDate'");
//        }
//        Comparator<Student> comparator = null;
//        if (orderBy.equals("LastName")) {
//            comparator = new LastNameComparator();
//        }
//        if (orderBy.equals("BirthDate")) {
//            comparator = new BirthDateComparator();
//        }
        Comparator<Student> studentComparator = comparators.get(orderBy);
        if (!comparators.containsKey(orderBy)) {
            throw new IllegalArgumentException("Order criteria is not part of: " + comparators.keySet());
        }
        List<Student> studentsToSort = new ArrayList<>(getAll());
        studentsToSort.sort(studentComparator);
        return studentsToSort;
    }

    /**
     * Deletes a student (given its id) from the student repository.
     *
     * @param id the id of the student
     * @throws IllegalArgumentException if the id is empty
     */
    public void deleteStudent(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Enter the id");
        }
        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getId().equals(id)) {
                studentToRemove = student;
                break;
            }
        }
        log.log(Level.INFO, "Deleting student: " + studentToRemove);
        students.remove(studentToRemove);
    }

    /**
     * Retrieves all the students that have the same age from the student repository.
     *
     * @param age the age of the students
     * @return the list of the students that have the same age
     * @throws IllegalArgumentException if the age is null or is negative
     */
    public List<Student> retrieveStudentsSameAge(Integer age) {
        if (age == null || age < 0) {
            throw new IllegalArgumentException("Age should be a positive number");
        }
        List<Student> studentsSameAge = new ArrayList<>();
        for (Student student : students) {
            if (student.getAge().equals(age)) {
                studentsSameAge.add(student);
            }
        }
        return studentsSameAge;
    }

    @Override
    public String toString() {
        return "Student repository is:" +
                "\n" + students;
    }

    public void addComparator(String key, Comparator<Student> comparator) {
        comparators.put(key, comparator);
    }
}
