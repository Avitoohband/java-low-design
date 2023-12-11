package parkinglot.strategy;

import exception.parkinglot.VehicleNotFoundException;
import parkinglot.Constants;
import parkinglot.model.Ticket;

import java.math.BigDecimal;
import java.time.ZoneOffset;
import java.util.Objects;

public interface CostStrategy {

    default BigDecimal getDefaultPrice(Ticket ticket) {
        if (Objects.isNull(ticket.getEnterTime()) || Objects.isNull(ticket.getExitTime())){
            throw new VehicleNotFoundException("Ticket need to be sign in and check out");
        }

        long timePeriod = ticket.getExitTime()
                .toInstant(ZoneOffset.UTC).toEpochMilli()
                - ticket.getEnterTime().toInstant(ZoneOffset.UTC).toEpochMilli();

        return BigDecimal.valueOf (timePeriod * (Constants.HOURLY_PRICE) / Constants.SECONDS_PER_HOUR);
    }
    BigDecimal calculateCost(Ticket ticket);
}