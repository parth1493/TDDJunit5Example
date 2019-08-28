package com.test.tddjunit5example;

import com.test.tddjunit5example.airconditioning.AirConditioningSystem;
import com.test.tddjunit5example.airconditioning.Thermometer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MokitoExtension.class)
public class AirConditioningSystemTest
{
    @InjectMocks
    AirConditioningSystem airConditioningSystem;

    @Mock
    Thermometer thermometer;

    @Test
    void testAirCondidionedSystemStarted()
    {
        when(thermometer.getTempreature()).thenReturn(25.0);
        airConditioningSystem.setTempretureThreshold(24.0);
        airConditioningSystem.checkAirConditioningSystem();
        assertTrue(airConditioningSystem.isOpen());
        verify(thermometer,times(1)).getTempreature();
    }

    @Test
    void testAirCondidionedSystemStoped()
    {
        when(thermometer.getTempreature()).thenReturn(23.0);
        airConditioningSystem.setTempretureThreshold(24.0);
        airConditioningSystem.checkAirConditioningSystem();
        assertFalse(airConditioningSystem.isOpen());
        verify(thermometer,times(1)).getTempreature();
    }
}
