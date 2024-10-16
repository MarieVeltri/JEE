package be.veltri.servlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClientAuthentication
 */
public class ClientAuthenticationV1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientAuthenticationV1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 String username = "Marie";
         String password = "1234";
         
         String usernameParam = request.getParameter("username");
         String passwordParam = request.getParameter("password");
         
         response.setContentType("text/html");
         
         PrintWriter out = response.getWriter();
         
         if(request.getParameter("submit") != null)
         {
 	        if(usernameParam != null && usernameParam.equals(username)
 	                && passwordParam != null && passwordParam.equals(password)) {
 	            out.println("Authentification réussie. Bienvenue " + username);
 	        }else {
 	            out.println("Authentification incorrecte.");
 	        }
         }
         out.println("<!DOCTYPE html>");
         out.println("<html>");
         out.println("<head>");
         out.println("<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\">");
         out.println("<title></title>");
         out.println("</head>");
         out.println("<body>");
         out.println("<form action=\"ParameterReading\" method=\"get\">");
         out.println("<table border=\"0\">");
         out.println("<tbody>");
         out.println("<tr>");
         out.println("<td>Nom</td>");
         out.println("<td><input type=\"text\" name=\"lastname\" value=\"\" size=\"20\" /></td>");
         out.println("</tr>");
         out.println("<tr>");
         out.println("<td>Prénom</td>");
         out.println("<td><input type=\"text\" name=\"firstname\" value=\"\" size=\"20\" /></td>");
         out.println("</tr>");
         out.println("<td><input type=\"submit\" value=\"valider\" name=\"validation\" /></td>");
         out.println("</tr>");
         out.println("</tbody>");
         out.println("</table>");
         out.println("</form>");
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
