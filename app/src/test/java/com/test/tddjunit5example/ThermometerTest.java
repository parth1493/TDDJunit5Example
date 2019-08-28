package com.test.tddjunit5example;

import com.test.tddjunit5example.airconditioning.Sensor;
import com.test.tddjunit5example.airconditioning.Thermometer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MokitoExtension.class)
public class ThermometerTest {

    @InjectMocks
    Thermometer thermometer;

    @Mock
    Sensor sensor;

    @Test
    void TestWorkingSensor()
    {
        thermometer.setTempreature(25.0);
        when(sensor.isBlocked()).thenReturn(false);
        assertEquals(sensor,thermometer.getSensor());
        assertEquals(25,thermometer.getTempreature(),0.001);
        verify(sensor,times(1)).isBlocked();
    }

    @Test
    void TestBlockedSensor()
    {
        thermometer.setTempreature(25.0);
        when(sensor.isBlocked()).thenReturn(true);
        assertEquals(sensor,thermometer.getSensor());
        assertThrows(RuntimeException.class ,()->thermometer.getTempreature());
        verify(sensor,times(1)).isBlocked();
    }
}
