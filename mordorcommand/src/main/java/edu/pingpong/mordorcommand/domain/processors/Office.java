package edu.pingpong.mordorcommand.domain.processors;

import edu.pingpong.mordorcommand.domain.interfaces.Order;
import edu.pingpong.mordorcommand.domain.interfaces.OrderTreatment;
import edu.pingpong.mordorcommand.domain.interfaces.Processor;
import edu.pingpong.mordorcommand.domain.interfaces.Status;

public class Office implements Processor{

    public Office() {};
    
    public boolean process(OrderTreatment oTreatment) {
        return oTreatment.treat();
    }

    public String printStatus(boolean status, Order order) {
        return status ? 
            "The order with a destination to " + order.destination() + " and a weight of " + order.weight() + " has been: " + Status.ACCEPTED.name()
        :
        "The order with a destination to " + order.destination() + " and a weight of " + order.weight() + " has been: " + Status.REJECTED.name();
    }
}
