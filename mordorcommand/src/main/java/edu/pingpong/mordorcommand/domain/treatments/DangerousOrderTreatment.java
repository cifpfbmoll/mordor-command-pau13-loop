package edu.pingpong.mordorcommand.domain.treatments;

import edu.pingpong.mordorcommand.domain.interfaces.OrderTreatment;
import edu.pingpong.mordorcommand.domain.interfaces.DangerousOrder;

public class DangerousOrderTreatment implements OrderTreatment{
    
    private final DangerousOrder order;

    public DangerousOrderTreatment(DangerousOrder order) {
        this.order = order;
    }

    @Override
    public boolean treat() {
        return ! order.instructions().equals("No ponerselo en el dedo");
    }

    public DangerousOrder getOrder() {
        return this.order;
    }
}
