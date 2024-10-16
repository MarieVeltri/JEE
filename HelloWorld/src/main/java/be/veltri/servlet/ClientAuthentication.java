package be.veltri.servlet;

import java.io.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientAuthentication extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String username = null;
    private String password = null;
    private String adminEmail = null;
    
    public ClientAuthentication() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        ServletConfig config = getServletConfig();
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
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\">");
        out.println("<title>Login</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<form action=\"ClientAuthentication\" method=\"get\">"); 
        out.println("<table border=\"0\">");
        out.println("<tbody>");
        out.println("<tr>");
        out.println("<td>Username</td>");
        out.println("<td><input type=\"text\" name=\"username\" size=\"20\" /></td>");  
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Password</td>");
        out.println("<td><input type=\"password\" name=\"password\" size=\"20\" /></td>");  
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td><input type=\"submit\" value=\"Submit\" name=\"submit\" /></td>");  
        out.println("</tr>");
        out.println("</tbody>");
        out.println("</table>");
        out.println("</form>");

        if (request.getParameter("submit") != null) {
            if (usernameParam != null && usernameParam.equals(username)
                    && passwordParam != null && passwordParam.equals(password)) {
                out.println("<p>Authentification réussie. Bienvenue " + username + "!</p>");
            } else {
                out.println("<p>Authentification incorrecte.</p>");
                out.println("<p>Veuillez contacter l'administrateur à : " + adminEmail + "</p>");
            }
        }

        out.println("</body>");
        out.println("</html>");
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
    }
}
