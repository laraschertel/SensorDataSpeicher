package app;

import sensordata.*;
import tcp.Client;
import tcp.Connection;
import tcp.Server;
import tcp.TCPConnector;

import java.io.*;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class TCPDataExchangerImpl implements TCPSensorDataExchanger{

    public final LinkedList<SensorData> sensorValuesList = new LinkedList<>();

    @Override
    public void sendSensorData(SensorData sensorData, String hostname, int port) throws IOException {
        Client client = new TCPConnector();
        Connection connection = client.connect(hostname, port);

        SensorDataSender sensorDataSender = new SensorDataExchanger();
        sensorDataSender.sendSensorData(sensorData, connection.getOutputStream());

    }

    @Override
    public SensorData receiveSensorData(int port) throws IOException, InterruptedException {
        Server server = new TCPConnector();
        Connection connection = server.acceptConnection(port);


        SensorDataReceiver sensorDataReceiver = new SensorDataExchanger();
        SensorData receivedData = sensorDataReceiver.receiveSensorData(connection.getInputStream());
        System.out.println("Data" + receivedData);

        saveInAFile(receivedData, "SensorData.txt");

       return  receivedData;

    }

    @Override
    public LinkedList<SensorData> getSensorDataList() {
        return this.sensorValuesList;
    }

    @Override
    public void saveInAFile(SensorData sensorData, String filename) throws IOException, FileNotFoundException {

        try {
            OutputStream os = new FileOutputStream(filename);
            DataOutputStream dos = new DataOutputStream(os);
            try {
                    dos.writeLong(sensorData.getTimeStamp());
                    dos.writeFloat(sensorData.getValue());
                    dos.writeUTF(sensorData.getSensorName());
            } catch (IOException ex) {
                System.err.println("couldn’t write data - fatal");
                System.exit(0);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Could not open file - fatal");
            System.exit(0);
        }
    }


    @Override
    public LinkedList<SensorData> readFromFile(String filename) throws IOException, FileNotFoundException {

        InputStream is = new FileInputStream(filename);
        DataInputStream dis = new DataInputStream(is);

        LinkedList<SensorData> list = new LinkedList<>();

        int length = dis.readInt();
        for (int i = 0; i < length; i++) {
            SensorData data = new SensorDataImpl(dis.readLong(), dis.readFloat(), dis.readUTF());
            list.add(data);
        }
        return list;
    }
}
