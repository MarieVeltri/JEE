package be.veltri.servlets;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

/**
 * Servlet implementation class MyBinaryServlet
 */
public class MyBinaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyBinaryServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get an image if exists
		Image image = null;

		ServletContext context = getServletContext();
		String imagePath = context.getInitParameter("condorcet_logo");
		imagePath = context.getRealPath(imagePath);

		if(imagePath != null) {
			File source = new File(imagePath);
			if(source.exists()) {
				//Get the image
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				image = toolkit.getImage(imagePath);
				
				//Transform image into BufferedImage
				image = new ImageIcon(image).getImage();
				BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
				Graphics2D g2 = bufferedImage.createGraphics();
				g2.drawImage(image, 0, 0, null);
				g2.dispose();
				
				//Output image in the browser
				response.reset();
				response.setContentType("image/png");
				response.setHeader("Pragma","no-cache");
	            response.setHeader("Cache-Control","no-cache");
	            response.setDateHeader("Expires",0);
	            response.setHeader("Content-Disposition","filename=\"myimage\"");
	            
	            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()){
	            	ImageIO.write(bufferedImage, "png", outputStream);
	            	outputStream.writeTo(response.getOutputStream());
	            }
	            finally {
	            	if(bufferedImage != null) bufferedImage = null;
	            }
			}
			else {
				System.out.println("Image not found!");
			}
		}
		else {
			System.out.println("condorcet_logo init parameter not found!");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
