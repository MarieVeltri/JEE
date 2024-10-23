package be.veltri.serie01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exercice6
 */
@WebServlet("/Exercice6")
public class Exercice6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String[] possiblePath = {"1", "2", "3", "4", "5a", "5b"};
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exercice6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String number = request.getParameter("x");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.write("<html><head><title>Bienvenue dans la Série 1</title></head>" +
                  "<body><p>Paramètre exercice : </p>");
        
        if (number == null || number.length() <= 0) {
            out.write("non défini");
            out.write(generateLinks(request)); // Affiche les liens
        } else {
            out.write(number);
            if (!number.equals("1") && !number.equals("2") && !number.equals("3") && 
                !number.equals("4") && !number.equals("5a") && !number.equals("5b")) {
                out.write(generateLinks(request)); // Affiche les liens si le numéro n'est pas valide
            } else {
                String path = request.getContextPath() + "/Exercice" + number;
                out.println("<p><a href=\"" + path + "\">Exercice " + number + "</a></p>");
            }
        }
        
        out.write("</body></html>");
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String generateLinks(HttpServletRequest request) {
	    StringBuilder result = new StringBuilder();
	    
	    for (String path : possiblePath) {
	        result.append("<p><a href=\"").append(request.getContextPath()).append("/Exercice").append(path).append("\">Exercice ").append(path).append("</a></p>");
	    }
	    
	    return result.toString();
	}



}
