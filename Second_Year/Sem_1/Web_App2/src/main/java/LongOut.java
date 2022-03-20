import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/longOut")
public class LongOut extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        Cookie ck = new Cookie("SessionID", "");
        ck.setMaxAge(0);
        httpServletResponse.addCookie(ck);
       // httpServletResponse.sendRedirect();
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/Home");

        

        httpServletRequest.getRequestDispatcher("/index.html").forward(httpServletRequest, httpServletResponse);
    }

    private <T> void  Redirect(String path ,Package c){

    }

}