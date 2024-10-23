package be.veltri.servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpResponseStatusCode
 */
@WebServlet("/HttpResponseStatusCode")
public class HttpResponseStatusCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HttpResponseStatusCode() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	try 
    	{
    		response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE, "Une surcharge empêche le serveur de traiter la requête.");
    	}
    	finally
    	{
    		out.close();
    	}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
