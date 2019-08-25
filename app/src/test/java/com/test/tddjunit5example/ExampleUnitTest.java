package com.test.tddjunit5example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @DisplayName("Test cases for economy class")
    @Nested
    class EconomyFlightTest
    {

        private Flight economyFlight;

        @BeforeEach
        void setup()
        {
            economyFlight = new EconomyFlight("1");
        }

        @Test
        void testEconomyFlightUsualPassenger()
        {
            Passenger mike = new Passenger("Mike", false);

            assertAll("These test cases are for Economy class and for usual passenger",
                    ()->assertEquals("1", economyFlight.getId()),
                    ()-> assertEquals(true, economyFlight.addPassenger(mike)),
                    ()-> assertEquals(1, economyFlight.getPassengerList().size()),
                    ()-> assertEquals("Mike", economyFlight.getPassengerList().get(0).getName()),
                    ()-> assertEquals(true, economyFlight.removePassenger(mike)),
                    ()-> assertEquals(0, economyFlight.getPassengerList().size())
            );
        }

        @Test
        void testEconomyFlightVipPassenger()
        {
            Passenger john = new Passenger("John", true);

            assertAll("These test cases are for Economy class and for vip passenger",
                    ()-> assertEquals("1", economyFlight.getId()),
                    ()-> assertEquals(true, economyFlight.addPassenger(john)),
                    ()-> assertEquals(1, economyFlight.getPassengerList().size()),
                    ()-> assertEquals("John", economyFlight.getPassengerList().get(0).getName()),
                    ()-> assertEquals(false, economyFlight.removePassenger(john)),
                    ()-> assertEquals(1, economyFlight.getPassengerList().size())
            );
        }

    }

    @DisplayName("Test cases for Business class")
    @Nested
    class BusinessFlightTest
    {
        private Flight businessFlight;

        @BeforeEach
        void setup()
        {
            businessFlight = new BusinessFlight("2");
        }

        @Test
        void testBusinessFlightUsualPassenger()
        {

            Passenger mike = new Passenger("Mike", false);

            assertAll("These test cases are for business class and for usual passenger",
                    ()-> assertEquals(false, businessFlight.addPassenger(mike)),
                    ()-> assertEquals(0, businessFlight.getPassengerList().size()),
                    ()-> assertEquals(false, businessFlight.removePassenger(mike)),
                    ()-> assertEquals(0, businessFlight.getPassengerList().size()));

        }

        @Test
        void testBusinessFlightVipPassenger()
        {
            Passenger john = new Passenger("John", true);

            assertAll("These test cases are for business class and for usual passenger",
                    ()-> assertEquals(true, businessFlight.addPassenger(john)),
                    ()-> assertEquals(1, businessFlight.getPassengerList().size()),
                    ()-> assertEquals(false, businessFlight.removePassenger(john)),
                    ()-> assertEquals(1, businessFlight.getPassengerList().size()));

        }
    }

    @DisplayName("Test cases for Premium class")
    @Nested
    class PremiumFlightTest {
        private Flight premiumFlight;

        @BeforeEach
        void setup() {
            premiumFlight = new PremiumFlight("3");
        }

        @Test
        void testPremiumFlightUsualPassenger() {

            Passenger mike = new Passenger("Mike", false);

            assertAll("These test cases are for business class and for usual passenger",
                    () -> assertEquals(false, premiumFlight.addPassenger(mike)),
                    () -> assertEquals(0, premiumFlight.getPassengerList().size()),
                    () -> assertEquals(false, premiumFlight.removePassenger(mike)),
                    () -> assertEquals(0, premiumFlight.getPassengerList().size()));

        }

        @Test
        @Disabled
        void testPremiumFlightVipPassenger() {
            Passenger john = new Passenger("John", true);

            assertAll("These test cases are for business class and for usual passenger",
                    () -> assertEquals(true, premiumFlight.addPassenger(john)),
                    () -> assertEquals(1, premiumFlight.getPassengerList().size()),
                    () -> assertEquals(false, premiumFlight.removePassenger(john)),
                    () -> assertEquals(1, premiumFlight.getPassengerList().size()));

        }
    }
}