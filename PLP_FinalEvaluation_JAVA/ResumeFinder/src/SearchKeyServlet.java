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

@WebServlet("/SearchKey")
public class SearchKeyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ResumeBean resumeBean=null;
		ArrayList<ResumeBean> arrayList=new ArrayList<ResumeBean>();
		String dir="C:\\Users\\bhaga\\OneDrive\\Desktop\\profile";
		File maindir= new File(dir);
		boolean flag=true;
		File fileName=null;
		String input=req.getParameter("input").trim();
		String skills;


		if(maindir.exists()&& maindir.isDirectory()) {
			File arr[]= maindir.listFiles();
			for(File F: arr) {
				if(F.isFile()&& F.getName().substring(F.getName().lastIndexOf(".")).equals(".pdf") ) {
					//System.out.println(F.getName()+"-------"+F.getName().substring(F.getName().lastIndexOf(".")));
					try {
						PDDocument document = PDDocument.load(F);

						PDFTextStripper pdfStripper = new PDFTextStripper();

						String text = pdfStripper.getText(document);

						String fileText=text.replace("\n", " ").replace("\r", " ");
						String s[]= input.split(",");
						if(!input.isEmpty()) {
						for(String skill: s) {
							
							if(fileText.toLowerCase().contains(skill.toLowerCase())) {
								fileName=F;
								flag=true;
							}
							else {
								flag=false;
								break;
							}

						}
					}
						else {
							flag=false;
						}
						if(flag) {
							resumeBean=new ResumeBean();
							String fileID="no";
							Pattern pattern = Pattern.compile("([a-z0-9_.-]+)@([a-z0-9_.-]+[a-z])");
							Matcher matcher = pattern.matcher(fileText);
							if (matcher.find( )) {
								fileID= matcher.group();
								}
							resumeBean.setFileName(fileName.getName());
							resumeBean.setFileID(fileID);
							resumeBean.setFilePath(fileName.getAbsolutePath());
							//if(resumeBean!=null)
							arrayList.add(resumeBean);
							//System.out.println("\n\n\nfound");
							//System.out.println(fileName.getName()+"\n"+fileName.getAbsolutePath()+"\n"+fileID);
						}
						//Closing the document
						document.close();
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}

		}
		req.setAttribute("resumeBean", arrayList);
		req.getRequestDispatcher("/Display.jsp").forward(req, resp);
	}
}
