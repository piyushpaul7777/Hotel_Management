CREATE TABLE Room (
    room_id INT PRIMARY KEY,
    room_type VARCHAR(50),
    rate DECIMAL(10, 2),
    status VARCHAR(20)
);

CREATE TABLE Guest (
    guest_id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(20)
);

CREATE TABLE Reservation (
    reservation_id INT PRIMARY KEY,
    guest_id INT,
    room_id INT,
    check_in DATE,
    check_out DATE,
    total_amount DECIMAL(10, 2),
    FOREIGN KEY (guest_id) REFERENCES Guest(guest_id),
    FOREIGN KEY (room_id) REFERENCES Room(room_id)
);
