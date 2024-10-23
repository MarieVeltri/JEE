package be.veltri.serie01;

import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exercice4
 */

public class Exercice4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private FileInputStream fileInputStream;
    private String FILE_OPEN = "";
    
    private boolean openFile(String file_path) {
		FILE_OPEN = file_path;
		System.out.println("===> file opened at path : " + file_path);
		return true;
	}

    private boolean closeFile() {
        FILE_OPEN = "";
        System.out.println("===> file closed");
        return false;
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exercice4() {
        super();
    }
    
	/**
	 * @see Servlet#init(ServletConfig)
	 */
    @Override
    public void init() throws ServletException {
        super.init();
        String filePath = getInitParameter("file_path");
        
        if(filePath != null && !filePath.isEmpty()) {
            openFile(filePath);
        } else {
            throw new ServletException("filePath not found");
        }
    }

	/**
	 * @see Servlet#destroy()
	 */
    @Override
	public void destroy() {
		closeFile(); 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	     response.getWriter().println("<html><head><title>Exercice 4</title></head>");
	     response.getWriter().println("<body><h1>Exercice 4</h1><p>Le fichier a été ouvert et fermé correctement.</p></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
