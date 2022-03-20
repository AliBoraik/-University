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
import java.sql.Statement;

@WebServlet("/car")
public class CarController extends HttpServlet {

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Car car = mapper.readValue(request.getInputStream(), Car.class);
            if (car != null) {
                //TODO insert car to db

                insertCar(car);

            }

        } catch (IOException e) {
           response.sendError(500,e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String car_id = request.getParameter("car_id");
        deleteCar(car_id);
        request.getRequestDispatcher("index").forward(request,response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String car_id = request.getParameter("car_id");
        deleteCar(car_id);
    }

    private void deleteCar(String car_id){
        try {
            Connection conn = DataBase.getConnection();

            Statement st = conn.createStatement();
            if (car_id != null) {
                st.executeUpdate("delete from cars where id="+car_id+";");
            }


        } catch (Exception ignored) {
            System.out.println(ignored.getMessage());
        }
    }

    private void insertCar(Car car) {
        try {
            Connection conn = DataBase.getConnection();

            Statement st = conn.createStatement();
            if (car.getCar_Id() != null) {
                st.executeUpdate("insert into cars(id, name, model, carnumber)" +
                        " values ('" + car.getCar_Id() + "','" + car.getName() + "','" + car.getModel() + "','" + car.getCarNumber()+ "')");
            }else {
                st.executeUpdate("insert into cars(name, model, carnumber)" +
                        " values ('" +car.getName() + "','" + car.getModel() + "','" + car.getCarNumber()+ "')");

            }


        } catch (Exception ignored) {
            System.out.println(ignored.getMessage());
        }
    }

}
