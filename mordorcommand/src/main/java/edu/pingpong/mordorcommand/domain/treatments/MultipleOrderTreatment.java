package edu.pingpong.mordorcommand.domain.treatments;

import java.util.Set;
import java.util.Iterator;

import edu.pingpong.mordorcommand.domain.interfaces.Order;
import edu.pingpong.mordorcommand.domain.interfaces.OrderTreatment;

public class MultipleOrderTreatment implements OrderTreatment{
    
    // choosed integer because it can be initialized with null, int can't be initialized like null
    private Integer totalWeight = null;
    private Long numParcels = null; 

    // Why set ? 
    // because set can contain elements that are unique only, not like a list
    private Set<Order> orderSet;

    public MultipleOrderTreatment(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }

    @Override
    public boolean treat() {
        setTotalWeight();
        setTotalParcels();
        return this.totalWeight > 0 && this.numParcels == this.orderSet.size()? true : false;
    }

    public Integer getTotalWeight() {
        return this.totalWeight;
    }

    public Long getNumParcels() {
        return this.numParcels;
    }

    public void setTotalWeight() {
        this.totalWeight = orderSet.stream().map(Order::weight).reduce(0, Integer::sum);
        // orderSet.stream().forEach(o -> this.totalWeight += o.weight());
        // this.orderSet.forEach(o -> this.totalWeight += o.weight());
        // this.totalWeight += orderSet.forEach(o -> o.weight());
        // this.totalWeight = orderSet.stream().map(o -> o.weight()).reduce(0, Integer::weight);
        // this.totalWeight = this.orderSet.stream().map(orderSet::weight).reduce(0, Integer::sum)
        // Iterator<Order> it = orderSet.iterator();
        // while (it.hasNext()) {
        //     this.totalWeight += it.next().weight();
        // }
    }

    public void setTotalParcels() {
        this.numParcels = orderSet.stream().count();
    }
}
