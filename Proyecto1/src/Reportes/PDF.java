package Reportes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hoteles.PanelImagen;
import Recepciones.Recepcion;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;

import javax.swing.JButton;

public class PDF extends JFrame implements Serializable {

	private PanelImagen contentPane;

	public PDF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 425);
		contentPane = new PanelImagen("/Imagenes/PDF.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReportes = new JLabel("REPORTES");
		lblReportes.setFont(new Font("Tekton Pro", Font.BOLD, 30));
		lblReportes.setForeground(Color.WHITE);
		lblReportes.setBounds(136, 24, 207, 41);
		contentPane.add(lblReportes);
		
		JLabel lblhotelDeCentro = new JLabel("--"+Recepcion.nombre.toUpperCase()+"--");
		lblhotelDeCentro.setBounds(83, 334, 304, 20);
		lblhotelDeCentro.setForeground(new Color(222, 184, 135));
		lblhotelDeCentro.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblhotelDeCentro);
		
		JButton btnTopClientes = new JButton("Top10 Clientes");
		btnTopClientes.setToolTipText("Imprime PDF sobre los 10 mas destacados Clientes");
		btnTopClientes.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTopClientes.setForeground(Color.DARK_GRAY);
		btnTopClientes.setBounds(126, 78, 179, 47);
		contentPane.add(btnTopClientes);
		
		JButton btnOcupacionParaUna = new JButton("Ocupacion para una fecha");
		btnOcupacionParaUna.setToolTipText("Imprime las reservaciones realizadas para una fecha.");
		btnOcupacionParaUna.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnOcupacionParaUna.setBounds(72, 261, 300, 47);
		contentPane.add(btnOcupacionParaUna);
		
		JButton btnEstadoDeCliente = new JButton("Estado de Cliente");
		btnEstadoDeCliente.setToolTipText("Imprime PDF sobre la cuenta de los clientes hospedados");
		btnEstadoDeCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEstadoDeCliente.setBounds(110, 138, 214, 47);
		contentPane.add(btnEstadoDeCliente);
		
		JButton btnTopHabitaciones = new JButton("Top10 Habitaciones");
		btnTopHabitaciones.setToolTipText("Imprime PDF sobre las habitaciones mas frecuentadas.");
		btnTopHabitaciones.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTopHabitaciones.setBounds(99, 201, 241, 47);
		contentPane.add(btnTopHabitaciones);
	}
}
