import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/uploadServlet")
public class UploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		File file ;
		PrintWriter out= resp.getWriter();
		int maxFileSize = 50000 * 1024;
		int maxMemSize = 50000 * 1024;
		//ServletContext context = pageContext.getServletContext();
		String filePath = getServletContext().getInitParameter("file-upload");

		// Verify the content type
		String contentType = req.getContentType();

		if ((contentType.indexOf("multipart/form-data") >= 0)) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// maximum size that will be stored in memory
			factory.setSizeThreshold(maxMemSize);

			// Location to save data that is larger than maxMemSize.
			factory.setRepository(new File("c:\\temp"));

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			// maximum file size to be uploaded.
			upload.setSizeMax( maxFileSize );

			try { 
				// Parse the request to get file items.
				List fileItems = upload.parseRequest(req);

				// Process the uploaded file items
				Iterator i = fileItems.iterator();


				while ( i.hasNext () ) {
					FileItem fi = (FileItem)i.next();
					if ( !fi.isFormField () ) {
						// Get the uploaded file parameters
						String fieldName = fi.getFieldName();
						String fileName = fi.getName();
						// String[] f= fileName.split("\\");
						boolean isInMemory = fi.isInMemory();
						long sizeInBytes = fi.getSize();
						System.out.println(fileName.substring( fileName.lastIndexOf("\\")+1)+" \n"+fieldName+"\n ");

						// Write the file
						if( fileName.lastIndexOf("\\") >= 0 ) {
							file = new File( filePath + 
									fileName.substring( fileName.lastIndexOf("\\"))) ;
						} else {
							file = new File( filePath + 
									fileName.substring(fileName.lastIndexOf("\\")+1)) ;
						}
						fi.write( file ) ;
						System.out.println("Uploaded Filename: " + filePath + " "+
								fileName.substring(fileName.lastIndexOf("\\")+1) + "<br>");
					}
				}
				req.setAttribute("lmsg", "File uploaded successfully");
				req.getRequestDispatcher("/upload-file").forward(req, resp);
			} catch(Exception ex) {
				// System.out.println(ex);
				req.setAttribute("msg", "No file selected");
				req.getRequestDispatcher("/upload-file").forward(req, resp);
			}
		} else {
			req.setAttribute("msg", "Unable to upload file");
			req.getRequestDispatcher("/upload-file").forward(req, resp);
		}

	}
}
