import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.manthan.resume.Bean.ResumeBean;

@WebServlet("/searchServlet")
public class SearchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String input=req.getParameter("input");
		ResumeBean resumeBean=null;
		ArrayList<ResumeBean> arrayList=new ArrayList<ResumeBean>();
		/*1*/String dir="C:\\Users\\bhaga\\OneDrive\\Desktop\\profile";
		/*2*/File maindir= new File(dir);
		/*3*/if(maindir.exists()&& maindir.isDirectory()) {
			File arr[]= maindir.listFiles();
			for(File F: arr) {
				if(F.isFile()&&F.getName().substring(F.getName().lastIndexOf(".")).equals(".pdf")) {


					PDDocument document = PDDocument.load(F);

					//System.out.println(F);
					//Instantiate PDFTextStripper class
					PDFTextStripper pdfStripper = new PDFTextStripper();

					//Retrieving text from PDF document
					String text = pdfStripper.getText(document);
					// System.out.println(text);
					String fileText=text.replace("\n", " ").replace("\r", " ");
					String[] textArr=text.split("\\r?\\n");
					for(String s:textArr)
					{
						//System.out.println(m.group());
						
							if(s.contains(input)) {
								resumeBean=new ResumeBean();
								String fileID="no";
								Pattern pattern = Pattern.compile("([a-z0-9_.-]+)@([a-z0-9_.-]+[a-z])");
								Matcher matcher = pattern.matcher(fileText);
								if (matcher.find( )) {
									fileID= matcher.group();}
								System.out.println("\n\n\nfound");
								System.out.println(fileID+" "+F.getAbsolutePath()+""+F.getName()+"-------"+F.getName().substring(F.getName().lastIndexOf(".")));
								resumeBean.setFileName(F.getName());
								resumeBean.setFileID(fileID);
								resumeBean.setFilePath(F.getAbsolutePath());
								arrayList.add(resumeBean);
								break;
							}
							
						
					}


					//Closing the document
					document.close();

				}
			}

		}
		req.setAttribute("resumeBean", arrayList);
		req.getRequestDispatcher("/Display.jsp").forward(req, resp);
		//Loading an existing document
		//	      File file = new File("C:\\Users\\bhaga\\OneDrive\\Desktop\\exe1.pdf");
		//	      PDDocument document = PDDocument.load(file);
		//
		//	      System.out.println(file);
		//	      //Instantiate PDFTextStripper class
		//	      PDFTextStripper pdfStripper = new PDFTextStripper();
		//
		//	      //Retrieving text from PDF document
		//	      String text = pdfStripper.getText(document);
		//	     // System.out.println(text);
		//	      String Email;
		//	      String[] textArr=text.split("\\r?\\n");
		//	      for(String s:textArr)
		//	      {
		//	    	  Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(s);
		//	    	  while (m.find()) {
		//	    		  Email=m.group();
		//	    	        System.out.println(m.group());
		//	    	    }  
		//	      if(s.contains(input)) {
		//	    	  System.out.println("\n\n\nfound");
		//	    	  break;
		//	      }
		//	      else 
		//	    	  System.out.println("nothing found");
		//	      }
		//
		//	      //Closing the document
		//	      document.close();


	}
}
