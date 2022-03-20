import Models.Car;
import Models.DataBase;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/index")
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {

            response.setHeader("Content-Type", "application/json");

            ObjectMapper mapper = new ObjectMapper();
            List<Car> lstCar = getCars();

            mapper.writeValue(response.getOutputStream(), lstCar);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<Car> getCars() throws SQLException {
        List<Car> cars = new ArrayList<>();
        Connection conn = DataBase.getConnection();

        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select cars.id,cars.name,cars.model,cars.carnumber from cars");

            while (rs.next()) {
                //получение данных из очередной строки результата;
                cars.add(new Car(rs.getLong("id"),
                        rs.getString("name")
                        , rs.getString("model"),
                        rs.getString("carnumber")));

            }
            rs.close();
            statement.close();

            return cars;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}