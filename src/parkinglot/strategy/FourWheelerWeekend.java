package parkinglot.strategy;

import parkinglot.Constants;
import parkinglot.model.Ticket;

public class FourWheelerWeekend implements CostStrategy {

    @Override
    public double calculateCost(Ticket ticket) {
        return getDefaultPrice(ticket) * Constants.WEEKEND_PERCENT;
    }
}
