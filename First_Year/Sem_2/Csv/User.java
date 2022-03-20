package Csv;

public class User {
    private String gender;
    private int fav_number;

    public User(String gender, int fav_number) {
        this.gender = gender;
        this.fav_number = fav_number;
    }

    public User() {
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getFav_number() {
        return fav_number;
    }

    public void setFav_number(int fav_number) {
        this.fav_number = fav_number;
    }
}
