package com.test.tddjunit5example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Milage
{
    public static final int VIP_FACTOR = 10;
    public static final int USUAL_FACTOR = 20;

    private Map<Passenger,Integer> passengerMilageMap = new HashMap<>();
    private Map<Passenger,Integer> passengerPointsMap = new HashMap<>();

    public void addMilage(Passenger passenger, int miles)
    {
        if(passengerMilageMap.containsKey(passenger))
        {
            passengerMilageMap.put(passenger,passengerMilageMap.get(passenger) + miles);
        }
        else
        {
            passengerMilageMap.put(passenger, miles);
        }
    }

    public Map<Passenger,Integer> getPassengerPointsMap()
    {
        return Collections.unmodifiableMap(passengerPointsMap);
    }

    public void calculateGivenPoints()
    {
        for(Passenger passenger: passengerMilageMap.keySet())
        {
            if(passenger.isVip())
            {
                passengerPointsMap.put(passenger, passengerMilageMap.get(passenger) / VIP_FACTOR);
            }
            else
            {

                passengerPointsMap.put(passenger, passengerMilageMap.get(passenger) / USUAL_FACTOR);
            }
        }
    }
}
