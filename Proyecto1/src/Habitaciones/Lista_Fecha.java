package Habitaciones;

import java.util.Date;

import javax.swing.JOptionPane;

public class Lista_Fecha {

	Nodo_Fecha inicio, fin;

	public Lista_Fecha (){
		inicio=null;
		fin=null;
	}
	
	public void Agregar(Date f){
		Nodo_Fecha nuevo = new Nodo_Fecha(f, inicio);
		inicio=nuevo;
		if(fin==null){
			fin=inicio;
		}
	}
	
	public boolean Buscar(Date f){
		Nodo_Fecha temp=inicio;
		boolean b=false;
		while(temp!=null){
			b= (f.getYear()== temp.Fecha.getYear() && f.getMonth()== temp.Fecha.getMonth() && f.getDay()== temp.Fecha.getDay());
			if(b==true){
				JOptionPane.showMessageDialog (null,"La fecha ya aesta agregada a la lista.");
				return b;
			}
			temp=temp.siguiente;
		}
		return b;
			
	}
	
}
