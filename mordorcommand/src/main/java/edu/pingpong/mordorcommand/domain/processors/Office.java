package edu.pingpong.mordorcommand.domain.processors;

import java.util.Formatter;

import edu.pingpong.mordorcommand.domain.interfaces.Order;
import edu.pingpong.mordorcommand.domain.interfaces.OrderTreatment;
import edu.pingpong.mordorcommand.domain.interfaces.Processor;
import edu.pingpong.mordorcommand.domain.interfaces.Status;

public class Office implements Processor{

    public Office() {};
    
    @Override
    public boolean process(OrderTreatment oTreatment) {
        return oTreatment.treat();
    }

    public String printStatus(boolean status, Order order) {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);

        String statusOrder = status
                ? formatter.format("%1$s %2$s", order.destination(), Status.ACCEPTED.name()).toString()
                : formatter.format("%1$s %2$s", order.destination(), Status.REJECTED.name()).toString();

        formatter.close();

        return statusOrder;
    }
}
