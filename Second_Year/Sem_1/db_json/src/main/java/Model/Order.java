package Model;

import java.util.Date;

public class Order {
    private int orderId;
    private String date;
    private Client client;


    public Order(int orderId, String date, Client client) {
        this.orderId = orderId;
        this.date = date;
        this.client = client;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
