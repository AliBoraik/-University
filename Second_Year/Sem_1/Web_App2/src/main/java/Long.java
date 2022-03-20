import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.UUID;

@WebServlet(urlPatterns = {"/login", "/signup"})
public class Long extends HttpServlet {
    private Cookie cookie;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if (!hasCookie(request)) {

            Connection conn = DataBase.getConnection();

            try {
                // get parameters
                String email = request.getParameter("Email");
                String pass = request.getParameter("Pass");

                Statement st = conn.createStatement();
                // check path
                if (request.getServletPath().equals("/login")) {
                    // check if user exit in database ..
                    if (checkUser(email, pass, st)) {
                        ResultSet result = st.executeQuery("select * from users where email = '" + email + "';");
                        while (result.next()) {
                            request.setAttribute("First_Name", result.getString(2));
                            request.setAttribute("Last_Name", result.getString(3));
                        }
                        String SessionID = setCookie(response);
                        // for chang cookie_id into database
                        sendNewCookieID(email,SessionID,st);
                        request.getRequestDispatcher("/Home.ftlh").forward(request, response);
                    } else {
                        request.getRequestDispatcher("/NotFoundUser.html").forward(request, response);
                    }
                    // path = \signup
                } else {
                    String first_name = request.getParameter("First_Name");
                    String last_name = request.getParameter("Last_Name");
                    if (first_name != null || last_name != null){

                        String cookie = setCookie(response);
                        insertToDataBase(first_name, last_name, email, pass, cookie, st);
                        // home page has two Attribute  First_Name and Last_Name
                        request.setAttribute("First_Name", first_name);
                        request.setAttribute("Last_Name", last_name);
                        request.getRequestDispatcher("/Home.ftlh").forward(request, response);
                    }else {
                        request.getRequestDispatcher("/NotFoundUser.html").forward(request, response);
                    }
                }
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Home.sendToHomePage(request, response, cookie);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendNewCookieID(String email, String sessionID, Statement st) throws SQLException {
        st.executeUpdate("UPDATE users SET cookieid = '"+sessionID+"' WHERE email = '"+email+"';");
    }

    private boolean hasCookie(HttpServletRequest request) {
        if (request.getCookies() != null) {
            for (Cookie ck : request.getCookies()) {
                if (ck.getName().equals("SessionID")) {
                    cookie = ck;
                    return true;
                }
            }
        }
        return false;
    }

    private String setCookie(HttpServletResponse response) {
        String SessionID = UUID.randomUUID().toString();
        Cookie ck = new Cookie("SessionID", SessionID);
        ck.setMaxAge(600);
        response.addCookie(ck);
        return SessionID;
    }

    private void insertToDataBase(String first_name, String last_name, String email, String pass, String cookie, Statement st) throws SQLException {
        st.executeUpdate("insert into users (first_name, last_name, email, password,cookieid)" +
                " values ('" + first_name + "','" + last_name + "','" + email + "','" + pass + "','" + cookie + "')");
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        doGet(httpServletRequest, httpServletResponse);
    }

    private boolean checkUser(String email, String pass, Statement st) throws SQLException {
        ResultSet e = st.executeQuery("select exists(select email,password from users where email = '" + email + "' and password = '" + pass + "');");
        e.next();
        return e.getString(1).equals("t");
    }
}