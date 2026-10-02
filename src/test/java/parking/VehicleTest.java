package parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleTest {

    @Test
    void vehicleShouldStoreVehicleId() {
        Wallet wallet = new Wallet(100.0);
        Vehicle vehicle = new Vehicle(101, VehicleType.CAR, wallet);

        assertEquals(101, vehicle.getVehicleId());
    }

    @Test
    void vehicleShouldStoreVehicleType() {
        Wallet wallet = new Wallet(100.0);
        Vehicle vehicle = new Vehicle(101, VehicleType.CAR, wallet);

        assertEquals(VehicleType.CAR, vehicle.getVehicleType());
    }

    @Test
    void vehicleShouldReturnWallet() {
        Wallet wallet = new Wallet(100.0);
        Vehicle vehicle = new Vehicle(101, VehicleType.CAR, wallet);

        assertEquals(wallet, vehicle.getWallet());
    }

    @Test
    void vehicleShouldReturnBalance() {
        Wallet wallet = new Wallet(100.0);
        Vehicle vehicle = new Vehicle(101, VehicleType.CAR, wallet);

        assertEquals(100.0, vehicle.getBalance());
    }

    @Test
    void vehicleShouldCreateWalletWithInitialBalance() {
        Vehicle vehicle = new Vehicle(101, VehicleType.CAR, 500.0);

        assertEquals(500.0, vehicle.getBalance());
    }

    @Test
    void vehicleShouldCreateWalletWithInitialBalanceAndReturnIt() {
        Vehicle vehicle = new Vehicle(101, VehicleType.CAR, 500.0);

        assertEquals(500.0, vehicle.getWallet().getBalance());
    }

    @Test
    void vehicleToStringShouldReturnExpectedFormat() {
        Wallet wallet = new Wallet(100.0);
        Vehicle vehicle = new Vehicle(101, VehicleType.CAR, wallet);

        assertEquals(
                "Vehicle{vehicleId=101, vehicleType=CAR, walletBalance=100.0}",
                vehicle.toString()
        );
    }
}