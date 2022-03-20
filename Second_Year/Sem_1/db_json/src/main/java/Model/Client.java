package Model;

public class Client {
    private int clientId;
    private String name;
    private String phone;


    public Client(int clientId, String name, String phone) {
        this.clientId = clientId;
        this.name = name;
        this.phone = phone;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
