package parkinglot.strategy;

import parkinglot.Constants;
import parkinglot.model.Ticket;

public class TwoWheelerWeekday implements CostStrategy{
    @Override
    public double calculateCost(Ticket ticket) {
        return getDefaultPrice(ticket) * Constants.TWO_WHEELER_PERCENT;
    }
}
