package parkinglot.parkingspot;

import parkinglot.vehicle.VehicleType.VehicleType;

public abstract class ParkingSpot {
    public static int parkingAmount = 0;

    private final int parkingNumber;
    private final VehicleType suitableVehicleType;
    private VehicleType occupiedBy;
    private boolean isEmpty;

    static {
        parkingAmount++;
    }

    protected ParkingSpot(VehicleType vehicleType) {
        this.parkingNumber = parkingAmount;
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

    public int getParkingNumber() {
        return parkingNumber;
    }


    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public VehicleType getOccupiedBy() {
        return occupiedBy;
    }

    public void setOccupiedBy(VehicleType occupiedBy) {
        this.occupiedBy = occupiedBy;
    }

    public void park(VehicleType vehicleType){
        setOccupiedBy(vehicleType);
        setIsEmpty(false);

    }

    public void vacate(){
        setIsEmpty(true);
        setOccupiedBy(null);
    }


//    public void park(VehicleType vehicleType) {
//        if (!this.suitableVehicleType.equals(vehicleType)) {
//            throw new UnsuitableParkingException(
//                    "This parking spot is for: " + this.suitableVehicleType
//            );
//        }
//        if (!getIsEmpty()) {
//            throw new OccupiedParkingException(
//                    "Parking spot is already occupied!");
//        }
//        setIsEmpty(false);
//    }


//    public void vacate() {
//        if (isEmpty) {
//            throw new NotOccupiedParkingException(
//                    "Parking spot is not occupied!");
//        }
//        setIsEmpty(true);
//    }


}
