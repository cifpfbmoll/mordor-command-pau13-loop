package edu.pingpong.mordorcommand.domain.orders;

import edu.pingpong.mordorcommand.domain.interfaces.Order;

import java.util.UUID;

public class InternationalOrder implements Order {

    private final String id;
    private String destination;
    private int weight;

    public InternationalOrder(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
        this.id = UUID.randomUUID().toString();
    }

    public int weight() {
        return this.weight;
    }

    public String destination() {
        return this.destination;
    }

    public String getId() {
        return this.id;
    }
}
