package com.test.tddjunit5example;

import android.util.Log;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MilageTest
{
    private Milage milage;

    @BeforeAll
    void setup()
    {
        milage = new Milage();
    }

    @ParameterizedTest
    @ValueSource (strings = {"1; e ; Mike ; false ; 349" , "2; b ; John ; true ; 278", "3; e ; Mike ; false ; 319", "4; p ; John ; true ; 817", "5; e ; Mike ; false ; 623" , "4 ; e ; John ; true ; 978"})
    void checkGivenPoints(@ConvertWith(FlightArgumentConverter.class) Flight flight)
    {
        for(Passenger passenger : flight.getPassengerSet())
        {
            milage.addMilage(passenger,flight.getDistance());
        }
    }

    @AfterAll
    void afterAll()
    {
        milage.calculateGivenPoints();
        assertEquals(64, milage.getPassengerPointsMap().get(new Passenger("Mike",false)).intValue());
        assertEquals(207, milage.getPassengerPointsMap().get(new Passenger("John",true)).intValue());
        System.out.println(milage.getPassengerPointsMap());
    }
}
