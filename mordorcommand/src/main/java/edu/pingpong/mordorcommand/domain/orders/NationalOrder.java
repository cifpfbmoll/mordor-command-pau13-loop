package edu.pingpong.mordorcommand.domain.orders;

import java.util.UUID;

import edu.pingpong.mordorcommand.domain.interfaces.Order;

public class NationalOrder implements Order {

    private final String id;
    private String destination;
    private int weight;

    public NationalOrder(String destination, int weight) {

        this.id = UUID.randomUUID().toString();
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int weight() {
        return this.weight;
    }

    @Override
    public String destination() {
        return this.destination;
    }

    public String getId() {
        return this.id;
    }
}
