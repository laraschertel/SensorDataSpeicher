package app;

import sensordata.SensorData;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import sensordata.SensorData;

public interface TCPSensorDataExchanger {
    /**
     * Send sensor data to a specified host
     * @param
     * @param hostname
     * @param port
     */
    void sendSensorData(SensorData sensorData, String hostname, int port) throws IOException;

    /**
     * Listen on a port and receive sensor data
     * @param port
     */
    SensorData receiveSensorData(int port) throws IOException, InterruptedException;

    LinkedList<SensorData> getSensorDataList();

    void saveInAFile(SensorData sensorData, String filename) throws IOException, FileNotFoundException;

    LinkedList<SensorData> readFromFile(String filename) throws IOException, FileNotFoundException;



}
