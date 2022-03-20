package Model;

import java.util.List;

public class DB {
    private List<Car> cars;
    private List<Client> clients;
    private List<Driver> drives;
    private List<Order> orders;

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Driver> getDrives() {
        return drives;
    }

    public void setDrives(List<Driver> drives) {
        this.drives = drives;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
