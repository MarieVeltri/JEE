package be.veltri.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParameterReading
 */
@WebServlet("/ParameterReading")
public class ParameterReading extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParameterReading() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	String parameterName = null;
    	String[] parameterValues = null;
    	Iterator<String> iterator;
    	
    	try {
    		out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet lecture de paramètres</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<hr>");
            
            // get unique parameters by their name
            out.println("nom : ");
            out.println(request.getParameter("lastname"));
            out.println("<br>");
            out.println("prénom : ");
            out.println(request.getParameter("firstname"));
            out.println("<br>");
           
            // get parameter multiple values
            String[] hobbies=null;
            hobbies=request.getParameterValues("hobbies");
            if(hobbies != null) {
            	out.println("loisirs :");
                for(String hobby:hobbies)
                {
                	out.println(hobby + " ");
            	}
                out.println("<hr>");
            }
            out.println("<br>");
            
           // get parameter names
            Enumeration<String> parameters=null;
            out.println("liste des noms de paramètres");
            out.println("<br>");
            parameters=request.getParameterNames();
            while (parameters.hasMoreElements())
            {
            	out.println(parameters.nextElement());
            }
            out.println("<hr>");
            out.println("<br>");
            
            // get parameter names and values
            out.println("liste des paramètres sans connaitre le nom");
            out.println("<br>");
            
            // get iterator based on keys (parameter names)
            iterator=request.getParameterMap().keySet().iterator();
            while(iterator.hasNext())
            {
            	parameterName=(String)iterator.next();
                out.println("nom du parametre : ");
                out.println(parameterName);
                out.println(" valeurs du parametre :");
                parameterValues=(String[])request.getParameterMap().get(parameterName);
                for(String parameterValue:parameterValues)
                {
                    out.println(parameterValue);
                    out.println(";");
                }
                out.println("<br>");
            }
    	}
    	finally {
    		out.close();
    	}
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
