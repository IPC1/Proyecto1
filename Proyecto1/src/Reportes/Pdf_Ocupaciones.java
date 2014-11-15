package Reportes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Pdf_Ocupaciones {
	public static String archivo=System.getProperty("user.dir")+"/Reservaciones.pdf";
	 public void createPdf(){
		 Document documento = new Document(PageSize.LETTER, 80, 80, 75, 75);
		 PdfWriter writer = null;
		 try {
			writer = PdfWriter.getInstance(documento, new FileOutputStream(archivo));
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 documento.addTitle("Archivo Clientes");
		 documento.addAuthor("Pau");
		 documento.open();  
		 
		 Paragraph parrafo = new Paragraph();
		    parrafo.setAlignment(Paragraph.ALIGN_CENTER);
		    parrafo.setFont(FontFactory.getFont("Sans",20,Font.BOLD, BaseColor.BLUE));
		    parrafo.add("Top Ten Clientes");
		    		    try {
				documento.add(parrafo);
				 documento.add(tabla());
				 
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    documento.close(); 
		    writer.close();
	 }

}
