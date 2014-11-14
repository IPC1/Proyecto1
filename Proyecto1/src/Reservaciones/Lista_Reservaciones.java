package Reservaciones;

import java.util.Date;

import javax.swing.JOptionPane;

import Clientes.Cliente;
import Hoteles.Hotel;


public class Lista_Reservaciones {
Nodo_Reservaciones inicio,fin;
String nl = System.getProperty("line.separator");
Lista_Reservaciones(){
	inicio=null;
	fin=null;
	}
	
public void Agregar(int noReservacion, Date fecha, Date fechaF,int dias,String tipoHabitacion, String edificio, int NoEdificio, int habitacion, String nombre, 
		int nit,String referencia){
	boolean b=false;
	Nodo_Reservaciones temp =inicio;
	while (temp!=null){
		if (fecha.getYear()== temp.getEntrada().getYear() && fecha.getMonth()== temp.getEntrada().getMonth() && fecha.getDay()== temp.getEntrada().getDay()){
			if(edificio==temp.getEdificio()){
				if(NoEdificio==temp.getNoEdificio()){
					if (habitacion==temp.getHabitacion()){
							JOptionPane.showMessageDialog(null,"Existe una reserva con las mismas indicaciones. A nombre de:"+nl+
									Hotel.clientes.clientes.ObtenerString(temp.getNIT())+
						nl+" Para crear la reservación necesita ir a colas");
							b=true;
							break;
					}
				}
				
			}
		}temp=temp.siguiente;
	}
	if(b=false){
		Nodo_Reservaciones nuevo= new Nodo_Reservaciones(noReservacion, fecha, fechaF,dias,tipoHabitacion, edificio, NoEdificio, habitacion,nombre, 
			nit,referencia,inicio);
		inicio= nuevo;
		if (fin==null){
		fin=inicio;
		}	
		JOptionPane.showMessageDialog(null,"Se ha gurdado una reservacion");
	}
	
	}
	
	public void Eliminar( int noReservacion){
		Nodo_Reservaciones temp=inicio;
		int cont=1;
		 while (noReservacion!= temp.getNoReservacion()){
			 temp=temp.siguiente;
			 cont++;
		 }
		 JOptionPane.showMessageDialog(null,"Se ha eliminado la Reservación No."+temp.getNoReservacion());
		 if (cont==1){
			 inicio=temp.siguiente;
		 }else{
			 temp=inicio;
			 for (int i =1; i==cont-1; i++){
				 temp=temp.siguiente; 
			 }
			 temp.setSiguiente(temp.siguiente.siguiente);
		 }
		if (temp.siguiente==null){
				 fin=temp;
			 }
		
	}
	public void Buscar(Date fecha,int dias, String edificio, int NoEdificio, int habitacion){
		Nodo_Reservaciones temp =inicio;
		while (temp!=null){
			if (habitacion==temp.getHabitacion()){
				if(edificio==temp.getEdificio()){
					if(NoEdificio==temp.getNoEdificio()){
						if (fecha.getYear()== temp.getEntrada().getYear() && fecha.getMonth()== temp.getEntrada().getMonth() && fecha.getDay()== temp.getEntrada().getDay()){
							if(dias== temp.getDias()){
								JOptionPane.showMessageDialog(null,"Existe una reservacion con para las mismas condiciones."+
							nl+" Para crear la reservación necesita ir a colas");
								break;
							}else if(dias<temp.getDias()){
								JOptionPane.showMessageDialog(null,"Existe una reservacion con para la misma habitacion con ingreso"+
										nl+"dia y salida "+(temp.getDias()-dias)+" dias despues."+
										nl+" Para crear la reservación necesita ir a colas");
							}else if(dias>temp.getDias()){
								JOptionPane.showMessageDialog(null,"Existe una reservacion con para la misma habitacion con ingreso"+
										nl+"dia y salida "+(dias-temp.getDias())+" dias antes."+
										nl+" Para crear la reservación necesita ir a colas");
							}
							
						}
					}
					
				}
			}temp=temp.siguiente;
		}
		if(temp==null){
			JOptionPane.showMessageDialog(null,"No hay coincidencias");
		}
	}
	
	public String Listar(){
		Nodo_Reservaciones temp=inicio;
		String texto=" ";
		do{
		texto+="Reservacion: "+temp.getNoReservacion()+"Fecha de Entrada: "+temp.getEntrada()+
				"Fecha de Salida: "+temp.getSalida()+"Edificio: "+temp.getEdificio()+temp.getNoEdificio()+
				"Habitacion: "+temp.getTipoHabitacion()+temp.getHabitacion()+Cliente.clientes.ObtenerString (temp.getNIT());
		temp=temp.siguiente;
		}while(temp!=null);
		return texto;
	}
	
	public int contar(){
		int cont = 0;
		Nodo_Reservaciones temp=inicio;
		while (temp!= null){
			cont++;
			temp=temp.siguiente;
		}
		return cont;
	}
	}
