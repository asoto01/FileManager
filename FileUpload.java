package filemanager;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

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
		String filePath = "";
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		File root_directory = new File(request.getSession().getServletContext().getRealPath("/")); 
		root_directory = root_directory.getParentFile();
		filePath = root_directory.toString()+"//Your_Desired_Folder//file_uploads//";
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
		FileItem item = (FileItem)(itr.next());
			if (item.isFormField()) 
			{
				try{
				String field=item.getFieldName();
				String value=item.getString();
				System.out.println("field="+value);
				}
				catch(Exception e)
				{
					System.out.println("Exception "+e);		
				}
			} 
			else {
				try
				 {
				
				String itemName = item.getName();
				System.out.println("\n FileName: "+itemName);
				File savedFile = new File(filePath+itemName);
				System.out.println(savedFile);
				System.out.println("done");
				} 
				catch (Exception e) 
				{
				e.printStackTrace();
				}
			}
		}
	}//end of doPost


	
}
