package parkinglot.strategy;

import parkinglot.Constants;
import parkinglot.model.Ticket;

public class TwoWheelerWeekend implements CostStrategy {

    @Override
    public double calculateCost(Ticket ticket) {
        return getDefaultPrice(ticket) * Constants.TWO_WHEELER_PERCENT * Constants.WEEKEND_PERCENT;
    }
}
