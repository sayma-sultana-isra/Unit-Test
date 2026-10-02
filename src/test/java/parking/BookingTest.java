package parking;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingTest {

    @Test
    void bookingShouldStoreBookingId() {
        Vehicle vehicle = new Vehicle(101, VehicleType.CAR, 500.0);
        ParkingSlot parkingSlot = new ParkingSlot("A1", ParkingSlotType.REGULAR);

        LocalDateTime start = LocalDateTime.of(2026, 10, 1, 10, 0);
        LocalDateTime end = LocalDateTime.of(2026, 10, 1, 12, 0);

        Booking booking = new Booking(
                1, vehicle, parkingSlot, start, end, 20.0
        );

        assertEquals(1, booking.getBookingId());
    }

    @Test
    void bookingShouldStoreVehicle() {
        Vehicle vehicle = new Vehicle(101, VehicleType.CAR, 500.0);
        ParkingSlot parkingSlot = new ParkingSlot("A1", ParkingSlotType.REGULAR);

        LocalDateTime start = LocalDateTime.of(2026, 10, 1, 10, 0);
        LocalDateTime end = LocalDateTime.of(2026, 10, 1, 12, 0);

        Booking booking = new Booking(
                1, vehicle, parkingSlot, start, end, 20.0
        );

        assertEquals(vehicle, booking.getVehicle());
    }

    @Test
    void bookingShouldStoreParkingSlot() {
        Vehicle vehicle = new Vehicle(101, VehicleType.CAR, 500.0);
        ParkingSlot parkingSlot = new ParkingSlot("A1", ParkingSlotType.REGULAR);

        LocalDateTime start = LocalDateTime.of(2026, 10, 1, 10, 0);
        LocalDateTime end = LocalDateTime.of(2026, 10, 1, 12, 0);

        Booking booking = new Booking(
                1, vehicle, parkingSlot, start, end, 20.0
        );

        assertEquals(parkingSlot, booking.getParkingSlot());
    }

    @Test
    void bookingShouldStoreStartTime() {
        Vehicle vehicle = new Vehicle(101, VehicleType.CAR, 500.0);
        ParkingSlot parkingSlot = new ParkingSlot("A1", ParkingSlotType.REGULAR);

        LocalDateTime start = LocalDateTime.of(2026, 10, 1, 10, 0);
        LocalDateTime end = LocalDateTime.of(2026, 10, 1, 12, 0);

        Booking booking = new Booking(
                1, vehicle, parkingSlot, start, end, 20.0
        );

        assertEquals(start, booking.getStartTime());
    }

    @Test
    void bookingShouldStoreEndTime() {
        Vehicle vehicle = new Vehicle(101, VehicleType.CAR, 500.0);
        ParkingSlot parkingSlot = new ParkingSlot("A1", ParkingSlotType.REGULAR);

        LocalDateTime start = LocalDateTime.of(2026, 10, 1, 10, 0);
        LocalDateTime end = LocalDateTime.of(2026, 10, 1, 12, 0);

        Booking booking = new Booking(
                1, vehicle, parkingSlot, start, end, 20.0
        );

        assertEquals(end, booking.getEndTime());
    }

    @Test
    void bookingShouldStoreAmount() {
        Vehicle vehicle = new Vehicle(101, VehicleType.CAR, 500.0);
        ParkingSlot parkingSlot = new ParkingSlot("A1", ParkingSlotType.REGULAR);

        LocalDateTime start = LocalDateTime.of(2026, 10, 1, 10, 0);
        LocalDateTime end = LocalDateTime.of(2026, 10, 1, 12, 0);

        Booking booking = new Booking(
                1, vehicle, parkingSlot, start, end, 20.0
        );

        assertEquals(20.0, booking.getAmount());
    }

    @Test
    void newBookingShouldHaveActiveStatus() {
        Vehicle vehicle = new Vehicle(101, VehicleType.CAR, 500.0);
        ParkingSlot parkingSlot = new ParkingSlot("A1", ParkingSlotType.REGULAR);

        LocalDateTime start = LocalDateTime.of(2026, 10, 1, 10, 0);
        LocalDateTime end = LocalDateTime.of(2026, 10, 1, 12, 0);

        Booking booking = new Booking(
                1, vehicle, parkingSlot, start, end, 20.0
        );

        assertEquals(BookingStatus.ACTIVE, booking.getBookingStatus());
    }

    @Test
    void completeBookingShouldChangeStatusToCompleted() {
        Vehicle vehicle = new Vehicle(101, VehicleType.CAR, 500.0);
        ParkingSlot parkingSlot = new ParkingSlot("A1", ParkingSlotType.REGULAR);

        LocalDateTime start = LocalDateTime.of(2026, 10, 1, 10, 0);
        LocalDateTime end = LocalDateTime.of(2026, 10, 1, 12, 0);

        Booking booking = new Booking(
                1, vehicle, parkingSlot, start, end, 20.0
        );

        booking.completeBooking();

        assertEquals(BookingStatus.COMPLETED, booking.getBookingStatus());
    }

    @Test
    void cancelBookingShouldChangeStatusToCancelled() {
        Vehicle vehicle = new Vehicle(101, VehicleType.CAR, 500.0);
        ParkingSlot parkingSlot = new ParkingSlot("A1", ParkingSlotType.REGULAR);

        LocalDateTime start = LocalDateTime.of(2026, 10, 1, 10, 0);
        LocalDateTime end = LocalDateTime.of(2026, 10, 1, 12, 0);

        Booking booking = new Booking(
                1, vehicle, parkingSlot, start, end, 20.0
        );

        booking.cancelBooking();

        assertEquals(BookingStatus.CANCELLED, booking.getBookingStatus());
    }
}