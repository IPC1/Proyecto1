package Reportes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;

import Clientes.Cliente;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Pdf_Tabla implements Serializable{
	public static String archivo=System.getProperty("user.dir")+"/Top10Clientes.pdf";
	
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
	 
	 public static PdfPTable tabla(){
		 	PdfPTable tabla = new PdfPTable(5);//Instanciamos una tabla de 3 columnas
		 	PdfPCell celda;//Declaramos un objeto para manejar las celdas
		    celda = new PdfPCell(new Phrase("NIT"));//Agregamos una frase a la celda
		    tabla.addCell(celda); //Agregamos la celda a la tabla
		    celda = new PdfPCell(new Phrase("Nombre"));//Agregamos una frase a la celda
		    tabla.addCell(celda); //agregamos la celta a la tabla
		 
		    //Rellenamos la tabla con m�s celdas.
		    //Las filas se crean autom�ticamente debido a que
		    //definimos 3 columnas m�s arriba.
		    //Al llegar a la tercera columna crea una nueva fila.
		    tabla.addCell("ID");
		    tabla.addCell("Direccion");
		    tabla.addCell("Referencia");
		    String ten= Cliente.clientes.OrdenarClientesDes();
		    String[] datos= ten.split(" ");
		    
		    for(int i=1;i< datos.length;i++){
		    	tabla.addCell(datos[i]);
		    }
		 
		    return tabla;
		  }
		    
		    

	 }

