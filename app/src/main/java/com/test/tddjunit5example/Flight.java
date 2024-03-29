package com.test.tddjunit5example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Flight {

    private String id;
    private int distance;

    Set<Passenger> passengerList = new HashSet<>();

    public Flight(String id) {
        this.id = id;
    }


    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public Set<Passenger> getPassengerSet() {
        return Collections.unmodifiableSet(passengerList);
    }

    public abstract boolean addPassenger(Passenger passenger);

    public abstract boolean removePassenger(Passenger passenger);

}
