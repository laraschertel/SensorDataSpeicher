package sensordata;

import java.util.LinkedList;

public interface SensorDataSpeicher {
    /**
     *
     * @return average from one sensor
     */
    public double getAverageOneSensor(LinkedList<Double> sensorValuesList);

    /**
     * @return average from all the sensors
     */
    public double getAverageAllSensors(LinkedList<LinkedList<Double>> allSensors);

    /**
     *
     * @return the amount of measurements from a sensor
     */
    public int getAmountOfMeasuresOneSensor(LinkedList<Double> sensorValuesList);



}
