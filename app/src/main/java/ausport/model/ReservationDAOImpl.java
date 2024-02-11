package ausport.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class ReservationDAOImpl implements ReservationDAO {
    Connection connection;

    public ReservationDAOImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public void setup() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setup'");
    }

    @Override
    public boolean checkConnection() throws Exception {
       return false;
    }

    @Override
    public void close() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'close'");
    }

    @Override
    public List<Reservation> getAllReservations() {
       List<Reservation> reservations = new ArrayList<>();
        String query = "SELECT * FROM reservations";
        try {
            Statement stmt = connection.createStatement();
            ResultSet s = stmt.executeQuery(query);
            while(s.next()){
                int reservationID = s.getInt("id");
                int fieldID = s.getInt("fieldID");
                String username = s.getString("username");
                LocalDateTime startTime = s.getTimestamp("startTime").toLocalDateTime();
                LocalDateTime endTime = s.getTimestamp("endTime").toLocalDateTime();
                Reservation r = new Reservation(reservationID, fieldID, username, startTime, endTime);
                reservations.add(r);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       return reservations;
    }

    @Override
    public Reservation getReservationByUsername(String username) {
        return null;
    }

    @Override
    public long insertReservation(Reservation r) {
        String query = "INSERT INTO reservations (fieldID,username,startTime,endTime) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, r.getFieldID());
            stmt.setString(2, r.getUsername());
            stmt.setTimestamp(3,Timestamp.valueOf(r.getStartTime()));
            stmt.setTimestamp(4, Timestamp.valueOf(r.getEndTime()));
            long affected = stmt.executeUpdate();
            return affected;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public long updateResrevation(Reservation r) {
        return 0;
    }

    @Override
    public long deleteReservation(Reservation r) {
     return 0;
    }

    
}
