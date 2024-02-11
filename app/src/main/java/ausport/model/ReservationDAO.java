package ausport.model;

import java.util.List;


public interface ReservationDAO extends DAO {
    Reservation getReservationByUsername(String username);
    List<Reservation> getAllReservations();
    long insertReservation(Reservation r);
    long updateResrevation(Reservation r);
    long deleteReservation(Reservation r);
    
}
