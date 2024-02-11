package ausport.model;

import java.sql.Connection;
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
            
        } catch (Exception e) {
            // TODO: handle exception
        }
       return reservations;
    }

    @Override
    public Reservation getReservationByUsername(String username) {
        return null;
    }

    @Override
    public long insertReservation(Reservation r) {
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
