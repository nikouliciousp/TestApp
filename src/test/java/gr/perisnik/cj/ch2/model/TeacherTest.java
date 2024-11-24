package gr.perisnik.cj.ch2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {

    @Test
    void getId() {
        Teacher teacher = new Teacher();
        teacher.setId(1);
        assertEquals(1, teacher.getId());
    }

    @Test
    void setId() {
        Teacher teacher = new Teacher();
        teacher.setId(42);
        assertEquals(42, teacher.getId());
    }

    @Test
    void getFirstname() {
        Teacher teacher = new Teacher();
        teacher.setFirstname("John");
        assertEquals("John", teacher.getFirstname());
    }

    @Test
    void setFirstname() {
        Teacher teacher = new Teacher();
        teacher.setFirstname("Alice");
        assertEquals("Alice", teacher.getFirstname());
    }

    @Test
    void getLastname() {
        Teacher teacher = new Teacher();
        teacher.setLastname("Doe");
        assertEquals("Doe", teacher.getLastname());
    }

    @Test
    void setLastname() {
        Teacher teacher = new Teacher();
        teacher.setLastname("Smith");
        assertEquals("Smith", teacher.getLastname());
    }

    @Test
    void testToString() {
        Teacher teacher = new Teacher(1, "Jane", "Doe");
        String expected = "Teacher [id=1, firstname=Jane, lastname=Doe]";
        assertEquals(expected, teacher.toString());
    }

    @Test
    void testAllArgsConstructor() {
        Teacher teacher = new Teacher(10, "TestFirst", "TestLast");
        assertEquals(10, teacher.getId());
        assertEquals("TestFirst", teacher.getFirstname());
        assertEquals("TestLast", teacher.getLastname());
    }

    @Test
    void testNoArgsConstructor() {
        Teacher teacher = new Teacher();
        assertNotNull(teacher); // Ensure the object is created successfully
        assertEquals(0, teacher.getId()); // Default int value
        assertNull(teacher.getFirstname()); // Default String value
        assertNull(teacher.getLastname());
    }
}
