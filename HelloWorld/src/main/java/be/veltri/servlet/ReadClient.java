package be.veltri.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import be.veltri.servlet.Client;


public class ReadClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ReadClient() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ServletContext context = getServletContext();
        Client client = (Client) context.getAttribute("client");

        if (client != null) {
            out.println("<h1>Informations du client</h1>");
            out.println("<p>Username: " + client.getUsername() + "</p>");
            out.println("<p>Email: " + client.getEmail() + "</p>");
        } else {
            out.println("<p>Aucun client n'est actuellement authentifié.</p>");
        }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}