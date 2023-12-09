package parkinglot.strategy;

import parkinglot.model.Ticket;

public class FourWheelerWeekday implements CostStrategy{

    @Override
    public double calculateCost(Ticket ticket) {
        return getDefaultPrice(ticket);
    }
}
