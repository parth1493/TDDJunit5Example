package com.test.tddjunit5example;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.test.tddjunit5example", appContext.getPackageName());
    }

    @Test
    public void testEconomyFlightUsualPassenger(){

        Flight economyFlight = new EconomyFlight("1");

        Passenger mike = new Passenger("Mike", false);

        assertEquals("1", economyFlight.getId());
        assertEquals(true, economyFlight.addPassenger(mike));
        assertEquals(1, economyFlight.getPassengerList().size());
        assertEquals("Mike", economyFlight.getPassengerList().get(0).getName());


        assertEquals(true, economyFlight.removePassenger(mike));
        assertEquals(0, economyFlight.getPassengerList().size());

    }

    @Test
    public void testEconomyFlightVipPassenger(){

        Flight economyFlight = new EconomyFlight("1");

        Passenger john = new Passenger("John", true);

        assertEquals("1", economyFlight.getId());
        assertEquals(true, economyFlight.addPassenger(john));
        assertEquals(1, economyFlight.getPassengerList().size());
        assertEquals("John", economyFlight.getPassengerList().get(0).getName());


        assertEquals(false, economyFlight.removePassenger(john));
        assertEquals(1, economyFlight.getPassengerList().size());

    }

    @Test
    public void testBusinessFlightUsualPassenger(){

        Flight businessFlight = new BusinessFlight("2");

        Passenger mike = new Passenger("Mike", false);

        assertEquals(false, businessFlight.addPassenger(mike));
        assertEquals(0, businessFlight.getPassengerList().size());
        assertEquals(false, businessFlight.removePassenger(mike));
        assertEquals(0, businessFlight.getPassengerList().size());

    }

    @Test
    public void testBusinessFlightVipPassenger(){

        Flight businessFlight = new BusinessFlight("2");

        Passenger john = new Passenger("John", true);

        assertEquals(true, businessFlight.addPassenger(john));
        assertEquals(1, businessFlight.getPassengerList().size());
        assertEquals(false, businessFlight.removePassenger(john));
        assertEquals(1, businessFlight.getPassengerList().size());

    }
}
