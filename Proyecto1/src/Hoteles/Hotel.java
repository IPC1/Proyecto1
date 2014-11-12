package Hoteles;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Clientes.Cliente;
import Recepciones.Recepcion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hotel extends JFrame implements ActionListener {

	private PanelImagen contentPane, Pane;
	private JTextField textField;
	private JTextField textField_1;
	JLabel lblHotelesDeCentro = new JLabel("Hoteles de Centro America");
	JComboBox comboBox = new JComboBox();
	String nombre, id;
	int contador=0;
	public static Cliente clientes=new Cliente();
	public Hotel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 382);
		contentPane = new PanelImagen("/Imagenes/Hotel.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblHotelesDeCentro.setForeground(Color.BLACK);
		lblHotelesDeCentro.setFont(new Font("Tekton Pro", Font.BOLD, 30));
		lblHotelesDeCentro.setBounds(63, 28, 340, 31);
		contentPane.add(lblHotelesDeCentro);
		
		
		JLabel lblHotel = new JLabel("Hotel");
		lblHotel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHotel.setBounds(63, 129, 56, 16);
		contentPane.add(lblHotel);
		
		comboBox.setBounds(150, 129, 269, 22);
		contentPane.add(comboBox);
		
		JButton btnRecepcion = new JButton("Recepcion");
		btnRecepcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recepcion recepcion= new Recepcion((String)comboBox.getSelectedItem());
				recepcion.setVisible(true);
			}
		});
		btnRecepcion.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRecepcion.setForeground(new Color(0, 0, 0));
		btnRecepcion.setBounds(176, 174, 172, 54);
		contentPane.add(btnRecepcion);
		
		JButton btnConfiguraciones = new JButton("Configuraciones");
		btnConfiguraciones.setBackground(Color.ORANGE);
		btnConfiguraciones.setForeground(Color.BLACK);
		btnConfiguraciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConfiguraciones.setBounds(272, 284, 182, 40);
		contentPane.add(btnConfiguraciones);
		btnConfiguraciones.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Pane = new PanelImagen("/Imagenes/Hotel.jpg");
		Pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Pane);
		Pane.setLayout(null);
		
		Pane.add(lblHotelesDeCentro);
		JLabel lblNombreDeHotel = new JLabel("Nombre de Hotel");
		lblNombreDeHotel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreDeHotel.setBounds(37, 135, 143, 16);
		Pane.add(lblNombreDeHotel);
		
		textField = new JTextField();
		textField.setBounds(184, 134, 233, 22);
		Pane.add(textField);
		textField.setColumns(10);
		
		JLabel lblIdDeHotel = new JLabel("ID de Hotel");
		lblIdDeHotel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdDeHotel.setBounds(73, 106, 107, 16);
		Pane.add(lblIdDeHotel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(282, 105, 61, 23);
		Pane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnGenerar = new JButton("Generar");
		btnGenerar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGenerar.setForeground(new Color(0, 0, 0));
		btnGenerar.setBounds(184, 104, 93, 25);
		Pane.add(btnGenerar);
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText(Integer.toString(contador));
				
			}
		});
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCrear.setBounds(37, 208, 98, 40);
		Pane.add(btnCrear);
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = textField_1.getText();
				nombre = textField.getText();
				String buscar;
				boolean b=true;
				int indice=-1;
				for (int i= 0; i<comboBox.getItemCount() ; i++){
					buscar= (String) comboBox.getItemAt(i);
				   if (buscar.contains(nombre)|| buscar.endsWith(id)) {
					   JOptionPane.showMessageDialog(null, "El hotel "+nombre+" ya existe o el id ya esta siendo utilizado");
				      b=false;
					   break;
				   }
				}
				if(b){
					
				comboBox.addItem(nombre+" "+id);
				textField_1.setText(" ");
				textField.setText(" ");
				contador++;
				JOptionPane.showMessageDialog(null, "Se creó un nuevo hotel.");
				
				}
				
			}
		});
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEliminar.setBounds(327, 205, 107, 43);
		Pane.add(btnEliminar);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = textField_1.getText();
				nombre = textField.getText();
				int indice=-1;
				for (int i= 0; i<comboBox.getItemCount() ; i++){
					nombre= (String) comboBox.getItemAt(i);
				   if (nombre.endsWith(id)) {
				      indice= i;
				      break;
				   }
				}
				if(indice==-1){
					JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
				}else{
					JOptionPane.showMessageDialog(null, "Se removio el Hotel con ID: "+id);
					comboBox.removeItemAt(indice);
				}
			}
		});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBuscar.setBounds(184, 205, 97, 43);
		Pane.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = textField_1.getText();
				nombre = textField.getText();
				String buscar;
				boolean b=true;
				int indice=-1;
				for (int i= 0; i<comboBox.getItemCount() ; i++){
					buscar= (String) comboBox.getItemAt(i);
				   if (buscar.contains(nombre)|| buscar.endsWith(id)) {
					   JOptionPane.showMessageDialog(null, "El hotel "+nombre+" ya existe o el id ya esta siendo utilizado");
				      b=false;
					   break;
				   }
				}
				if(b){
					JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
				}
			}
		});
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAtras.setBounds(38, 287, 97, 36);
		Pane.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(contentPane);
				contentPane.add(lblHotelesDeCentro);
			}
		});
	}
	
}
