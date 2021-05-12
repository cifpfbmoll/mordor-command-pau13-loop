package edu.pingpong.mordorcommand.domain.processors;

import java.util.Formatter;

import edu.pingpong.mordorcommand.domain.interfaces.Order;
import edu.pingpong.mordorcommand.domain.interfaces.OrderTreatment;
import edu.pingpong.mordorcommand.domain.interfaces.Processor;
import edu.pingpong.mordorcommand.domain.interfaces.Status;

public class Office implements Processor {

    public Office() {
    };

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

        // if (!status) {

        // statusOrder = formatter.format("%1$s %2$s", order.destination(),
        // Status.REJECTED.name()).toString();

        // } else {

        // statusOrder = formatter.format("%1$s %2$s", order.destination(),
        // Status.ACCEPTED.name()).toString();
        // }

        // formatter.close();
        // return statusOrder;

        // return status ?

        // formatter.format("%1$s %2$s", order.destination(),
        // Status.ACCEPTED.name()).toString()
        // :
        // formatter.format("%1$s %2$s", order.destination(),
        // Status.REJECTED.name()).toString();

        // formatter.format("\nThe order with a destination to %1$s and a weight of %2$s
        // has been: %3$s", order.destination(), order.weight(),
        // Status.ACCEPTED.name()).toString()
        // :

        // formatter.format("\nThe order with a destination to %1$s and a weight of %2$s
        // has been: %3$s", order.destination(), order.weight(),
        // Status.REJECTED.name()).toString();

        // String accepted = formatter.format("\nThe order with a destination to %1$s
        // and a weight of %2$s has been: %3$s", order.destination(), order.weight(),
        // Status.ACCEPTED.name()).toString();

        // String rejected = formatter.format("\nThe order with a destination to %1$s
        // and a weight of %2$s has been: %3$s", order.destination(), order.weight(),
        // Status.REJECTED.name()).toString();

        // formatter.close();

        // return status ? accepted : rejected;
        // return status?
        // order.destination() + " " + Status.ACCEPTED.name():
        // order.destination() + " " + Status.REJECTED.name();
    }
}
