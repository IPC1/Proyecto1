package Habitaciones;

import java.util.Date;

import javax.swing.JOptionPane;

import Clientes.Cliente;
import Clientes.Nodo_Clientes;
import Recepciones.Recepcion;


public class Torres {
	Nodo_Habitaciones inicio;
	Nodo_Habitaciones fin;
	Torres(){
		inicio=new Nodo_Habitaciones (null, null, "Sencilla", 1, 1, 0,1, Recepcion.nombre, inicio);
		for (int i=2;i<12; i++){
			Nodo_Habitaciones temp= new Nodo_Habitaciones (null, null, "Sencilla", 1, i, 0,1,  Recepcion.nombre, inicio);
			inicio= temp;
		}
		for (int i=12;i<24;i++){
			Nodo_Habitaciones temp= new Nodo_Habitaciones (null, null, "Sencilla", 1, i, 0,1,  Recepcion.nombre, inicio);
			inicio= temp;
		}
		for (int i=24;i<38;i++){
			Nodo_Habitaciones temp= new Nodo_Habitaciones (null, null, "Regular", 1, i, 0,3, Recepcion.nombre, inicio);
			inicio= temp;
		}
		for (int i=38;i<50;i++){
			Nodo_Habitaciones temp= new Nodo_Habitaciones (null, null, "Regular", 1, i, 0,4, Recepcion.nombre, inicio);
			inicio= temp;
		}
		for (int i=50;i<62;i++){
			Nodo_Habitaciones temp= new Nodo_Habitaciones (null, null, "Exclusiva", 1, i, 0,5,  Recepcion.nombre, inicio);
			inicio= temp;
		}for (int i=62;i<73;i++){
			Nodo_Habitaciones temp= new Nodo_Habitaciones (null, null, "Exclusiva", 1, i, 0,5,  Recepcion.nombre, inicio);
			inicio= temp;
		}
		
		for (int i=1;i<18;i++){
			Nodo_Habitaciones temp= new Nodo_Habitaciones (null, null, "Sencilla", 2, i, 0,1,  Recepcion.nombre, inicio);
			inicio= temp;
		}
		for (int i=18;i<37;i++){
			Nodo_Habitaciones temp= new Nodo_Habitaciones (null, null, "Regular", 2, i, 0,2,  Recepcion.nombre,  inicio);
			inicio= temp;
		}
		for (int i=37;i<54;i++){
			Nodo_Habitaciones temp= new Nodo_Habitaciones (null, null, "Exclusiva", 2, i, 0,3,  Recepcion.nombre, inicio);
			inicio= temp;
		}
		for (int i=54;i<72;i++){
			Nodo_Habitaciones temp= new Nodo_Habitaciones (null, null, "Exclusiva", 2, i, 0,3,  Recepcion.nombre, inicio);
			inicio= temp;
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
				int i=temp.getContador()+1;
				temp.setContador(i);
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
	public void AgregarCuenta(int NoHabitacion, int torre, float monto){
		Nodo_Habitaciones temp=inicio;
		float nivel;
		while(temp!=null){
			if (torre==temp.getTorre()){
			if(NoHabitacion==temp.getHabitacion()){
				if(temp.getNIT()==0){
					JOptionPane.showMessageDialog (null,"Habitacion desocupada");
					break;
				}else{
					Cuenta(NoHabitacion,torre);
					nivel=temp.getMonto();
					nivel+=monto;
					temp.setMonto(nivel);
					JOptionPane.showMessageDialog (null,"Cuenta de la habitacion"+NoHabitacion+": "+temp.getMonto());
				break;
				}
				
			}else {
				temp=temp.siguiente;
			}
		}else {
			temp=temp.siguiente;
		}
		}
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
							nl+"Ubicada en la torre "+temp.getTorre()+" Nivel:   "+temp.getNivel()+
							nl+"Con un costo de: "+temp.getMonto());
				else{
					JOptionPane.showMessageDialog (null,"Habitacion del Hotel "+temp.getHotel()+
							nl+"Tipo de Habitacion"+temp.getTipoHabitacion()+
							nl+"Ubicada en el torre: "+temp.getTorre()+" Nivel: "+temp.getNivel()+
							nl+"Con un monto en la cuenta total de: "+temp.getMonto()+
							nl+"Ocupada por el cliente: "+Cliente.clientes.ObtenerString(temp.getNIT()));
				}
			}		
		}
		
	}
	
	public void OrdenarHabitacionesDes(){
		Nodo_Habitaciones temp=inicio;
		String TipoHabitacion, Hotel;
		Date FechaInicio, FechaFin;
		int NIT, Torre,nivel, Habitacion,contador;
		float monto;
		
		while(temp.siguiente!=null){
			Nodo_Habitaciones temp2=temp.siguiente;
			while(temp2!=null){
				if(temp.getContador()<temp2.getContador()){
					TipoHabitacion=temp.getTipoHabitacion();
					Hotel=temp.getHotel();
					FechaInicio=temp.getFechaInicio();
					FechaFin=temp.getFechaFin();
					NIT=temp.getNIT();
					Torre=temp.getTorre();
					nivel=temp.getNivel();
					Habitacion=temp.getHabitacion();
					contador=temp.getContador();
					monto=temp.getMonto();
					
					temp.setTipoHabitacion(temp2.getTipoHabitacion());
					temp.setHotel(temp2.getHotel());
					temp.setHotel(temp2.getHotel());
					temp.setFechaInicio(temp2.getFechaInicio());
					temp.setFechaFin(temp2.getFechaFin());
					temp.setNIT(temp2.getNIT());
					temp.setTorre(temp2.getTorre());
					temp.setNivel(temp.getNivel());
					temp.setHabitacion(temp2.getHabitacion());
					temp.setContador(temp2.getContador());
					temp.setMonto(temp2.getMonto());
					
					temp2.setTipoHabitacion(TipoHabitacion);
					temp2.setHotel(Hotel);
					temp2.setFechaInicio(FechaInicio);
					temp2.setFechaFin(FechaFin);
					temp2.setNIT(NIT);
					temp2.setTorre(Torre);
					temp2.setNivel(nivel);
					temp2.setHabitacion(Habitacion);
					temp2.setContador(contador);
					temp2.setMonto(monto);
			}
				temp2=temp2.siguiente;
			}
			
		}
		temp=temp.siguiente;
	}

}
