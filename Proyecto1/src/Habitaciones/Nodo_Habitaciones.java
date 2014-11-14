package Habitaciones;

import java.util.Date;

public class Nodo_Habitaciones {
	
		private String TipoHabitacion, Hotel;
		private Date FechaInicio, FechaFin;
		private int NIT, Torre,nivel, Habitacion;
		private float monto;
		
		
		Nodo_Habitaciones siguiente;
		
		public Nodo_Habitaciones (Date fechaInicio, Date fechaFin,String tipoHabitacion, int modulo, int habitacion, 
				int nit,int nivel,String hotel,Nodo_Habitaciones s){

			TipoHabitacion=tipoHabitacion;
			Hotel=hotel;
			FechaInicio=fechaInicio;
			FechaFin=fechaFin;
			NIT= nit;
			Torre=modulo;
			Habitacion=habitacion;
			this.nivel=nivel;
			if (TipoHabitacion=="Sencilla")
				monto=200;
			else if (TipoHabitacion=="Regular")
				monto=350;
			else if (TipoHabitacion=="Exclusiva")
				monto=500;
			
			siguiente=s;
		}

		public int getNivel() {
			return nivel;
		}

		public void setNivel(int nivel) {
			this.nivel = nivel;
		}

		public String getTipoHabitacion() {
			return TipoHabitacion;
		}

		public void setTipoHabitacion(String tipoHabitacion) {
			TipoHabitacion = tipoHabitacion;
		}

		public String getHotel() {
			return Hotel;
		}

		public void setHotel(String referencia) {
			Hotel = referencia;
		}

		public Date getFechaInicio() {
			return FechaInicio;
		}

		public void setFechaInicio(Date fechaInicio) {
			FechaInicio = fechaInicio;
		}

		public Date getFechaFin() {
			return FechaFin;
		}

		public void setFechaFin(Date fechaFin) {
			FechaFin = fechaFin;
		}

		public int getNIT() {
			return NIT;
		}

		public void setNIT(int nIT) {
			NIT = nIT;
		}

		public int getTorre() {
			return Torre;
		}

		public void setTorre(int torre) {
			Torre = torre;
		}

		public int getHabitacion() {
			return Habitacion;
		}

		public void setHabitacion(int habitacion) {
			Habitacion = habitacion;
		}

		public float getMonto() {
			return monto;
		}

		public void setMonto(float monto) {
			this.monto = monto;
		}

		public void setSiguiente(Nodo_Habitaciones siguiente) {
			this.siguiente = siguiente;
		}
		
		
}
