package Clientes;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class Lista_Clientes implements Serializable{
	Nodo_Clientes inicio, fin;
	String nl = System.getProperty("line.separator");
	Lista_Clientes(){
		inicio=null;
		fin=null;
	}
	
	public void insertar(String nombre, String direccion, int nit,int DPI,String referencia){
		Nodo_Clientes nuevo= new Nodo_Clientes (nombre,direccion,nit,DPI,referencia,inicio);
		inicio= nuevo;
		if (fin==null)
			fin=inicio;
		 JOptionPane.showMessageDialog(null,"Se ha agregado un nuevo cliente");
		}
	public void eliminarCliente( int nit){
		Nodo_Clientes temp=inicio;
		int cont=1;
		 while (nit!= temp.getNit()){
			 temp=temp.siguiente;
			 cont++;
		 }
		 JOptionPane.showMessageDialog(null,"Se ha eliminado al cliente:" + temp.getNombre());
		 if (cont==1){
			 inicio=temp.siguiente;
		 }else{
			 temp=inicio;
			 for (int i =1; i<cont-1; i++){
				temp=temp.siguiente; 
			 }
			 temp.setSiguiente(temp.siguiente.siguiente);
		 }
		if (temp.siguiente==null){
			fin=temp;
		}
		if (temp==null){
			JOptionPane.showMessageDialog(null,"Se han encontrado coincidencias");
		}
	}
	public void Buscar(int nit){
		Nodo_Clientes temp =inicio;
		while (temp!=null){
			if (nit== temp.getNit()){
				JOptionPane.showMessageDialog(null,"Se ha encontrado al  cliente: "+temp.getNombre());
				break;
				}
			temp=temp.siguiente;
			}
		if (temp==null){
			JOptionPane.showMessageDialog(null,"No se ha encontrado ningun cliente con el NIT: "+nit);
		}
		}
	public void Obtener(int nit){
		String nl = System.getProperty("line.separator");
		Nodo_Clientes temp= inicio;
		while (temp!=null){
			if (nit== temp.getNit()){
				JOptionPane.showMessageDialog(null,"Nombre: "+temp.getNombre()+
						nl+"NIT: "+temp.getNit()+
						nl+"DPI: "+temp.getDPI()+
						nl+"Dirección: "+temp.getDireccion()+
						nl+"Referencia: "+temp.getTelefono());	
			}
			temp=temp.siguiente;
			}
			
	}
	public String ObtenerString(int nit){
		
		String texto=" ";
		Nodo_Clientes temp= inicio;
		while (temp!=null){
			if (nit== temp.getNit()){
				texto="Nombre: "+temp.getNombre()+
						nl+"NIT: "+temp.getNit()+
						nl+"DPI: "+temp.getDPI()+
						nl+"Dirección: "+temp.getDireccion()+
						nl+"Referencia: "+temp.getTelefono();	
			}
			temp=temp.siguiente;
			}
		return texto;	
	}
	public String Listar(){
		Nodo_Clientes temp=inicio;
		String Texto=null;
		while(temp!=null){
			Texto+="Nombre: "+temp.getNombre()+
					" NIT: "+temp.getNit()+
					" DPI: "+temp.getDPI()+
					" Dirección: "+temp.getDireccion()+
					" Referencia: "+temp.getTelefono()+nl;	
			temp=temp.siguiente;
		}
		if(Texto==null){
			Texto="La lista de CLientes esta vacia";
		}
		return Texto;
	}
	
	public void AgregarContador(float monto, int nit){
		Nodo_Clientes temp =inicio;
		while (temp!=null){
			if (nit== temp.getNit()){
				monto+=temp.getContador();
				temp.setContador(monto);
				break;
				}
			temp=temp.siguiente;
			}
		if (temp==null){
			JOptionPane.showMessageDialog(null,"No se ha encontrado ningun cliente con el NIT: "+nit);
		}
	}
	
	public void OrdenarClientesDes(){
		Nodo_Clientes temp=inicio;
		String nombre, direccion, telefono;
		int nit,DPI;
		float contador;
		while(temp.siguiente!=null){
			Nodo_Clientes temp2=temp.siguiente;
			while(temp2!=null){
				if(temp.getContador()<temp2.getContador()){
					nombre=temp.getNombre();
					direccion=temp.getDireccion();
					telefono=temp.getTelefono();
					nit=temp.getNit();
					DPI=temp.getDPI();
					contador=temp.getContador();
					
					temp.setNombre(temp2.getNombre());
					temp.setDireccion(temp2.getDireccion());
					temp.setTelefono(temp2.getTelefono());
					temp.setNit(temp2.getNit());
					temp.setDPI(temp2.getDPI());
					temp.setContador(temp2.getContador());
					
					temp2.setNombre(nombre);
					temp2.setDireccion(direccion);
					temp2.setTelefono(telefono);
					temp2.setNit(nit);
					temp2.setDPI(DPI);
					temp2.setContador(contador);
			}
				temp2=temp2.siguiente;
			}
			
		}
		temp=temp.siguiente;
	}
}
