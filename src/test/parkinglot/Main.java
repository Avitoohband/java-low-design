package test.parkinglot;

import exception.parkinglot.ParkingFullException;
import exception.parkinglot.VehicleNotFoundException;
import parkinglot.model.Ticket;
import parkinglot.model.vehicle.Vehicle;
import parkinglot.model.vehicle.VehicleType;
import parkinglot.service.ParkingManager;
import parkinglot.strategy.*;

public class Main {

    private static final int SLEEP_TIME = 250;

    public static void main(String[] args) throws InterruptedException {
        ParkingManager parkingManager = ParkingManager.getParkingManager();

        Vehicle twoWheelVehicle = Vehicle.ofType(VehicleType.TWO_WHEEL);
        Vehicle twoWheelVehicle2 = Vehicle.ofType(VehicleType.TWO_WHEEL);
        Vehicle twoWheelVehicle3 = Vehicle.ofType(VehicleType.TWO_WHEEL);

        Vehicle fourWheelVehicle = Vehicle.ofType(VehicleType.FOUR_WHEEL);
        Vehicle fourWheelVehicle2 = Vehicle.ofType(VehicleType.FOUR_WHEEL);
        Vehicle fourWheelVehicle3 = Vehicle.ofType(VehicleType.FOUR_WHEEL);

        parkingManager.addParkingSlot(VehicleType.TWO_WHEEL);
        parkingManager.addParkingSlot(VehicleType.TWO_WHEEL);
        parkingManager.addParkingSlot(VehicleType.FOUR_WHEEL);
        parkingManager.addParkingSlot(VehicleType.FOUR_WHEEL);


        twoWheelWeekdayParkUnparkSuccess(parkingManager, twoWheelVehicle);
        twoWheelWeekendParkUnparkSuccess(parkingManager, twoWheelVehicle);
        fourWheelWeekendParkUnparkSuccess(parkingManager, fourWheelVehicle);
        fourWheelWeekdayParkUnparkSuccess(parkingManager, fourWheelVehicle);
        unparkShouldThrowVehicleNotFoundException(parkingManager);
        parkShouldThrowParkingFullException(parkingManager, fourWheelVehicle, fourWheelVehicle2, fourWheelVehicle3);


        }

    private static void parkShouldThrowParkingFullException(ParkingManager parkingManager, Vehicle fourWheelVehicle, Vehicle fourWheelVehicle2, Vehicle fourWheelVehicle3) {
        Ticket ticket1 = parkingManager.park(fourWheelVehicle);
        Ticket ticket2 = parkingManager.park(fourWheelVehicle2);

        try {
            Ticket ticket3 = parkingManager.park(fourWheelVehicle3);

        }catch (ParkingFullException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void unparkShouldThrowVehicleNotFoundException(ParkingManager parkingManager) {
        try {
            parkingManager.unPark(
                    new Ticket("Dummy ticket", 0), new FourWheelerWeekend()
            );
        }catch (VehicleNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void twoWheelWeekendParkUnparkSuccess(ParkingManager parkingManager, Vehicle twoWheelVehicle) throws InterruptedException {
        Ticket ticket = parkingManager.park(twoWheelVehicle);
        Thread.sleep(SLEEP_TIME);
        parkingManager.unPark(ticket, new TwoWheelerWeekend());
        System.out.println(ticket);
    }

    private static void twoWheelWeekdayParkUnparkSuccess(ParkingManager parkingManager, Vehicle twoWheelVehicle) throws InterruptedException {
        Ticket ticket = parkingManager.park(twoWheelVehicle);
        Thread.sleep(SLEEP_TIME);
        parkingManager.unPark(ticket, new TwoWheelerWeekday());
        System.out.println(ticket);
    }

    private static void fourWheelWeekendParkUnparkSuccess(ParkingManager parkingManager, Vehicle fourWheelVehicle) throws InterruptedException {
        Ticket ticket = parkingManager.park(fourWheelVehicle);
        Thread.sleep(SLEEP_TIME);
        parkingManager.unPark(ticket, new FourWheelerWeekday());
        System.out.println(ticket);
    }

    private static void fourWheelWeekdayParkUnparkSuccess(ParkingManager parkingManager, Vehicle fourWheelVehicle) throws InterruptedException {
        Ticket ticket = parkingManager.park(fourWheelVehicle);
        Thread.sleep(SLEEP_TIME);
        parkingManager.unPark(ticket, new FourWheelerWeekend());
        System.out.println(ticket);
    }
}
