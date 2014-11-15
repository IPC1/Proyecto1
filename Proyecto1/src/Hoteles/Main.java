package Hoteles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
 static Hotel hotel =new Hotel();

	public static void main(String[] args) {
		 try{
	         FileInputStream fis = new FileInputStream("Hotel.ser");
	         ObjectInputStream ois = new ObjectInputStream(fis);
	         hotel = (Hotel) ois.readObject();//El método readObject() recupera el objeto
	         ois.close();
	      }catch(FileNotFoundException e){
	         e.printStackTrace();
	      }catch(IOException e){
	         e.printStackTrace();
	      }catch(ClassNotFoundException e){
	         e.printStackTrace();
	      }
		
		try{
	         FileOutputStream fs = new FileOutputStream("Hotel.ser");//Creamos el archivo
	         ObjectOutputStream os = new ObjectOutputStream(fs);//Esta clase tiene el método writeObject() que necesitamos
	         os.writeObject(hotel);//El método writeObject() serializa el objeto y lo escribe en el archivo
	         os.close();//Hay que cerrar siempre el archivo
	      }catch(FileNotFoundException e){
	         e.printStackTrace();
	      }catch(IOException e){
	         e.printStackTrace();
	      }
	     
			
	}
/*	public static void leer(Hotel hotel){
		try {
					fis = new FileInputStream("Hotel.ser");
					ObjectInputStream ois = new ObjectInputStream(fis);
					hotel = (Hotel) ois.readObject();//El método readObject() recupera el objeto
					ois.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				hotel.setVisible(true);
	}
		public static void grabar(Hotel hotel){
			try {	        
				fs = new FileOutputStream("Hotel.ser");//Creamos el archivo
				os = new ObjectOutputStream(fs);
				os.writeObject(hotel);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
}
