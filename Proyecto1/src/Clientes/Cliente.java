package Clientes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Hoteles.PanelImagen;

public class Cliente extends JFrame implements ActionListener{

	private PanelImagen contentPane;
	private JTextField Nit;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefonoemail;
	private JTextField dpi;
	JButton btnObtener = new JButton("Obtener");
	JButton btnBuscar = new JButton("Buscar");
	JButton btnAgregar = new JButton("Agregar");
	JButton btnEliminar = new JButton("Eliminar");
	public static Lista_Clientes clientes =new Lista_Clientes();
	
	String nombre, referencia, direccion;
	int nit, DPI;
	
	public Cliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 532, 435);
		contentPane = new PanelImagen("/Imagenes/Fondo.jpg");
		contentPane.setForeground(new Color(220, 20, 60));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClientesHotel = new JLabel("CLIENTES");
		lblClientesHotel.setForeground(new Color(139, 0, 0));
		lblClientesHotel.setFont(new Font("Tekton Pro", Font.BOLD, 35));
		lblClientesHotel.setBounds(179, 25, 178, 40);
		contentPane.add(lblClientesHotel);
		
		JLabel lblHotelCentro = new JLabel(" -- HOTELES CENTRO AMERICA--");
		lblHotelCentro.setForeground(new Color(178, 34, 34));
		lblHotelCentro.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblHotelCentro.setBounds(122, 334, 304, 40);
		contentPane.add(lblHotelCentro);
		
		
		btnBuscar.setFont(new Font("Tunga", Font.BOLD, 25));
		btnBuscar.setForeground(new Color(220, 20, 60));
		btnBuscar.setBounds(343, 76, 139, 47);
		contentPane.add(btnBuscar);
		btnBuscar.addActionListener(this);
		
		btnAgregar.setForeground(new Color(220, 20, 60));
		btnAgregar.setFont(new Font("Tunga", Font.BOLD, 25));
		btnAgregar.setBounds(187, 276, 139, 47);
		contentPane.add(btnAgregar);
		btnAgregar.addActionListener(this);
		
		btnEliminar.setFont(new Font("Tunga", Font.BOLD, 25));
		btnEliminar.setForeground(new Color(220, 20, 60));
		btnEliminar.setBounds(367, 276, 139, 47);
		contentPane.add(btnEliminar);
		btnEliminar.addActionListener(this);
		
		JLabel lblDpi = new JLabel("NIT");
		lblDpi.setForeground(new Color(250, 240, 230));
		lblDpi.setFont(new Font("Tunga", Font.BOLD, 35));
		lblDpi.setBounds(55, 64, 77, 40);
		contentPane.add(lblDpi);
		
		Nit = new JTextField();
		Nit.setBounds(55, 102, 128, 20);
		contentPane.add(Nit);
		Nit.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Tunga", Font.PLAIN, 20));
		lblNombre.setBounds(103, 151, 80, 16);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setText("Nombre ");
		txtNombre.setBounds(179, 147, 285, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setForeground(new Color(255, 255, 255));
		lblDireccin.setFont(new Font("Tunga", Font.PLAIN, 20));
		lblDireccin.setBounds(103, 209, 70, 14);
		contentPane.add(lblDireccin);
		
		txtDireccion = new JTextField();
		txtDireccion.setText("Direccion");
		txtDireccion.setBounds(179, 206, 285, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Referencia");
		lblTelefono.setForeground(new Color(255, 255, 255));
		lblTelefono.setFont(new Font("Tunga", Font.PLAIN, 20));
		lblTelefono.setBounds(91, 237, 88, 14);
		contentPane.add(lblTelefono);
		
		txtTelefonoemail = new JTextField();
		txtTelefonoemail.setText("Telefono/Email");
		txtTelefonoemail.setBounds(179, 234, 285, 20);
		contentPane.add(txtTelefonoemail);
		txtTelefonoemail.setColumns(10);
		
		JLabel lblNit = new JLabel("DPI");
		lblNit.setForeground(new Color(255, 255, 255));
		lblNit.setFont(new Font("Tunga", Font.PLAIN, 20));
		lblNit.setBounds(122, 178, 46, 14);
		contentPane.add(lblNit);
		
		dpi = new JTextField();
		dpi.setText("DPI");
		dpi.setBounds(179, 175, 158, 20);
		contentPane.add(dpi);
		dpi.setColumns(10);
		
		btnObtener.setForeground(new Color(220, 20, 60));
		btnObtener.setFont(new Font("Tunga", Font.BOLD, 25));
		btnObtener.setBounds(30, 276, 139, 47);
		contentPane.add(btnObtener);
		btnObtener.addActionListener(this);
		
		
		setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		nit=Integer.parseInt(Nit.getText());
		// TODO Auto-generated method stub
		if (e.getSource()==btnObtener){
			clientes.Obtener(nit);
			
		}else if(e.getSource()==btnBuscar){
			clientes.Buscar(nit);
			
		}else if(e.getSource()==btnEliminar){
			clientes.eliminarCliente(nit);
			
		}else if(e.getSource()==btnAgregar){
			nombre=txtNombre.getText();
			referencia= txtTelefonoemail.getText();
			direccion=txtDireccion.getText();
			DPI=Integer.parseInt(dpi.getText());
			clientes.insertar(nombre, direccion, nit, DPI, referencia);
		
		}
	}

}
