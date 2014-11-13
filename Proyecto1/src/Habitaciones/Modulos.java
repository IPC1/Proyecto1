package Habitaciones;

import java.util.Date;

import javax.swing.JOptionPane;

import Clientes.Cliente;
import Recepciones.Recepcion;



public class Modulos {
	Nodo_Habitaciones inicio;
	Nodo_Habitaciones fin;
	Modulos(){
		for(int j=1; j<18; j++){
			for (int i=1;i<8;i++){
				Nodo_Habitaciones temp= new Nodo_Habitaciones (null, null, "Sencilla", j, i, 0,1, Recepcion.nombre, inicio);
				inicio= temp;
			}
			for (int i=8;i<15;i++){
				Nodo_Habitaciones temp= new Nodo_Habitaciones (null, null, "Sencilla", j, i, 0,2,  Recepcion.nombre, inicio);
				inicio= temp;
			}
			for (int i=15;i<22;i++){
				Nodo_Habitaciones temp= new Nodo_Habitaciones (null, null, "Sencilla", j, i, 0,3,  Recepcion.nombre, inicio);
				inicio= temp;
			}
		}
	}

	
	public void CheckIn(int torre,int NoHabitacion, int Nit, int dias, Date fechaE, Date fechaS){
		Nodo_Habitaciones temp=inicio;
		while(torre!=temp.getTorre()){
			temp=temp.siguiente;
		}
		while (NoHabitacion!=temp.getHabitacion()){
			temp=temp.siguiente;
		}
		if (torre==temp.getTorre()){
			if(NoHabitacion==temp.getHabitacion()){
				temp.setNIT(Nit);
				temp.setFechaInicio(fechaE);
				temp.setFechaFin(fechaS);
				temp.setMonto(temp.getMonto()*dias);
				JOptionPane.showMessageDialog (null,"Habitacion Asignada");
			}
		}else JOptionPane.showMessageDialog (null,"Hubo erro al asignar habitacion");
	}	
	
	public void CheckOut(int torre,int NoHabitacion ){
		Nodo_Habitaciones temp=inicio;
		while(torre!=temp.getTorre()){
			temp=temp.siguiente;
		}
		while (NoHabitacion!=temp.getHabitacion()){
			temp=temp.siguiente;
		}
		if (torre==temp.getTorre()){
			if(NoHabitacion==temp.getHabitacion()){
				
				JOptionPane.showMessageDialog (null,"Cuenta:"+temp.getMonto());
				temp.setNIT(0);
				temp.setFechaInicio(null);
				temp.setFechaFin(null);
				if (temp.getTipoHabitacion()=="Sencilla")
					temp.setMonto(200);
				else if (temp.getTipoHabitacion()=="Regular")
					temp.setMonto(350);
				else if (temp.getTipoHabitacion()=="Exclusiva")
					temp.setMonto(500);
				JOptionPane.showMessageDialog (null,"Habitacion Desasignada");
			}
		}else JOptionPane.showMessageDialog (null,"Hubo erro al desasignar habitacion");
		
	}
	
	public int Nivel(int NoHabitacion, int torre){
		Nodo_Habitaciones temp=inicio;
		int nivel=0;
		while(torre!=temp.getTorre()){
			temp=temp.siguiente;
		}
		while (NoHabitacion!=temp.getHabitacion()){
			temp=temp.siguiente;
		}
		if (torre==temp.getTorre()){
			if(NoHabitacion==temp.getHabitacion()){
				nivel=temp.getNivel();
			}
		}else JOptionPane.showMessageDialog (null,"Error al buscar Nivel");
		
		return nivel;
	}
	
	public boolean Buscar(int nit){
		Nodo_Habitaciones temp=inicio;
		boolean b=false;
		while(temp!=null){	
		if(nit==temp.getNIT()){
			Especificaciones(temp.getHabitacion(), temp.getTorre());
			b= true;
			temp=temp.siguiente;
		}else{
			temp=temp.siguiente;
		}
		}return b;
				}
	
	public void Cuenta(int NoHabitacion, int torre){
		Nodo_Habitaciones temp=inicio;
		float nivel=0;
		while(torre!=temp.getTorre()){
			temp=temp.siguiente;
		}
		while (NoHabitacion!=temp.getHabitacion()){
			temp=temp.siguiente;
		}
		if (torre==temp.getTorre()){
			if(NoHabitacion==temp.getHabitacion()){
				nivel=temp.getMonto();
				JOptionPane.showMessageDialog (null,"Cuenta de la habitacion"+NoHabitacion+": "+nivel);
			}
		}else JOptionPane.showMessageDialog (null,"Error al buscar Cuenta");
		
	
	}
	
	public void Estado(int NoHabitacion, int torre){
		Nodo_Habitaciones temp=inicio;
		String estado=null;
		while(temp!=null){	
		if(torre==temp.getTorre()){
			if(NoHabitacion==temp.getHabitacion()){
				if(temp.getNIT()==0){
					estado="desocupada";
				}else{
					estado="ocupada";
				}
				JOptionPane.showMessageDialog (null,"Habitacion "+estado);
				break;
			}else{
				temp=temp.siguiente;
			}
		}else{
			temp=temp.siguiente;
		}
		}		
	}
	
		
	public void Especificaciones(int NoHabitacion, int torre){
		Nodo_Habitaciones temp=inicio;
		String nivel=null;
		String nl = System.getProperty("line.separator");
		while(torre!=temp.getTorre()){
			temp=temp.siguiente;
		}
		while (NoHabitacion!=temp.getHabitacion()){
			temp=temp.siguiente;
		}
		if (torre==temp.getTorre()){
			if(NoHabitacion==temp.getHabitacion()){
				if(temp.getNIT()==0)
					JOptionPane.showMessageDialog (null,"Habitacion del Hotel "+temp.getHotel()+
							nl+"Habitacion desocupada"+nl+
							"Tipo de Habitacion"+temp.getTipoHabitacion()+
							nl+"Ubicada en el modulo: "+temp.getTorre()+" Nivel:   "+temp.getNivel()+
							nl+"Con un costo de: "+temp.getMonto());
				else{
					JOptionPane.showMessageDialog (null,"Habitacion del Hotel "+temp.getHotel()+
							nl+"Tipo de Habitacion"+temp.getTipoHabitacion()+
							nl+"Ubicada en el modulo: "+temp.getTorre()+" Nivel: "+temp.getNivel()+
							nl+"Con un monto en la cuenta total de: "+temp.getMonto()+
							nl+"Ocupada por el cliente: "+Cliente.clientes.ObtenerString(temp.getNIT()));
				}
			}		
		}
		
	}

}
