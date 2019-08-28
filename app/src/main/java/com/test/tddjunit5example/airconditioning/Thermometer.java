package com.test.tddjunit5example.airconditioning;

public class Thermometer
{
    private double tempreature;
    private Sensor sensor;

    public double getTempreature() {
        if(sensor.isBlocked())
        {
            throw new RuntimeException("Sensor is blocked");
        }
        return tempreature;
    }

    public void setTempreature(double tempreature) {
        this.tempreature = tempreature;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
