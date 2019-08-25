package com.test.tddjunit5example;

public class PremiumFlight extends Flight{


    public PremiumFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {

        if(passenger.isVip())
        {
            return passengerList.add(passenger);
        }
        return false;
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
      if(passengerList.size()>0)
      {
        return passengerList.remove(passenger);
      }
      return false;
    }
}
