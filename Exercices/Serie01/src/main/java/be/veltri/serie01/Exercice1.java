package be.veltri.serie01;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exercice1
 */
@WebServlet("/Exercice1")
public class Exercice1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exercice1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String exerciceParam = request.getParameter("exercice");
        
        //http://localhost:8080/Serie01/Exercice1?exercice=1

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String paragraphe;
        if (exerciceParam != null && !exerciceParam.isEmpty()) {
            paragraphe = "Paramètre exercice : " + exerciceParam;
        } else {
            paragraphe = "Paramètre exercice : non défini.";
        }

       
        out.write("<html><head><title>Bienvenue</title></head>"
                + "<body><h1>Bienvenue dans la Série 1</h1>"
                + "<p>" + paragraphe + "</p>"
                + "</body></html>");

        out.close();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
