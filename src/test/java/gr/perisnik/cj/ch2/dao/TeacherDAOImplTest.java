package gr.perisnik.cj.ch2.dao;

import gr.perisnik.cj.ch2.dao.exceptions.TeacherDAOException;
import gr.perisnik.cj.ch2.model.Teacher;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TeacherDAOImplTest {

    private static ITeacherDAO teacherDAO;

    @BeforeAll
    public static void setUpClass() {
        teacherDAO = new TeacherDAOImpl();
    }
    @BeforeEach
    void setUp() {
        //createDummyTeachers();
    }

    @AfterEach
    void tearDown() {
        //DBHelper.eraseData();
    }

    @Test
    void addTeacher() {
    }

    @Test
    void updateTeacher() {
    }

    @Test
    void deleteTeacher() {
    }

    @Test
    void getTeacherById() {
    }

    @Test
    void getTeacherByLastname() {
    }

    @Test
    void getAllTeachers() {
    }

    public static void createDummyTeachers() throws TeacherDAOException {
        Teacher teacher = new Teacher();
        teacher.setFirstname("Periklis");
        teacher.setLastname("Nikoulis");
        teacherDAO.addTeacher(teacher);

        teacher = new Teacher();
        teacher.setFirstname("Anna");
        teacher.setLastname("Makri");
        teacherDAO.addTeacher(teacher);

        teacher = new Teacher();
        teacher.setFirstname("Nikos");
        teacher.setLastname("Papadopoulos");
        teacherDAO.addTeacher(teacher);
    }
}