package sensordata;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Arrays;
import java.util.LinkedList;

public class SensorDataSpeicherTest {
    private static SensorDataSpeicher getSensorDataSpeicher(){
        return new SensorDataSpeicherImpl();
    }


    private LinkedList<LinkedList<Double>> getValuesListAllSensors() {
        LinkedList<LinkedList<Double>> allSensors = new LinkedList<>();
        LinkedList<Double> sensor1ValuesList = new LinkedList<>();
        LinkedList<Double> sensor2ValuesList = new LinkedList<>();
        LinkedList<Double> sensor3ValuesList = new LinkedList<>();
        sensor1ValuesList.addAll(Arrays.asList(4.0, 6.0, 4.0, 6.0, 4.0, 6.0));
        sensor2ValuesList.addAll(Arrays.asList(5.0, 7.0, 5.0, 7.0, 5.0, 7.0));
        sensor3ValuesList.addAll(Arrays.asList(8.0, 6.0, 8.0, 6.0, 8.0, 6.0));
        allSensors.add(sensor1ValuesList);
        allSensors.add(sensor2ValuesList);
        allSensors.add(sensor3ValuesList);

        return allSensors;
    }

    @Test
    public void gutTestAverageOneSensor(){
       double average = getSensorDataSpeicher().getAverageOneSensor(getValuesListAllSensors().get(0));
        assertTrue(5.0 == average);
    }

    @Test
    public void gutTestAverageAllSensors(){
        double averageAllSensors = getSensorDataSpeicher().getAverageAllSensors(getValuesListAllSensors());
        assertTrue(6.0 == averageAllSensors );

    }

    @Test
    public void gutTestAmountOfMeasuresOneSensor(){
        int amountOfMeasurements = getSensorDataSpeicher().getAmountOfMeasuresOneSensor(getValuesListAllSensors().get(0));
        assertEquals(6, amountOfMeasurements);

    }


    @Test(expected=Exception.class)
    public void schlechtTestAverageOneSensor(){
        double average = getSensorDataSpeicher().getAverageOneSensor(getValuesListAllSensors().get(4));

    }

    @Test(expected=Exception.class)
    public void schlechtTestAverageAllSensors(){
        double average = getSensorDataSpeicher().getAverageAllSensors(getValuesListAllSensors());

    }

    @Test(expected=Exception.class)
    public void schlechtTestAmountOfMeasuresOneSensor(){
        double average = getSensorDataSpeicher().getAverageOneSensor(getValuesListAllSensors().get(4));

    }

}
