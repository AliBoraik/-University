import Models.DataBase;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDataWithLib {
    public static void main(String[] args) {

        DataBase db = new DataBase("jdbc:postgresql://127.0.0.1:5432/uber_db");
        db.setUserName("ali");
        db.setPassword("testpass");

        try (Connection conn = DriverManager.getConnection(db.getURL(), db.getUserName(), db.getPassword())) {
            ScriptRunner sr = new ScriptRunner(conn);

            createTablesScript(sr);

        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private static void createTablesScript(ScriptRunner sr) throws FileNotFoundException {
        //Creating a reader object
        Reader reader = new BufferedReader(new FileReader("src/main/java/SQL/uberDB.sql"));
        //Running the script
        sr.runScript(reader);

    }

}
