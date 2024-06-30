import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class HotelManagementSystemApp {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hotel_db";
    private static final String DB_USER = "username";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            RoomDAO roomDAO = new RoomDAO(conn);
            List<Room> rooms = roomDAO.getAllRooms();
            System.out.println("Rooms:");
            for (Room room : rooms) {
                System.out.println(room.getRoomId() + " - " + room.getRoomType() + " - $" + room.getRate());
            }

            GuestDAO guestDAO = new GuestDAO(conn);
            List<Guest> guests = guestDAO.getAllGuests();
            System.out.println("\nGuests:");
            for (Guest guest : guests) {
                System.out.println(guest.getGuestId() + " - " + guest.getName() + " - " + guest.getEmail());
            }

            ReservationDAO reservationDAO = new ReservationDAO(conn);
            List<Reservation> reservations = reservationDAO.getAllReservations();
            System.out.println("\nReservations:");
            for (Reservation reservation : reservations) {
                System.out.println(reservation.getReservationId() + " - Guest: " + reservation.getGuest().getName() +
                                   " - Room: " + reservation.getRoom().getRoomId() +
                                   " - Dates: " + reservation.getCheckIn() + " to " + reservation.getCheckOut() +
                                   " - Total: $" + reservation.getTotalAmount());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
