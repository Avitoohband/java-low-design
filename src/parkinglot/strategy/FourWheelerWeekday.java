package parkinglot.strategy;

import parkinglot.model.Ticket;

import java.math.BigDecimal;

public class FourWheelerWeekday implements CostStrategy{

    @Override
    public BigDecimal calculateCost(Ticket ticket) {
        return getDefaultPrice(ticket);
    }
}
