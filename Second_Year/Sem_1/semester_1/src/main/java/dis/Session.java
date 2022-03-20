package dis;

import java.util.HashMap;
import java.util.Map;

public class Session {

    private String First_Name;
    private String Last_Name;
    private String Email_Address;
    private String Password;


    public Session() {
    }

    public String getFirst_Name() {
        return First_Name;
    }
    public void setValues(String line){

        String[] prams = line.split("&");
        if (prams.length == 2)
        {
            // Email=
            Email_Address = prams[0].substring(6);
            // Pass=
            Password = prams[1].substring(5);
        }else {
            // First_Name
            First_Name = prams[0].substring(11);
            Last_Name = prams[1].substring(10);
            Email_Address = prams[2].substring(6);
            Password = prams[3].substring(5);

        }

    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public String getEmail_Address() {
        return Email_Address;
    }

    public void setEmail_Address(String email_Address) {
        Email_Address = email_Address;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
