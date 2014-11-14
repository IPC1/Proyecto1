package Clientes;

import java.io.Serializable;

public class Nodo_Clientes implements Serializable {
	private String nombre, direccion, telefono;
	private int nit,DPI;
	private float contador=0;
	Nodo_Clientes siguiente;
	Nodo_Clientes(String nombre, String direccion, int nit,int DPI,String referencia,Nodo_Clientes s){
		this.nombre=nombre;
		this.direccion=direccion;
		this.nit=nit;
		this.DPI=DPI;
		this.telefono=referencia;
		siguiente=s;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getNit() {
		return nit;
	}
	public void setNit(int nit) {
		this.nit = nit;
	}
	public int getDPI() {
		return DPI;
	}
	public void setDPI(int dPI) {
		DPI = dPI;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public float getContador() {
		return contador;
	}
	public void setContador(float contador) {
		this.contador = contador;
	}
	public Nodo_Clientes getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Nodo_Clientes siguiente) {
		this.siguiente = siguiente;
	}
	
	

	}
