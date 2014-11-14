
package Habitaciones;

import java.util.Date;

public class Nodo_Fecha {

	Nodo_Fecha siguiente;
	Date Fecha;
	
	Nodo_Fecha(Date f, Nodo_Fecha s){
		Fecha=f;
		siguiente=s;
	}

	public Nodo_Fecha getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo_Fecha siguiente) {
		this.siguiente = siguiente;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
}
