package edu.pingpong.mordorcommand.domain.treatments;

import edu.pingpong.mordorcommand.domain.interfaces.OrderTreatment;
import edu.pingpong.mordorcommand.domain.orders.InternationalOrder;

public class InternationalOrderTreatment implements OrderTreatment{

    private final InternationalOrder intOrder;
    
    public InternationalOrderTreatment(InternationalOrder intOrder) {
        this.intOrder = intOrder;
    }

    public boolean treat() {
        return ! intOrder.destination().equals("Mordor");
    }

    public InternationalOrder getOrder() {
        return this.intOrder;
    }
}
