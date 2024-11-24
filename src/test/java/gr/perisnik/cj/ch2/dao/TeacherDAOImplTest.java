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
    public static void setUpClass() throws SQLException {
        teacherDAO = new TeacherDAOImpl();
        DBHelper.eraseData(); // Clear the database before any tests run
    }

    @BeforeEach
    void setUp() throws TeacherDAOException {
        createDummyTeachers(); // Create some dummy teachers before each test
    }

    @AfterEach
    void tearDown() throws SQLException {
        DBHelper.eraseData(); // Clean up the database after each test
    }

    @Test
    void persistAndGetTeacher() throws TeacherDAOException {
        // Create a new teacher and add it to the database
        Teacher teacher = new Teacher();
        teacher.setFirstname("UserTest");
        teacher.setLastname("UserTest");

        // Add the teacher to the database
        teacherDAO.addTeacher(teacher);

        // Retrieve the teacher by their lastname
        List<Teacher> teachers = teacherDAO.getTeacherByLastname("UserTest");

        // Assert that exactly one teacher is found and verify the teacher's first and last name
        assertEquals(1, teachers.size()); // Check that one teacher is found
        assertEquals("UserTest", teachers.get(0).getFirstname()); // Check first name
        assertEquals("UserTest", teachers.get(0).getLastname()); // Check last name
    }

    @Test
    void updateTeacher() throws TeacherDAOException {
        // Create a teacher with ID 2 and update their information
        Teacher teacher = new Teacher();
        teacher.setId(2);
        teacher.setFirstname("Anna");
        teacher.setLastname("Makrigianni");

        // Update the teacher in the database
        teacherDAO.updateTeacher(teacher);

        // Retrieve the teacher by their updated lastname
        List<Teacher> teachers = teacherDAO.getTeacherByLastname(teacher.getLastname());

        // Assert that the updated teacher's lastname matches the new value
        assertEquals(1, teachers.size()); // Ensure only one teacher is returned
        assertEquals("Makrigianni", teachers.get(0).getLastname()); // Check that the lastname is updated
    }

    @Test
    void deleteTeacher() throws TeacherDAOException {
        int id = 1;

        // Attempt to delete the teacher with ID 1
        teacherDAO.deleteTeacher(id);

        // Try to retrieve the deleted teacher
        Teacher teacher = teacherDAO.getTeacherById(id);

        // Assert that the teacher no longer exists (should be null)
        assertNull(teacher, "Teacher should be deleted"); // Ensure the teacher is deleted
    }

    @Test
    void getTeacherById() throws TeacherDAOException {
        // Retrieve the teacher by their ID
        Teacher teacher = teacherDAO.getTeacherById(1);

        // Assert that the teacher is not null and that their lastname is correct
        assertNotNull(teacher, "Teacher should not be null"); // Check that teacher exists
        assertEquals("Nikoulis", teacher.getLastname()); // Check that the teacher's last name matches
    }

    @Test
    void getTeacherByLastname() throws TeacherDAOException {
        // Retrieve a list of teachers with a lastname that starts with "Nik"
        List<Teacher> teachers = teacherDAO.getTeacherByLastname("Nik");

        // Assert that exactly one teacher is found
        assertEquals(1, teachers.size()); // Ensure exactly one teacher is found
        assertTrue(teachers.get(0).getLastname().startsWith("Nik"), "Teacher's lastname should start with 'Nik'"); // Check that the lastname starts with "Nik"
    }

    @Test
    void getAllTeachers() throws TeacherDAOException {
        // Retrieve all teachers from the database
        List<Teacher> teachers = teacherDAO.getAllTeachers();

        // Assert that the total number of teachers is 3 (as we added 3 dummy teachers)
        assertEquals(3, teachers.size(), "Expected 3 teachers in the database"); // Check that the correct number of teachers are returned
    }

    @Test
    void addTeacherWithEmptyFirstnameOrLastname() throws TeacherDAOException {
        // Attempt to add a teacher with an empty first name or last name

        // Test case where the first name is empty
        Teacher teacher = new Teacher();
        teacher.setFirstname("");
        teacher.setLastname("InvalidTeacher");
        Teacher result = teacherDAO.addTeacher(teacher);

        // Assert that the teacher is not added due to empty first name
        assertNull(result, "Teacher should not be added if firstname is empty");

        // Test case where the last name is empty
        teacher.setFirstname("InvalidTeacher");
        teacher.setLastname("");
        result = teacherDAO.addTeacher(teacher);

        // Assert that the teacher is not added due to empty last name
        assertNull(result, "Teacher should not be added if lastname is empty");
    }

    @Test
    void updateTeacherWithInvalidId() throws TeacherDAOException {
        // Test updating a teacher with an invalid ID (ID that doesn't exist in the database)
        Teacher teacher = new Teacher();
        teacher.setId(999); // Invalid ID (999 doesn't exist in the database)
        teacher.setFirstname("Invalid");
        teacher.setLastname("Teacher");

        // The update should throw an exception because the teacher ID is invalid
        assertThrows(TeacherDAOException.class, () -> teacherDAO.updateTeacher(teacher),
                "Updating a teacher with an invalid ID should throw an exception"); // Assert that an exception is thrown
    }

    // Create dummy data for testing (add 3 teachers to the database)
    public static void createDummyTeachers() throws TeacherDAOException {
        // Teacher 1
        Teacher teacher = new Teacher();
        teacher.setFirstname("Periklis");
        teacher.setLastname("Nikoulis");
        teacherDAO.addTeacher(teacher);

        // Teacher 2
        teacher = new Teacher();
        teacher.setFirstname("Anna");
        teacher.setLastname("Makri");
        teacherDAO.addTeacher(teacher);

        // Teacher 3
        teacher = new Teacher();
        teacher.setFirstname("Nikos");
        teacher.setLastname("Papadopoulos");
        teacherDAO.addTeacher(teacher);
    }
}