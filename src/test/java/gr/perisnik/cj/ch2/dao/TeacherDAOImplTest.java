package gr.perisnik.cj.ch2.dao;

import gr.perisnik.cj.ch2.dao.exceptions.TeacherDAOException;
import gr.perisnik.cj.ch2.model.Teacher;
import gr.perisnik.cj.ch2.service.util.DBHelper;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeacherDAOImplTest {

    private static ITeacherDAO teacherDAO;

    @BeforeAll
    public static void setUpClass() {
        teacherDAO = new TeacherDAOImpl();
    }
    @BeforeEach
    void setUp() throws TeacherDAOException {
        createDummyTeachers();
    }

    @AfterEach
    void tearDown() throws SQLException {
        DBHelper.eraseData();
    }

    @Test
    void persistAndGetTeacher() throws TeacherDAOException {
        Teacher teacher = new Teacher();
        teacher.setFirstname("UserTest");
        teacher.setLastname("UserTest");
        teacherDAO.addTeacher(teacher);

        List<Teacher> teachers = teacherDAO.getTeacherByLastname("UserTest");

        assertEquals(1, teachers.size());
//        assertTrue(teachers.size() == 1);
    }

    @Test
    void updateTeacher() throws TeacherDAOException {
        Teacher teacher = new Teacher();
        teacher.setId(2);
        teacher.setFirstname("Anna");
        teacher.setLastname("Makrigianni");
        teacherDAO.addTeacher(teacher);

        List<Teacher> teachers = teacherDAO.getTeacherByLastname(teacher.getLastname());

        assertEquals(teachers.get(0).getLastname(), teacher.getLastname());
    }

    @Test
    void deleteTeacher() throws TeacherDAOException {
        int id = 1;
        teacherDAO.getTeacherById(id);

        teacherDAO.deleteTeacher(id);
        Teacher teacher = teacherDAO.getTeacherById(1);

        assertNull(teacher);
    }

    @Test
    void getTeacherById() throws TeacherDAOException {
        Teacher teacher = teacherDAO.getTeacherById(1);

        assertEquals("Nikoulis", teacher.getLastname());
    }

    @Test
    void getTeacherByLastname() throws TeacherDAOException {
        List<Teacher> teachers = teacherDAO.getTeacherByLastname("Nik");

        assertEquals(1, teachers.size());
    }

    @Test
    void getAllTeachers() throws TeacherDAOException {
        List<Teacher> teachers = teacherDAO.getAllTeachers();

        assertEquals(3, teachers.size());
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