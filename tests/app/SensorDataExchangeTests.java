package app;

import org.junit.Assert;
import org.junit.Test;
import sensordata.SensorData;
import sensordata.SensorDataImpl;
import tcp.Client;
import tcp.Connection;
import tcp.Server;
import tcp.TCPConnector;

import java.io.IOException;
import java.util.LinkedList;

public class SensorDataExchangeTests {
    static final int PORT = 555;
    static final String HOSTNAME = "localhost";
    static final String FILENAME = "SensorData.txt";


    private LinkedList<SensorData> getSensorList() {
        LinkedList<SensorData> sensorDataLL = new LinkedList<>();
        SensorData s1 = new SensorDataImpl(2984394, 0.6f, "sensor1");
        SensorData s2 = new SensorDataImpl(2984374, 0.2f, "sensor2");
        SensorData s3 = new SensorDataImpl(3984394, 0.4f, "sensor1");
        SensorData s4 = new SensorDataImpl(2984394, 0.6f, "sensor1");
        SensorData s5 = new SensorDataImpl(2984374, 0.8f, "sensor2");
        SensorData s6 = new SensorDataImpl(3984394, 0.4f, "sensor1");
        sensorDataLL.add(s1);
        sensorDataLL.add(s2);
        sensorDataLL.add(s3);
        sensorDataLL.add(s4);
        sensorDataLL.add(s5);
        sensorDataLL.add(s6);

        return sensorDataLL;
    }

    @Test
    public void gutDataExchangeTest() throws IOException, InterruptedException {

            TCPSensorDataExchanger tcpSendData = new TCPDataExchangerImpl();
            // send sensor data

            tcpSendData.receiveSensorData(PORT);


            tcpSendData.sendSensorData(getSensorList().get(0), HOSTNAME, PORT);


            // TCPSensorDataExchanger tcpReceiveData = new TCPDataExchangerImpl();
            // receive sensor data


            // save data in a file

            // read data from file
        tcpSendData.readFromFile(FILENAME);

    }




}
