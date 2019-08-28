package com.test.tddjunit5example.airconditioning;

public class AirConditioningSystem
{
    private Thermometer thermometer;
    private double tempretureThreshold;
    private boolean open;

    public AirConditioningSystem() {
        open = false;
    }

    public void checkAirConditioningSystem()
    {
        this.open = (thermometer.getTempreature() >= tempretureThreshold);
    }

    public boolean isOpen()
    {
        return open;
    }

    public void setThermometer(Thermometer thermometer)
    {
        this.thermometer = thermometer;
    }

    public void setTempretureThreshold(double tempretureThreshold)
    {
        this.tempretureThreshold = tempretureThreshold;
    }
}
