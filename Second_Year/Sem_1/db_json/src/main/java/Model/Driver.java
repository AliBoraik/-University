package Model;

public class Driver {
    private int driveId;
    private String phone;
    private String name;
    private Car car;

    public Driver(int driveId, String phone, String name, Car car) {
        this.driveId = driveId;
        this.phone = phone;
        this.name = name;
        this.car = car;
    }

    public int getDriveId() {
        return driveId;
    }

    public void setDriveId(int driveId) {
        this.driveId = driveId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
