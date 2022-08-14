package siit.homework08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import siit.homework08.persons.Student;
import siit.homework08.persons.StudentDuplicateException;

import java.util.ArrayList;
import java.util.List;

class StudentRepositoryTest {
    @Test
    public void addOneStudentTest() {
        Student student = new Student("Diana", "Taurasi", 1982, 6, 11, "F", "White Mamba");

        StudentRepository studentRepository = getStudentRepository(student);

        Assertions.assertEquals(studentRepository.getById(student.getId()), student);
        Assertions.assertEquals(studentRepository.getAll().size(), 1);
    }

    @Test
    public void addMultipleStudentTest() {
        Student student = new Student("Diana", "Taurasi", 1982, 6, 11, "F", "White Mamba");
        Student student1 = new Student("Kobe", "Bryant", 1978, 7, 25, "M", "Black Mamba");
        Student student2 = new Student("Dirk", "Nowitzki", 1978, 6, 18, "m", "Dirk Diggler");

        StudentRepository studentRepository = getStudentRepository(student, student1, student2);

        Assertions.assertEquals(studentRepository.getById(student.getId()), student);
        Assertions.assertEquals(studentRepository.getById(student1.getId()), student1);
        Assertions.assertEquals(studentRepository.getById(student2.getId()), student2);
        Assertions.assertEquals(studentRepository.getAll().size(), 3);
    }

    @Test
    public void addNullStudentTest() {
        Student student2 = null;
        StudentRepository studentRepository = new StudentRepository();
        Assertions.assertThrows(IllegalArgumentException.class, () -> studentRepository.addStudent(student2));
    }

    @Test
    public void addDuplicateStudent() {
        Student student = new Student("Diana", "Taurasi", 1982, 6, 11, "F", "White Mamba");
        // note: student 1 is a duplicate of student (check id field)
        Student student1 = new Student("Kobe", "Bryant", 1978, 7, 25, "M", "White Mamba");
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.addStudent(student);
        Assertions.assertThrows(StudentDuplicateException.class, () -> studentRepository.addStudent(student1));
    }

    @Test
    public void getALlTest() {
        Student student = new Student("Diana", "Taurasi", 1982, 6, 11, "F", "White Mamba");
        Student student1 = new Student("Kobe", "Bryant", 1978, 7, 25, "M", "Black Mamba");
        Student student2 = new Student("Dirk", "Nowitzki", 1978, 6, 18, "m", "Dirk Diggler");
        StudentRepository studentRepository = getStudentRepository(student, student1, student2);
        List<Student> expected = new ArrayList<>();
        expected.add(student);
        expected.add(student1);
        expected.add(student2);
        Assertions.assertEquals(studentRepository.getAll(), expected);
        Assertions.assertEquals(studentRepository.getAll().size(), 3);
    }

    @Test
    public void getAllByLastNameTest() {
        Student student = new Student("Diana", "Taurasi", 1982, 6, 11, "F", "White Mamba");
        Student student1 = new Student("Kobe", "Bryant", 1978, 7, 25, "M", "Black Mamba");
        Student student2 = new Student("Dirk", "Nowitzki", 1978, 6, 18, "m", "Dirk Diggler");
        StudentRepository studentRepository = getStudentRepository(student, student1, student2);
        List<Student> expectedUnordered = new ArrayList<>();
        expectedUnordered.add(student);
        expectedUnordered.add(student1);
        expectedUnordered.add(student2);
        List<Student> expectedOrdered = new ArrayList<>();
        expectedOrdered.add(student1);
        expectedOrdered.add(student2);
        expectedOrdered.add(student);
        Assertions.assertEquals(studentRepository.getAll("LastName"), expectedOrdered);
        Assertions.assertEquals(studentRepository.getAll(), expectedUnordered);
    }

