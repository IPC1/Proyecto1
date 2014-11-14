package Habitaciones;

import java.util.Date;

public class Prueba {

	public void prueba(){
		Lista_Fecha f= new Lista_Fecha();
		@SuppressWarnings("deprecation")
		Date a= new Date(9,9,2014);
		Date b= new Date(9,9,2014);
		String casa="casa";
		String valor= "casa";
		if(a==b){
			System.out.println("Son iguales");
			
		}else{
			System.out.println("No son iguales");
		}
		if(casa==valor){
			System.out.println("Son iguales");
			
		}else{
			System.out.println("No son iguales");
		}
		
		f.Agregar(a);
		
		if(f.Buscar(b)){
			System.out.println("Paula hola que tal...");
		}
		
	}
}
