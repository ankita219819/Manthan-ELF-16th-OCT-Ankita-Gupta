import java.io.File;
import java.io.ObjectInputStream.GetField;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dir="C:\\Users\\bhaga\\OneDrive\\Desktop\\profile";
		File maindir= new File(dir);
		boolean flag=true;
		File fileName=null;
		

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
						String s[]= {"Pascal"};
						for(String skill: s) {
							System.out.println(fileText.contains(skill));
							if(fileText.contains(skill)) {
								
								//							System.out.println("\n\n\nfound");
								//							System.out.println(F.getName()+"-------"+F.getName().substring(F.getName().lastIndexOf(".")));
								fileName=F;
								System.out.println(fileName);
								flag=true;
							}
							else {
								flag=false;
								break;
							}

						}
						System.out.println(flag);
						if(flag) {
							System.out.println("\n\n\nfound");
							System.out.println(fileName.getName()+"-------"+fileName.getAbsolutePath());
						}
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		}

	}

}
