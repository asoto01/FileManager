package filemanager;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;



/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUpload() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
		
		// Create dummy data
		ArrayList<Files> fileEntries = new ArrayList<Files>();
		
		// Persist this data to the servlet context
		getServletContext().setAttribute("file", fileEntries);
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher( "/WEB-INF/FileUploaded.jsp" ).forward(
	            request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		File root_directory = new File(request.getServletContext().getRealPath("/"));  //grab the root directory of the file and save it 
		root_directory = root_directory.getParentFile(); 
		String filePath = root_directory.toString()+"//cs3220stuxx//file_uploads//";
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		List items=null;
		try
		 {
			items = upload.parseRequest(new ServletRequestContext(request));
		} catch (FileUploadException e) 
		{
			e.printStackTrace();
		}
		Iterator itr = items.iterator();
		while (itr.hasNext())
		 {
		FileItem item = (FileItem)(itr.next()); //type case file item for the iterator
			if (item.isFormField())  //if the item is in a form
			{
				try{
				String field=item.getFieldName();
				String value=item.getString();
				//System.out.println("field="+value);
				}
				catch(Exception e)
				{
					System.out.println("Exception "+ e); //print exception if there is an error		
				}
			}  
			else {
				try
				 {
				String itemName = item.getName(); //get the name of the file 
				//System.out.println("\n FileName: "+itemName); //this checks to see if the file was uploaded correctly with the correct name 
				File savedFile = new File(filePath+itemName); //save the file into the object class with the file path and name 
				Files fileOb = new Files(itemName,filePath+ itemName); //make a new file object with the file name 
				item.write(savedFile);
		        ArrayList<Files> file = (ArrayList<Files>) getServletContext().getAttribute(
		            "file" );
		        file.add(fileOb);
		        
		        
				response.sendRedirect("FileUpload"); //send to file display page
				} 
				catch (Exception e) 
				{
				e.printStackTrace();
				}
			}
		}
	}//end of doPost


	
}
