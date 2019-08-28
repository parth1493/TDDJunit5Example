package com.test.tddjunit5example.airconditioning;

import com.test.tddjunit5example.Flight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

    private Map<String,String> registerUsers = new HashMap<>();
    List<List<String>> queryData = new ArrayList<>();

    public boolean login(Credentials credentials)
    {
        String userName = credentials.getUsername();
        String password = credentials.getPassword();

        return registerUsers.keySet().contains(userName) &&
                registerUsers.get(userName).equals(password);
    }

    public List<List<String>> queryFlightDatabase()
    {
        return queryData;
    }

    public double averageDistance(List<Flight> flightList)
    {
        return flightList.stream()
                .mapToDouble(Flight::getDistance)
                .average()
                .getAsDouble();
    }

    public double minimumnDistance(List<Flight> flightList)
    {
        return flightList.stream()
            .mapToInt(Flight::getDistance)
            .min()
            .getAsInt();
    }
    public double maximumDistance(List<Flight> flightList)
    {
        return flightList.stream()
            .mapToInt(Flight::getDistance)
            .max()
            .getAsInt();
    }
}
