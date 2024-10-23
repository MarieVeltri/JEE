package be.veltri.servlets;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyImageServlet
 */
@WebServlet("/MyImageServlet")
public class MyImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ServletOutputStream out = null;
        
        response.setContentType("image/jpg");
        try(RandomAccessFile raf = new RandomAccessFile(new File(getServletContext().getRealPath(getServletContext().getInitParameter("condorcet_logo"))), "r" )){
            response.setContentLength( (int) raf.length());
            out = response.getOutputStream();
            byte[] data = new byte [(int)raf.length()];
            while((raf.read(data)) > 0){
            	out.write(data);
        	}
        }
        catch(Exception e) {
        	e.printStackTrace();
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