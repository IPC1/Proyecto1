package Recepciones;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import Habitaciones.Checks;
import Hoteles.Hotel;
import Hoteles.PanelImagen;
import Reservaciones.Reservacion;
import Servicios.Servicio;

public class Recepcion extends JFrame implements ActionListener{

	private PanelImagen contentPane;
	JLabel lblRecepcionHotel = new JLabel("HOTELES DE CENTRO AMERICA");
	JButton Recepciones = new JButton("Reservaciones");
	JButton Check= new JButton("Registro y Control de Habitaciones");
	JButton Servicios = new JButton("Servicios");
	JButton btnClientes = new JButton("Clientes");
	public static String nombre;
	
	public Recepcion(String Nombre) {
		nombre= Nombre;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 515, 399);
		contentPane = new PanelImagen("/Imagenes/Recepcion.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
			contentPane.setLayout(null);
		
			
			lblRecepcionHotel.setForeground(new Color(255, 255, 255));
			
			lblRecepcionHotel.setFont(new Font("Trajan Pro", Font.BOLD, 20));
			lblRecepcionHotel.setBounds(75, 308, 397, 42);
			contentPane.add(lblRecepcionHotel);
		    Recepciones.setForeground(new Color(65, 105, 225));
			
			
		    Recepciones.setFont(new Font("Tahoma", Font.BOLD, 19));
			Recepciones.setBounds(152, 156, 171, 56);
			contentPane.add(Recepciones);
			Recepciones.addActionListener(this);
			Check.setForeground(new Color(65, 105, 225));
			
			Check.setFont(new Font("Tahoma", Font.BOLD, 15));
			Check.setBounds(85, 236, 312, 51);
			contentPane.add(Check);
			Check.addActionListener(this);
			Servicios.setForeground(new Color(65, 105, 225));
			
			Servicios.setFont(new Font("Tahoma", Font.BOLD, 18));
			Servicios.setBounds(250, 81, 147, 51);
			contentPane.add(Servicios);
			Servicios.addActionListener(this);
			
			btnClientes.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnClientes.setForeground(new Color(65, 105, 225));
			btnClientes.setBounds(73, 80, 147, 51);
			contentPane.add(btnClientes);
			
			JLabel lblHotel = new JLabel("RECEPCION "+nombre.toUpperCase());
			lblHotel.setForeground(Color.WHITE);
			lblHotel.setFont(new Font("Trajan Pro", Font.BOLD, 20));
			lblHotel.setBounds(56, 28, 397, 42);
			contentPane.add(lblHotel);
			btnClientes.addActionListener(this);
			
			setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== btnClientes){
			Hotel.clientes.setVisible(true);
		}
		if (e.getSource()==Servicios){
			Servicio servicios =new Servicio();
			
		}if (e.getSource()==Recepciones){
			Reservacion reservacion= new Reservacion();
			
		}if (e.getSource()==Check){
			Checks checks= new Checks();
			checks.setVisible(true);
		}
	}
}