    @Test
    public void getAllByBirthDateTest() {
        Student student = new Student("Diana", "Taurasi", 1982, 6, 11, "F", "White Mamba");
        Student student1 = new Student("Kobe", "Bryant", 1978, 7, 25, "M", "Black Mamba");
        Student student2 = new Student("Dirk", "Nowitzki", 1978, 6, 18, "m", "Dirk Diggler");

        StudentRepository studentRepository = getStudentRepository(student, student1, student2);
        List<Student> expectedUnordered = new ArrayList<>();
        expectedUnordered.add(student);
        expectedUnordered.add(student1);
        expectedUnordered.add(student2);
        List<Student> expectedOrdered = new ArrayList<>();
        expectedOrdered.add(student2);
        expectedOrdered.add(student1);
        expectedOrdered.add(student);
        Assertions.assertEquals(studentRepository.getAll("BirthDate"), expectedOrdered);
        Assertions.assertEquals(studentRepository.getAll(), expectedUnordered);
    }

    @Test
    public void getAllOrderByNullTest() {
        StudentRepository studentRepository = new StudentRepository();
        Assertions.assertThrows(IllegalArgumentException.class, () -> studentRepository.getAll(null));
    }

    @Test
    public void getAllOrderByRandomStringTest() {
        StudentRepository studentRepository = new StudentRepository();
        Assertions.assertThrows(IllegalArgumentException.class, () -> studentRepository.getAll("abc"));
    }

    @Test
    public void deleteStudentTest() {
        Student student = new Student("Diana", "Taurasi", 1982, 6, 11, "F", "White Mamba");
        Student student1 = new Student("Kobe", "Bryant", 1978, 7, 25, "M", "Black Mamba");
        Student student2 = new Student("Dirk", "Nowitzki", 1978, 6, 18, "m", "Dirk Diggler");
        StudentRepository studentRepository = getStudentRepository(student, student1, student2);
        studentRepository.deleteStudent(student.getId());
        Assertions.assertNull(studentRepository.getById(student.getId()));
    }

    @Test
    public void deleteStudentInExistentTest() {
        Student student = new Student("Diana", "Taurasi", 1982, 6, 11, "F", "White Mamba");
        Student student1 = new Student("Kobe", "Bryant", 1978, 7, 25, "M", "Black Mamba");
        Student student2 = new Student("Dirk", "Nowitzki", 1978, 6, 18, "m", "Dirk Diggler");

        StudentRepository studentRepository = getStudentRepository(student, student1, student2);
        studentRepository.deleteStudent("John Doe");

        List<Student> expected = new ArrayList<>();
        expected.add(student);
        expected.add(student1);
        expected.add(student2);
        Assertions.assertEquals(studentRepository.getAll().size(), 3);
        Assertions.assertEquals(studentRepository.getAll(), expected);
    }

    @Test
    public void deleteStudentNullIdTest() {
        Student student = new Student("Diana", "Taurasi", 1982, 6, 11, "F", "White Mamba");
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.addStudent(student);
        Assertions.assertThrows(IllegalArgumentException.class, () -> studentRepository.deleteStudent(null));
    }

    @Test
    public void retrieveStudentsSameAgeTest() {
        Student student = new Student("Diana", "Taurasi", 1982, 6, 11, "F", "White Mamba");
        Student student1 = new Student("Kobe", "Bryant", 1978, 7, 25, "M", "Black Mamba");
        Student student2 = new Student("Dirk", "Nowitzki", 1978, 6, 18, "m", "Dirk Diggler");
        StudentRepository studentRepository = getStudentRepository(student, student1, student2);
        List<Student> expectedList = new ArrayList<>();
        expectedList.add(student1);
        expectedList.add(student2);
        Assertions.assertEquals(studentRepository.retrieveStudentsSameAge(44), expectedList);
    }

    @Test
    public void retrieveStudentsSameAgeNullTest() {
        StudentRepository studentRepository = new StudentRepository();
        Assertions.assertThrows(IllegalArgumentException.class, () -> studentRepository.retrieveStudentsSameAge(null));
    }

    @Test
    public void retrieveStudentsSameAgeNegativeTest() {
        StudentRepository studentRepository = new StudentRepository();
        Assertions.assertThrows(IllegalArgumentException.class, () -> studentRepository.retrieveStudentsSameAge(-2));
    }

    private StudentRepository getStudentRepository(Student... students) {
        StudentRepository studentRepository = new StudentRepository();
        for(Student student: students) {
            studentRepository.addStudent(student);
        }
        return studentRepository;
    }


}