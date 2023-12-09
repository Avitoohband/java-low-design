package parkinglot.strategy;

import parkinglot.model.Ticket;

public interface CostStrategy {

    default long getParkingPeriod(Ticket ticket){
        return (long)

    }
    double calculateCost(Ticket ticket);
}
git