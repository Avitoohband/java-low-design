package parkinglot.strategy;

import exception.parkinglot.IllegalTicketException;
import parkinglot.Constants;
import parkinglot.model.Ticket;

import java.util.Objects;

public interface CostStrategy {

    default double getDefaultPrice(Ticket ticket) {
        if (Objects.isNull(ticket.getEnterTime()) || Objects.isNull(ticket.getExitTime())){
            throw new IllegalTicketException("Ticket need to be sign in and check out");
        }
        long timePeriod = ticket.getExitTime().getTime() - ticket.getEnterTime().getTime();

        return (double) (timePeriod * (Constants.HOURLY_PRICE) / Constants.SECONDS_PER_HOUR);
    }
    double calculateCost(Ticket ticket);
}