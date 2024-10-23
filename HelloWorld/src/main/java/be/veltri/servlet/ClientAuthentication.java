package be.veltri.servlet;

import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.veltri.servlet.Client;

public class ClientAuthentication extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String username = null;
    private String password = null;
    private String adminEmail = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        username = config.getInitParameter("username");
        password = config.getInitParameter("password");
        
        ServletContext context = getServletContext();
        adminEmail = context.getInitParameter("adminEmail");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usernameParam = request.getParameter("username");
        String passwordParam = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Login</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action=\"ClientAuthentication\" method=\"get\">");
        out.println("<table>");
        out.println("<tr><td>Username:</td><td><input type=\"text\" name=\"username\"></td></tr>");
        out.println("<tr><td>Password:</td><td><input type=\"password\" name=\"password\"></td></tr>");
        out.println("<tr><td><input type=\"submit\" value=\"Submit\" name=\"submit\"></td></tr>");
        out.println("</table>");
        out.println("</form>");

        if (request.getParameter("submit") != null) {
            if (usernameParam != null && usernameParam.equals(username)
                    && passwordParam != null && passwordParam.equals(password)) {
                out.println("Authentification réussie. Bienvenue " + username + "!");
                
                // Créer un objet JavaBean et l'enregistrer dans le contexte de l'application
                Client client = new Client(usernameParam, adminEmail);
                ServletContext context = getServletContext();
                context.setAttribute("client", client);
                
                response.sendRedirect("authenticationSuccess.html");


            } else {
                out.println("Authentification incorrecte.");
                out.println("Veuillez contacter l'administrateur à : " + adminEmail);
            }
        }

        out.println("</body>");
        out.println("</html>");
    }
}
