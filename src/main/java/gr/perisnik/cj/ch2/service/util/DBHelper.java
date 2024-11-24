package gr.perisnik.cj.ch2.service.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for database operations.
 * This class provides methods for erasing data from the database and converting ResultSet to a list of table names.
 * No instances of this class should be available.
 *
 * @version 0.1
 * @autor Peris Nik
 */
public class DBHelper {

    /**
     * No instances of this class should be available.
     */
    private DBHelper() {}

    /**
     * Erases all data from all tables in the database.
     * This method disables foreign key checks, deletes all data, resets auto-increment values, and then re-enables foreign key checks.
     *
     * @throws SQLException if a database access error occurs
     */
    public static void eraseData() throws SQLException {
        Connection conn = null;
        ResultSet rs = null;
//      PreparedStatement pst = null;

        try {
            // Obtain a connection to the database
            conn = DBUtil.getConnection();

            // Disable foreign key checks
            conn.prepareStatement("SET @@foreign_key_checks = 0").executeUpdate();

            // Retrieve all table names from the database
            rs = conn.prepareStatement("SELECT TABLE_NAME FROM information_schema.tables WHERE TABLE_SCHEMA = 'studentsdbcj'")
                    .executeQuery();

            // Convert the ResultSet to a list of table names
            List<String> tables = mapRSToList(rs);

            // Iterate over all table names and delete their data, then reset their auto-increment values
            for (String table : tables) {
                conn.prepareStatement("DELETE FROM " + table).executeUpdate();
                conn.prepareStatement("ALTER TABLE " + table + " AUTO_INCREMENT = 1").executeUpdate();
            }

            // Re-enable foreign key checks
            conn.prepareStatement("SET @@foreign_key_checks = 1").executeUpdate();
        } finally {
            if (rs != null) {
                // Close the ResultSet
                rs.close();
            }

//          if (pst != null) {
//              pst.close();
//          }

            if (conn != null) {
                // Close the database connection
                conn.close();
            }
        }
    }

    /**
     * Converts a ResultSet to a list of table names.
     *
     * @param rs the ResultSet to be converted
     * @return a list of table names
     * @throws SQLException if a database access error occurs
     */
    public static List<String> mapRSToList(ResultSet rs) throws SQLException {
        List<String> list = new ArrayList<>();

        // Iterate over the ResultSet and add each table name to the list
        while (rs.next()) {
            list.add(rs.getString("TABLE_NAME"));
        }
        return list;
    }
}