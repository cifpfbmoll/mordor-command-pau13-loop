package edu.pingpong.mordorcommand.domain.orders;

import edu.pingpong.mordorcommand.domain.interfaces.DangerousOrder;

import java.util.UUID;

public class DangeorusOrderOrder implements DangerousOrder {

    private final String id;
    private String destination;
    private int weight = 0;
    private String instructions;

    public DangeorusOrderOrder(String destination, String instructions) {
        this.destination = destination;
        this.instructions = instructions;
        this.id = UUID.randomUUID().toString();
    }

    public int weight() {
        return this.weight;
    }

    public String instructions() {
        return this.instructions;
    }

    public String destination() {
        return this.destination;
    }

    public String getId() {
        return this.id;
    }
}
