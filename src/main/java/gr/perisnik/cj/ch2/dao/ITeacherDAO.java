package gr.perisnik.cj.ch2.dao;

import gr.perisnik.cj.ch2.dao.exceptions.TeacherDAOException;
import gr.perisnik.cj.ch2.model.Teacher;

import java.util.List;

/**
 * This interface defines the methods for accessing and manipulating teacher data.
 * Implementations of this interface should provide the actual logic for interacting
 * with the data source (e.g., database) to perform CRUD operations.
 *
 * @version 0.1
 * @author Peris Nik
 */
public interface ITeacherDAO {
    // Define method signatures for CRUD operations on Teacher entities

    /**
     * Adds a new teacher to the data source.
     *
     * @param teacher the teacher to be added
     * @throws TeacherDAOException if an error occurs while adding the teacher
     */
    Teacher addTeacher(Teacher teacher) throws TeacherDAOException;

    /**
     * Updates the details of an existing teacher in the data source.
     *
     * @param teacher the teacher with updated details
     * @throws TeacherDAOException if an error occurs while updating the teacher
     */
    Teacher updateTeacher(Teacher teacher) throws TeacherDAOException;

    /**
     * Deletes a teacher from the data source based on the teacher's ID.
     *
     * @param teacherId the ID of the teacher to be deleted
     * @throws TeacherDAOException if an error occurs while deleting the teacher
     */
    void deleteTeacher(int teacherId) throws TeacherDAOException;

    /**
     * Retrieves a teacher from the data source based on the teacher's ID.
     *
     * @param teacherId the ID of the teacher to be retrieved
     * @return the teacher with the specified ID, or null if not found
     * @throws TeacherDAOException if an error occurs while retrieving the teacher
     */
    Teacher getTeacherById(int teacherId) throws TeacherDAOException;

    /**
     * Retrieves a list of teachers from the data source based on the teacher's lastname.
     *
     * @param lastname the lastname of the teacher to be retrieved
     * @return a list of teachers with the specified lastname, or an empty list if none found
     * @throws TeacherDAOException if an error occurs while retrieving the teachers
     */
    List<Teacher> getTeacherByLastname(String lastname) throws TeacherDAOException;

    /**
     * Retrieves a list of all teachers from the data source.
     *
     * @return a list of all teachers
     * @throws TeacherDAOException if an error occurs while retrieving the teachers
     */
    List<Teacher> getAllTeachers() throws TeacherDAOException;
}
