import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/index")
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie ck : cookies) {
                if (ck.getName().equals("SessionID")) {
                    try {
                        sendToHomePage(request, response, ck);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return;
                }
            }
        }

        request.getRequestDispatcher("/index.html").forward(request, response);

    }

    public static void sendToHomePage(HttpServletRequest request, HttpServletResponse response, Cookie ck) throws SQLException, ServletException, IOException {
        Connection conn = DataBase.getConnection();

        try {
            Statement st = conn.createStatement();
            ResultSet result = st.executeQuery("select * from users where cookieid = '" + ck.getValue() + "';");
            //String[] attributes = new String[]{"First_Name", "Last_Name"};
            while (result.next()) {
                request.setAttribute("First_Name", result.getString(2));
                request.setAttribute("Last_Name", result.getString(3));
            }
            request.getRequestDispatcher("/Home.ftlh").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}