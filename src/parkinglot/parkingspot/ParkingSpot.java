package parkinglot.parkingspot;

import exception.parkinglot.NotOccupiedParkingException;
import exception.parkinglot.OccupiedParkingException;
import exception.parkinglot.UnsuitableParkingException;
import parkinglot.vehicle.VehicleType.VehicleType;

public abstract class ParkingSpot {
    private final VehicleType suitableVehicleType;
    private boolean isEmpty;


    public ParkingSpot(VehicleType vehicleType) {
        this.suitableVehicleType = vehicleType;
        this.isEmpty = Constants.EMPTY;
    }

    public static ParkingSpot ofVehicleType(VehicleType vehicleType) {
        if (VehicleType.TWO_WHEEL.equals(vehicleType)) {
            return new ParkingSpotTwoWheels();
        }
        return new ParkingSpotFourWheels();
    }

    public VehicleType getSuitableVehicleType() {
        return suitableVehicleType;
    }

    public boolean getIsEmpty() {
        return isEmpty;
    }


    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }


    public void park(VehicleType vehicleType) {
        if (!this.suitableVehicleType.equals(vehicleType)) {
            throw new UnsuitableParkingException(
                    "This parking spot is for: " + this.suitableVehicleType.getType());
        }
        if (!getIsEmpty()) {
            throw new OccupiedParkingException(
                    "Parking spot is already occupied!");
        }
        setIsEmpty(false);
    }

    public void vacate() {
        if (isEmpty) {
            throw new NotOccupiedParkingException(
                    "Parking spot is not occupied!");
        }
        setIsEmpty(true);
    }


}
