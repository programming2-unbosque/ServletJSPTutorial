package co.edu.unbosque.servletjsptutorial;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "login", value = "/login")
public class LogInServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello, ";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("fabiancpl") && password.equals("123456")) {
            /*message += username + "!";

            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + message + "</h1>");
            out.println("</body></html>");*/

            request.setAttribute("role", "admin");

            try {
                RequestDispatcher dispatcher = request.getRequestDispatcher("./home.jsp");
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("Unauthorized");
            response.sendRedirect("./401.html");
        }
    }

    public void destroy() {
    }
}