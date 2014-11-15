package Habitaciones;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Hoteles.PanelImagen;
import Recepciones.Recepcion;

public class Checks extends JFrame implements ActionListener,Serializable {

	private PanelImagen contentPane;
	private JTextField NoEdificio;
	private JTextField NoHabitacion;
	private JTextField Nit;
	private JFormattedTextField Entrada;
	private JFormattedTextField Salida;
	private JTextField Nivel;
	private JTextField Dias;
	JComboBox comboBox = new JComboBox();
	JButton btnEstado = new JButton("Estado");
	JButton btnCuenta = new JButton("Cuenta");
	JButton btnCheckIn = new JButton("Check-In");
	JButton btnCheckOut = new JButton("Check-Out");
	JButton btnNivel = new JButton("Nivel");
	JButton btnDias = new JButton("Dias");
	JButton btnEspecificaciones = new JButton("Especificaciones");

	public static Torres torre= new Torres();
	public static Modulos modulo= new Modulos();
	
	DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	int noEdificio, habitacion, nit,nivel,dias;
	String edificio;
	Date entrada, salida;
	
	
	public Checks() {
		
		setBounds(100, 100, 658, 429);
		contentPane = new PanelImagen("/Imagenes/EntradaSalidas.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane.setLayout(null);
		
		
		JLabel lblRecepcionDeHabitaciones = new JLabel("RECEPCION DE HABITACIONES ");
		lblRecepcionDeHabitaciones.setBounds(110, 11, 422, 32);
		lblRecepcionDeHabitaciones.setForeground(new Color(0, 255, 0));
		lblRecepcionDeHabitaciones.setFont(new Font("Tekton Pro", Font.BOLD, 30));
		contentPane.add(lblRecepcionDeHabitaciones);
		
		JLabel lblEdificio = new JLabel("Edificio");
		lblEdificio.setBounds(35, 63, 75, 14);
		lblEdificio.setForeground(new Color(250, 240, 230));
		lblEdificio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblEdificio);
		comboBox.setBounds(120, 60, 85, 20);
		comboBox.setForeground(new Color(47, 79, 79));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(comboBox);
		comboBox.addItem("Torre");
		comboBox.addItem("Modulo");
		
		JLabel lblNoEdificio = new JLabel("No. Edificio");
		lblNoEdificio.setBounds(238, 66, 93, 14);
		lblNoEdificio.setForeground(new Color(245, 255, 250));
		lblNoEdificio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNoEdificio);
		
		NoEdificio = new JTextField();
		NoEdificio.setBounds(344, 63, 36, 23);
		NoEdificio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(NoEdificio);
		NoEdificio.setColumns(10);
		
