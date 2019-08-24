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
    public void testAirport(){

        Flight economyFlight = new Flight("1","Economy");
        Flight businessFlight = new Flight("2","Business");

        Passenger john = new Passenger("John", true);
        Passenger mike = new Passenger("Mike", false);

        assertEquals(true,economyFlight.addPassenger(john));
        assertEquals(false,economyFlight.removePassenger(john));
        assertEquals(true,businessFlight.addPassenger(john));
        assertEquals(false,businessFlight.removePassenger(john));

        assertEquals(true,economyFlight.addPassenger(mike));
        assertEquals(true,economyFlight.removePassenger(mike));
        assertEquals(false,businessFlight.addPassenger(mike));
        assertEquals(false,businessFlight.removePassenger(mike));


    }
}
