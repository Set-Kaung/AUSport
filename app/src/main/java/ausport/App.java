/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ausport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;


import ausport.model.*;

public class App {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AUSport", "au_admin", "admin1234");
            FieldDAOImpl fDAO = new FieldDAOImpl(connection);
            UserDAOImpl uDAO = new UserDAOImpl(connection);
            ReservationDAOImpl rDAO = new ReservationDAOImpl(connection);
            User u = uDAO.getUserByUsername("SetKaung");
            List<Field> fields = fDAO.getAllFields();
            if(u != null && !fields.isEmpty()){
                Field f = fields.get(0);
                Reservation r = new Reservation(f.getFieldID(), u.getUsername(), LocalDateTime.of(2024, 2, 19, 14, 30), LocalDateTime.of(2024,2,19,15,30));
                rDAO.insertReservation(r);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
