package com.test.tddjunit5example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
                    ()-> assertEquals(1, economyFlight.getPassengerSet().size()),
                    ()-> assertTrue(economyFlight.getPassengerSet().contains(mike)),
                    ()-> assertEquals(true, economyFlight.removePassenger(mike)),
                    ()-> assertEquals(0, economyFlight.getPassengerSet().size())
            );
        }

        @Test
        void testEconomyFlightVipPassenger()
        {
            Passenger john = new Passenger("John", true);

            assertAll("These test cases are for Economy class and for vip passenger",
                    ()-> assertEquals("1", economyFlight.getId()),
                    ()-> assertEquals(true, economyFlight.addPassenger(john)),
                    ()-> assertEquals(1, economyFlight.getPassengerSet().size()),
                    ()-> assertTrue(economyFlight.getPassengerSet().contains(john)),
                    ()-> assertEquals(false, economyFlight.removePassenger(john)),
                    ()-> assertEquals(1, economyFlight.getPassengerSet().size())
            );
        }

        @DisplayName("One passenger can not be added more then one time")
        @RepeatedTest(5)
        void testEconomyFlightUsualPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo)
        {

            Passenger mike = new Passenger("Mike", false);

            for(int i=0; i< repetitionInfo.getCurrentRepetition() ; i++)
            {
                economyFlight.addPassenger(mike);
            }
            assertAll("These test cases are for Economy class and for usual passenger more than once",
                    () -> assertEquals(1,economyFlight.getPassengerSet().size()),
                    () -> assertTrue(economyFlight.getPassengerSet().contains(mike)),
                    () -> assertTrue(new ArrayList<>(economyFlight.getPassengerSet()).get(0).getName().equals("Mike"))
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
                    ()-> assertEquals(0, businessFlight.getPassengerSet().size()),
                    ()-> assertEquals(false, businessFlight.removePassenger(mike)),
                    ()-> assertEquals(0, businessFlight.getPassengerSet().size()));

        }

        @Test
        void testBusinessFlightVipPassenger()
        {
            Passenger john = new Passenger("John", true);

            assertAll("These test cases are for business class and for usual passenger",
                    ()-> assertEquals(true, businessFlight.addPassenger(john)),
                    ()-> assertEquals(1, businessFlight.getPassengerSet().size()),
                    ()-> assertEquals(false, businessFlight.removePassenger(john)),
                    ()-> assertEquals(1, businessFlight.getPassengerSet().size()));

        }

        @DisplayName("One passenger can not be added more then one time")
        @RepeatedTest(5)
        void testBusinessFlightUsualPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo)
        {

            Passenger john = new Passenger("John", true);

            for(int i=0; i< repetitionInfo.getCurrentRepetition() ; i++)
            {
                businessFlight.addPassenger(john);
            }
            assertAll("These test cases are for Business class and for usual passenger more than once",
                    () -> assertEquals(1,businessFlight.getPassengerSet().size()),
                    () -> assertTrue(businessFlight.getPassengerSet().contains(john)),
                    () -> assertTrue(new ArrayList<>(businessFlight.getPassengerSet()).get(0).getName().equals("John"))
            );

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
                    () -> assertEquals(0, premiumFlight.getPassengerSet().size()),
                    () -> assertEquals(false, premiumFlight.removePassenger(mike)),
                    () -> assertEquals(0, premiumFlight.getPassengerSet().size()));

        }

        @Test
        void testPremiumFlightVipPassenger() {
            Passenger john = new Passenger("John", true);

            assertAll("These test cases are for business class and for usual passenger",
                    () -> assertEquals(true, premiumFlight.addPassenger(john)),
                    () -> assertEquals(1, premiumFlight.getPassengerSet().size()),
                    () -> assertEquals(true, premiumFlight.removePassenger(john)),
                    () -> assertEquals(0, premiumFlight.getPassengerSet().size()));

        }

        @DisplayName("One passenger can not be added more then one time")
        @RepeatedTest(5)
        void testPremiumFlightUsualPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo)
        {

            Passenger john = new Passenger("John", true);

            for(int i=0; i< repetitionInfo.getCurrentRepetition() ; i++)
            {
                premiumFlight.addPassenger(john);
            }
            assertAll("These test cases are for Business class and for usual passenger more than once",
                    () -> assertEquals(1,premiumFlight.getPassengerSet().size()),
                    () -> assertTrue(premiumFlight.getPassengerSet().contains(john)),
                    () -> assertTrue(new ArrayList<>(premiumFlight.getPassengerSet()).get(0).getName().equals("John"))
            );

        }

    }
}