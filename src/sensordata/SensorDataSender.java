package sensordata;

import java.io.IOException;
import java.io.OutputStream;

public interface SensorDataSender {
    /**
     * send sensor data set
     * @param data
     * @param os stream to recipient
     * @throws IOException
     */
    void sendSensorData(SensorData data, OutputStream os) throws IOException;

}
