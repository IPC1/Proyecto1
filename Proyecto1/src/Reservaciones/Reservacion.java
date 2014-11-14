package Reservaciones;

import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Hoteles.PanelImagen;
import Recepciones.Recepcion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reservacion extends JFrame implements ActionListener{

	JFrame frame= new JFrame();
	PanelImagen contentPane;
	JTextField NIT,Nombre,Torre,Total,Habitacion,Referencia,noCancelacion,Dias;
	JComboBox comboBox,comboBox_2;
	JFormattedTextField Fecha,FechaS;
	JButton btnReservar = new JButton("Reservar");
	JButton btnBuscar = new JButton("Buscar");
	JButton btnCancelar = new JButton("Cancelar");
	JButton btnTotal = new JButton("Dias");
	JButton btnTotal_1 = new JButton("Total");
	
	Date entrada,salida;
	int noReservacion,nit,habitacion,contador, total,dias, NoEdificio;
	String referencia,tipoHabitacion, nombre, edificio;
	DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	JLabel lblCodigo = new JLabel(Integer.toString(contador));
	public static Lista_Reservaciones reservaciones= new Lista_Reservaciones();
	
	public Reservacion() {
		contador=0;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 633, 470);
		contentPane = new PanelImagen("/Imagenes/Reservaciones.jpg");
		contentPane.setForeground(new Color(220, 20, 60));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		comboBox= new JComboBox();
		comboBox.setBounds(179, 61, 140, 20);
		comboBox.addItem("Sencilla");
		comboBox.addItem("Regular");
		comboBox.addItem("Exclusiva");
		contentPane.add(comboBox);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(101, 211, 76, 20);
		comboBox_2.addItem("Torre");
		comboBox_2.addItem("Modulo");
		contentPane.add(comboBox_2);
		
		comboBox_2.setBounds(103, 208, 80, 20);
		contentPane.add(comboBox_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(37, 239, 529, 14);
		contentPane.add(separator);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(436, 51, 19, 132);
		contentPane.add(separator_2);
		
		FechaS= new JFormattedTextField (format);
		FechaS.setBounds(179, 132, 140, 20);
		contentPane.add(FechaS);
		FechaS.setColumns(10);
		
		Fecha = new JFormattedTextField (format);
		Fecha.setBounds(179, 98, 140, 20);
		contentPane.add(Fecha);
		Fecha.setColumns(10);
		
		NIT = new JTextField();
		NIT.setBounds(173, 273, 86, 20);
		contentPane.add(NIT);
		NIT.setColumns(10);
		
		Nombre = new JTextField();
		Nombre.setBounds(173, 298, 286, 20);
		contentPane.add(Nombre);
		Nombre.setColumns(10);
		
		Referencia = new JTextField();
		Referencia.setBounds(173, 360, 119, 20);
		contentPane.add(Referencia);
		Referencia.setColumns(10);
		
		Torre = new JTextField(null);
		Torre.setBounds(291, 211, 36, 20);
		contentPane.add(Torre);
		Torre.setColumns(10);
		
		Total = new JTextField();
		Total.setEditable(false);
		Total.setBounds(252, 329, 86, 20);
		contentPane.add(Total);
		Total.setColumns(10);
		
		Habitacion = new JTextField();
		Habitacion.setBounds(436, 211, 36, 20);
		contentPane.add(Habitacion);
		Habitacion.setColumns(10);
		
		noCancelacion = new JTextField();
		noCancelacion.setBounds(505, 98, 61, 20);
		contentPane.add(noCancelacion);
		noCancelacion.setColumns(10);
		
		Dias = new JTextField();
		Dias.setBounds(257, 163, 46, 20);
		contentPane.add(Dias);
		Dias.setColumns(10);
		
		JLabel lblNoEdificio = new JLabel("No. Edificio");
		lblNoEdificio.setForeground(new Color(255, 255, 240));
		lblNoEdificio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNoEdificio.setBounds(197, 214, 95, 14);
		contentPane.add(lblNoEdificio);
		
		JLabel lblDiasTotales = new JLabel("Dias Totales");
		lblDiasTotales.setForeground(new Color(255, 255, 240));
		lblDiasTotales.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDiasTotales.setBounds(67, 167, 102, 14);
		contentPane.add(lblDiasTotales);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTotal.setForeground(new Color(255, 255, 240));
		lblTotal.setBounds(103, 335, 46, 14);
		contentPane.add(lblTotal);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setForeground(new Color(255, 255, 240));
		lblNombre.setBounds(91, 304, 72, 14);
		contentPane.add(lblNombre);
		
		JLabel lblId = new JLabel("NIT");
		lblId.setForeground(new Color(255, 255, 240));
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(113, 279, 36, 14);
		contentPane.add(lblId);
		
		JLabel lblReservacionesHotelDe = new JLabel("RESERVACIONES");
		lblReservacionesHotelDe.setForeground(new Color(245, 255, 250));
		lblReservacionesHotelDe.setFont(new Font("Tekton Pro", Font.PLAIN, 30));
		lblReservacionesHotelDe.setBounds(144, 14, 287, 36);
		contentPane.add(lblReservacionesHotelDe);
		
		JLabel lblNoACancelar = new JLabel("No. A Cancelar");
		lblNoACancelar.setForeground(new Color(255, 255, 255));
		lblNoACancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNoACancelar.setBounds(447, 67, 119, 14);
		contentPane.add(lblNoACancelar);
		
		JLabel lblHotel = new JLabel("--"+Recepcion.nombre.toUpperCase()+"--");
		lblHotel.setForeground(new Color(233, 150, 122));
		lblHotel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHotel.setBounds(144, 399, 275, 22);
		contentPane.add(lblHotel);
		
		JLabel lblFechaDeSalida = new JLabel("Fecha de Salida");
		lblFechaDeSalida.setForeground(new Color(255, 255, 224));
		lblFechaDeSalida.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFechaDeSalida.setBounds(44, 138, 133, 14);
		contentPane.add(lblFechaDeSalida);
		
		JLabel lblNoReservacion = new JLabel("No. Reservacion");
		lblNoReservacion.setForeground(new Color(255, 255, 240));
		lblNoReservacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNoReservacion.setBounds(454, 248, 112, 14);
		contentPane.add(lblNoReservacion);
		
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCodigo.setForeground(new Color(255, 255, 255));
		lblCodigo.setBounds(505, 264, 46, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblTipoDeHabitacion = new JLabel("Tipo de Habitacion");
		lblTipoDeHabitacion.setForeground(new Color(250, 235, 215));
		lblTipoDeHabitacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTipoDeHabitacion.setBounds(21, 64, 148, 17);
		contentPane.add(lblTipoDeHabitacion);
		
		JLabel lblTorre = new JLabel("Edificio");
		lblTorre.setForeground(new Color(255, 255, 240));
		lblTorre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTorre.setBounds(32, 211, 61, 14);
		contentPane.add(lblTorre);
		
		JLabel lblFecha = new JLabel("Fecha de Entrada");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFecha.setForeground(new Color(250, 235, 215));
		lblFecha.setBounds(31, 98, 148, 14);
		contentPane.add(lblFecha);
		
		JLabel lblHabitacion = new JLabel("Habitaci\u00F3n");
		lblHabitacion.setForeground(new Color(255, 255, 240));
		lblHabitacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHabitacion.setBounds(345, 211, 86, 14);
		contentPane.add(lblHabitacion);
		
		JLabel lblReferencia = new JLabel("Referencia");
		lblReferencia.setForeground(new Color(255, 255, 240));
		lblReferencia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblReferencia.setBounds(67, 366, 89, 14);
		contentPane.add(lblReferencia);
		
		btnTotal_1.setForeground(new Color(139, 0, 0));
		btnTotal_1.setBounds(173, 329, 72, 20);
		contentPane.add(btnTotal_1);
		btnTotal_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	total();
    			Total.setText(Integer.toString(total));
            }
        });
				
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscar.setForeground(new Color(128, 0, 0));
		btnBuscar.setBounds(329, 64, 86, 36);
		contentPane.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entrada=(Date) Fecha.getValue();
				dias=Integer.parseInt(Dias.getText());
				habitacion=Integer.parseInt(Habitacion.getText());
				NoEdificio=nit=Integer.parseInt(Torre.getText());
				edificio=(String)comboBox_2.getSelectedItem();
				reservaciones.Buscar(entrada, dias, edificio, NoEdificio, habitacion);
			}
		});
		
		btnReservar.addActionListener(this);
		btnReservar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnReservar.setForeground(new Color(128, 0, 0));
		btnReservar.setBounds(391, 347, 124, 34);
		contentPane.add(btnReservar);
				
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelar.setForeground(new Color(128, 0, 0));
		btnCancelar.setBounds(448, 135, 133, 34);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cancelar=Integer.parseInt(noCancelacion.getText()) ;
				reservaciones.Eliminar(cancelar);	 
			}
		});
		
		btnTotal.setForeground(new Color(139, 0, 0));
		btnTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTotal.setBounds(179, 160, 72, 23);
		contentPane.add(btnTotal);
		btnTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	entrada=(Date) Fecha.getValue();
        		salida=(Date) FechaS.getValue();
            	final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
    			long diferencia = ( salida.getTime()-entrada.getTime())/MILLSECS_PER_DAY ; 
    			Dias.setText(""+diferencia);
            }
        });
		
	}
	public void total(){
		tipoHabitacion=(String)comboBox.getSelectedItem();
		dias=Integer.parseInt(Dias.getText());
		if(tipoHabitacion=="Sencilla"){
			total=dias*200;
		}else if (tipoHabitacion=="Regular")
			total=dias*350;
		else if(tipoHabitacion=="Exclusiva")
			total=dias*500;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		tipoHabitacion=(String)comboBox.getSelectedItem();
		nit=Integer.parseInt(NIT.getText());
		habitacion=Integer.parseInt(Habitacion.getText());
		NoEdificio=nit=Integer.parseInt(Torre.getText());
		edificio=(String)comboBox_2.getSelectedItem();
		nombre= Nombre.getText();
		referencia=Referencia.getText();
		noReservacion= contador;
		salida=(Date) FechaS.getValue();
		entrada=(Date) Fecha.getValue();
		dias=Integer.parseInt(Dias.getText());

		reservaciones.Agregar(noReservacion, entrada, salida, dias, tipoHabitacion, edificio, NoEdificio, habitacion, nombre, nit, referencia);
		contador++;
		lblCodigo.setText(Integer.toString(contador));		 
		
	}

}
