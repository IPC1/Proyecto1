package Reservaciones;

import java.io.Serializable;
import java.util.Date;


public class Nodo_Reservaciones implements Serializable {
	private String Nombre, TipoHabitacion, Referencia, edificio;
	private Date Entrada, Salida;
	private int NIT, NoReservacion, NoEdificio, Habitacion,dias;
	private float monto;
	Nodo_Reservaciones siguiente;
	
	public Nodo_Reservaciones (int noReservacion, Date fechaInicio, Date fechaFin,int dias,String tipoHabitacion, String edificio, int NoEdificio, int habitacion, String nombre, 
			int nit,String referencia,Nodo_Reservaciones s){
		
		NoReservacion=noReservacion;
		Nombre=nombre;
		TipoHabitacion=tipoHabitacion;
		Referencia=referencia;
		Entrada	=fechaInicio;
		Salida=fechaFin;
		this.dias=dias;
		NIT= nit;
		this.edificio=edificio;
		this.NoEdificio=NoEdificio;
		Habitacion=habitacion;
		if (TipoHabitacion=="Sencilla")
			monto=200;
		else if (TipoHabitacion=="Regular")
			monto=350;
		else if (TipoHabitacion=="Exclusiva")
			monto=500;
		
		siguiente=s;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getTipoHabitacion() {
		return TipoHabitacion;
	}

	public void setTipoHabitacion(String tipoHabitacion) {
		TipoHabitacion = tipoHabitacion;
	}

	public String getReferencia() {
		return Referencia;
	}

	public void setReferencia(String referencia) {
		Referencia = referencia;
	}

	public String getEdificio() {
		return edificio;
	}

	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}

	public Date getEntrada() {
		return Entrada;
	}

	public void setEntrada(Date entrada) {
		Entrada = entrada;
	}

	public Date getSalida() {
		return Salida;
	}

	public void setSalida(Date salida) {
		Salida = salida;
	}

	public int getNIT() {
		return NIT;
	}

	public void setNIT(int nIT) {
		NIT = nIT;
	}

	public int getNoReservacion() {
		return NoReservacion;
	}

	public void setNoReservacion(int noReservacion) {
		NoReservacion = noReservacion;
	}

	public int getNoEdificio() {
		return NoEdificio;
	}

	public void setNoEdificio(int noEdificio) {
		NoEdificio = noEdificio;
	}

	public int getHabitacion() {
		return Habitacion;
	}

	public void setHabitacion(int habitacion) {
		Habitacion = habitacion;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public Nodo_Reservaciones getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo_Reservaciones siguiente) {
		this.siguiente = siguiente;
	}
	

}
