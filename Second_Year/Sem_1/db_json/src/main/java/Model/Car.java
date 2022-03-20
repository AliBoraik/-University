package Model;

public class Car {
    private int carId;
    private String model;
    private String number;

    public Car(int carId, String model, String number) {
        this.carId = carId;
        this.model = model;
        this.number = number;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
