package ru.itis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet("/index")
public class IndexHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {

            PrintWriter out = httpServletResponse.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Yahoo!!!!!!!!</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("My First Servlet");
            out.println("</body>");
            out.println("</html>");

    }
}
