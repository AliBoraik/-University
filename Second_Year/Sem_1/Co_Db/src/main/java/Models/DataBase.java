package Models;

public class DataBase {
    private String URL;
    private String UserName;
    private String Password;

    public DataBase(String URL) {
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
