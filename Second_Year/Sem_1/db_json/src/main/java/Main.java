import Model.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        String pathCars = "src/main/java/Data/Cars.txt";
        String pathClients = "src/main/java/Data/Clients.txt";
        String pathDrivers = "src/main/java/Data/Drivers.txt";
        String pathOrders = "src/main/java/Data/Orders.txt";

        String jsonFileName = "db.json";
        String pathToSaveJSonFile = "src/main/java/JSON/";

        DB dataBase = new DB();
        dataBase.setCars(readCars(pathCars));
        dataBase.setClients(readClient(pathClients));
        dataBase.setDrives(readDriver(pathDrivers, dataBase.getCars()));
        dataBase.setOrders(readOrder(pathOrders, dataBase.getClients()));


        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(pathToSaveJSonFile + jsonFileName), dataBase);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Car> readCars(String path) throws IOException {

        BufferedReader read = new BufferedReader(new FileReader(path));
        List<Car> dataFile = new ArrayList<>();
        read.readLine();
        String line = read.readLine();
        while (line != null) {
            String[] da = line.split(",");
            dataFile.add(new Car(Integer.parseInt(da[0]), da[1], da[2]));
            line = read.readLine();
        }
        return dataFile;
    }

    public static List<Client> readClient(String path) throws IOException {

        BufferedReader read = new BufferedReader(new FileReader(path));
        List<Client> dataFile = new ArrayList<>();
        read.readLine();
        String line = read.readLine();
        while (line != null) {
            String[] da = line.split(",");
            dataFile.add(new Client(Integer.parseInt(da[0]), da[1], da[2]));
            line = read.readLine();
        }
        return dataFile;
    }

    public static List<Driver> readDriver(String path, List<Car> cars) throws IOException {

        BufferedReader read = new BufferedReader(new FileReader(path));
        List<Driver> dataFile = new ArrayList<>();
        read.readLine();
        String line = read.readLine();
        while (line != null) {
            String[] da = line.split(",");
            dataFile.add(new Driver(Integer.parseInt(da[0]), da[1], da[2], getCarById(Integer.parseInt(da[3]), cars)));
            line = read.readLine();
        }
        return dataFile;
    }

    public static List<Order> readOrder(String path, List<Client> clients) throws IOException {

        BufferedReader read = new BufferedReader(new FileReader(path));
        List<Order> dataFile = new ArrayList<>();
        read.readLine();
        String line = read.readLine();
        while (line != null) {
            String[] da = line.split(",");
            dataFile.add(new Order(Integer.parseInt(da[0]), da[1], getClientById(Integer.parseInt(da[2]), clients)));
            line = read.readLine();
        }
        return dataFile;
    }

    private static Client getClientById(int idClient, List<Client> clients) {
        for (Client c : clients) {
            if (idClient == c.getClientId())
                return c;
        }
        return null;
    }


    private static Car getCarById(int idCar, List<Car> cars) {
        for (Car c : cars) {
            if (idCar == c.getCarId())
                return c;
        }
        return null;
    }
}