		JLabel lblNoHabitacion = new JLabel("No. Habitacion");
		lblNoHabitacion.setBounds(35, 117, 131, 14);
		lblNoHabitacion.setForeground(new Color(248, 248, 255));
		lblNoHabitacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNoHabitacion);
		
		NoHabitacion = new JTextField();
		NoHabitacion.setBounds(159, 117, 46, 20);
		contentPane.add(NoHabitacion);
		NoHabitacion.setColumns(10);
		
		JLabel lblNit = new JLabel("NIT");
		lblNit.setBounds(444, 60, 57, 23);
		lblNit.setForeground(new Color(255, 255, 255));
		lblNit.setFont(new Font("Tekton Pro", Font.PLAIN, 27));
		contentPane.add(lblNit);
		
		Nit = new JTextField();
		Nit.setBounds(473, 85, 143, 20);
		Nit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(Nit);
		Nit.setColumns(10);
		
		JLabel lblFechaDeEntrada = new JLabel("Fecha de Entrada");
		lblFechaDeEntrada.setBounds(25, 171, 159, 14);
		lblFechaDeEntrada.setForeground(new Color(245, 255, 250));
		lblFechaDeEntrada.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblFechaDeEntrada);
		
		Entrada =new JFormattedTextField (format);
		Entrada.setBounds(180, 171, 111, 20);
		contentPane.add(Entrada);
		Entrada.setColumns(10);
		
		JLabel lblFechaDeSalida = new JLabel("Fecha de Salida");
		lblFechaDeSalida.setBounds(29, 196, 137, 14);
		lblFechaDeSalida.setForeground(new Color(255, 250, 250));
		lblFechaDeSalida.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblFechaDeSalida);
		
		Salida = new JFormattedTextField (format);
		Salida.setBounds(180, 196, 111, 20);
		contentPane.add(Salida);
		Salida.setColumns(10);
		btnEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edificio=(String)comboBox.getSelectedItem();
				noEdificio=Integer.parseInt(NoEdificio.getText());
				habitacion= Integer.parseInt(NoHabitacion.getText());
					if (edificio=="Torre"){
						torre.Estado(habitacion, noEdificio);
					}else if(edificio=="Modulo"){
						modulo.Estado(habitacion, noEdificio);
					}
			}
		});
		btnEstado.setBounds(57, 258, 141, 35);
		btnEstado.setForeground(new Color(47, 79, 79));
		
		btnEstado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnEstado);
		btnCuenta.setBounds(57, 304, 142, 35);
		btnCuenta.setForeground(new Color(47, 79, 79));
		
		btnCuenta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCuenta.addActionListener(this);
		contentPane.add(btnCuenta);
		btnCheckIn.setBounds(462, 259, 142, 33);
		btnCheckIn.setForeground(new Color(47, 79, 79));
		
		btnCheckIn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCheckIn.addActionListener(this);
		contentPane.add(btnCheckIn);
		btnCheckOut.setBounds(462, 304, 142, 35);
		btnCheckOut.setForeground(new Color(47, 79, 79));
		
		btnCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCheckOut.addActionListener(this);
		contentPane.add(btnCheckOut);
		
		Nivel = new JTextField();
		Nivel.setBounds(344, 112, 36, 25);
		Nivel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(Nivel);
		Nivel.setColumns(10);
		btnNivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edificio=(String)comboBox.getSelectedItem();
        		noEdificio=Integer.parseInt(NoEdificio.getText());
        		habitacion= Integer.parseInt(NoHabitacion.getText());
            	if (edificio=="Torre"){
    				Nivel.setText(Integer.toString(torre.Nivel(habitacion,noEdificio)));
    			}else if(edificio=="Modulo"){
    				Nivel.setText(Integer.toString(modulo.Nivel(habitacion,noEdificio)));
    			}
				
			}
		});
		
		btnNivel.setBounds(267, 110, 64, 31);
		btnNivel.setHorizontalAlignment(SwingConstants.LEFT);
		btnNivel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNivel.setForeground(new Color(47, 79, 79));
		contentPane.add(btnNivel);
		btnEspecificaciones.setBounds(238, 259, 142, 35);
		btnEspecificaciones.setForeground(new Color(47, 79, 79));
		
		
		btnEspecificaciones.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEspecificaciones.addActionListener(this);
		contentPane.add(btnEspecificaciones);
		
		Dias = new JTextField();
		Dias.setBounds(323, 195, 57, 23);
		contentPane.add(Dias);
		Dias.setColumns(10);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 235, 591, 32);
		contentPane.add(separator);
		
		JLabel lblhotelDeCentro = new JLabel("--"+Recepcion.nombre.toUpperCase()+"--");
		lblhotelDeCentro.setBounds(180, 358, 304, 20);
		lblhotelDeCentro.setForeground(new Color(0, 255, 127));
		lblhotelDeCentro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblhotelDeCentro);
		
		JButton btnBuscar = new JButton("Buscar por Huesped");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nit=Integer.parseInt(Nit.getText());
				if (torre.Buscar(nit)==false){
					if(modulo.Buscar(nit)==false)
						JOptionPane.showMessageDialog (null,"Cliente no encontrado");
				}
			}
		});
		btnBuscar.setBounds(431, 128, 201, 32);
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.setForeground(new Color(47, 79, 79));
		contentPane.add(btnBuscar);
		
		btnDias.setBounds(316, 168, 64, 23);
		btnDias.setHorizontalAlignment(SwingConstants.LEFT);
		btnDias.setForeground(new Color(47, 79, 79));
		btnDias.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnDias);
		btnDias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	entrada=(Date) Entrada.getValue();
        		salida=(Date) Salida.getValue();
            	final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
    			long diferencia = ( salida.getTime()-entrada.getTime())/MILLSECS_PER_DAY ; 
    			Dias.setText(""+diferencia);
                    }
        });
		
		setVisible(false);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent a) {
		edificio=(String)comboBox.getSelectedItem();
		noEdificio=Integer.parseInt(NoEdificio.getText());
		habitacion= Integer.parseInt(NoHabitacion.getText());
		nit=Integer.parseInt(Nit.getText());
		nivel=Integer.parseInt(Nivel.getText());
		dias= Integer.parseInt(Dias.getText());
		entrada=(Date) Entrada.getValue();
		salida=(Date) Salida.getValue();
		// TODO Auto-generated method stub
		if(a.getSource()==btnCuenta){
			if (edificio=="Torre"){
				torre.Cuenta (habitacion, noEdificio);
			}else if(edificio=="Modulo"){
				modulo.Cuenta(habitacion, noEdificio);
			}
			
		}else if(a.getSource()==btnEspecificaciones){
			if (edificio=="Torre"){
				torre.Especificaciones(habitacion, noEdificio);
			}else if(edificio=="Modulo"){
				modulo.Especificaciones(habitacion, noEdificio);
			}
			
		}else if(a.getSource()==btnCheckIn){
			if (edificio=="Torre"){
				torre.CheckIn(noEdificio, habitacion, nit, dias, entrada, salida);
			}else if(edificio=="Modulo"){
				modulo.CheckIn(noEdificio, habitacion, nit, dias, entrada, salida);
			}
			
		}else if(a.getSource()==btnCheckOut){
			if (edificio=="Torre"){
				torre.CheckOut(noEdificio, habitacion);
			}else if(edificio=="Modulo"){
				modulo.CheckOut(noEdificio, habitacion);
			}
			
		}
		
	}

}
