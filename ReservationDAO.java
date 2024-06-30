import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationDAO {
    private Connection conn;

    public ReservationDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Reservation> getAllReservations() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM Reservation";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservationId(rs.getInt("reservation_id"));
                reservation.setGuest(new Guest(rs.getInt("guest_id"))); // Assuming Guest has a constructor with guest_id parameter
                reservation.setRoom(new Room(rs.getInt("room_id"))); // Assuming Room has a constructor with room_id parameter
                reservation.setCheckIn(rs.getDate("check_in"));
                reservation.setCheckOut(rs.getDate("check_out"));
                reservation.setTotalAmount(rs.getDouble("total_amount"));
                reservations.add(reservation);
            }
        }
        return reservations;
    }

    // Other methods for CRUD operations
}
