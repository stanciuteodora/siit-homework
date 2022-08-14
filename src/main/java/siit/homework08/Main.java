package siit.homework08;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import siit.homework08.persons.Student;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            Student student = new Student("Diana", "Taurasi", 1982, 6, 11, "F", "White Mamba");
            Student student1 = new Student("Kobe", "Bryant", 1978, 6, 25, "M", "Black Mamba");
            Student student2 = new Student("Shaquille", "O'Neal", 1972, 3, 6, "M", "Shaq");
            Student student3 = new Student("Dirk", "Nowitzki", 1978, 6, 18, "m", "Dirk Diggler");

            StudentRepository studentRepository = new StudentRepository();
            studentRepository.addStudent(student);
            studentRepository.addStudent(student1);
            studentRepository.addStudent(student2);
            studentRepository.addStudent(student3);
            log.info("Printing student repository content" + studentRepository.getAll());

            log.info("Printing students whose age is 44" + studentRepository.retrieveStudentsSameAge(44));
            log.info("Printing student repository ordered by birth date" + studentRepository.getAll("BirthDate"));
            log.info("Printing student repository ordered by last name" + studentRepository.getAll("LastName"));

            studentRepository.deleteStudent("Shaq");
            log.info("Printing student repository content after deleting the student" +  studentRepository.getAll());
        } catch (IllegalArgumentException ex) {
            log.error("Exception trying to use StudentRepository", ex);
        }
    }
}
