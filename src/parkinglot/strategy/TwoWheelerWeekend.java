package parkinglot.strategy;

import parkinglot.Constants;
import parkinglot.model.Ticket;

import java.math.BigDecimal;

public class TwoWheelerWeekend implements CostStrategy {

    @Override
    public BigDecimal calculateCost(Ticket ticket) {
        return getDefaultPrice(ticket)
                .multiply(BigDecimal.valueOf(Constants.TWO_WHEELER_PERCENT * Constants.WEEKEND_PERCENT));
    }
}
