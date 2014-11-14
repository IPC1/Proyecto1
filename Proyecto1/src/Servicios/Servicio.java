package Servicios;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Habitaciones.Checks;
import Hoteles.PanelImagen;
import Recepciones.Recepcion;

public class Servicio extends JFrame implements ActionListener{

	private PanelImagen contentPane, pane;
	
	JButton btnGimnasio = new JButton("Gimnasio");
	JButton btnRestaurante = new JButton("Restaurante");
	JButton btnCentroDeConvenciones = new JButton("C. Convenciones");
	JButton btnBar = new JButton("Bar");
	JButton btnPolideportivo = new JButton("Polideportivo");
	JButton btnMasterSnack = new JButton("Master Snack");
	JButton btnClubDeNios = new JButton("Club de Ni\u00F1os");
	JButton btnEnfermeria = new JButton("Enfermeria");
	JButton btnDiscoteca = new JButton("Discoteca");
	JButton btnRegresar= new JButton("Menu Anterior");
	JTextField txtMonto, textField, textField_1;
	JComboBox comboBox = new JComboBox();
	private final JButton btnCuenta = new JButton("A\u00F1adir a Cuenta");
	
	String edificio;
	int noEdificio,habitacion;
	float monto;
	public Servicio() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 523, 526);
		contentPane = new PanelImagen("/Imagenes/Servicios.jpg");
		contentPane.setForeground(new Color(210, 105, 30));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		btnRestaurante.setBounds(168, 296, 130, 48);
		contentPane.add(btnRestaurante);
		btnRestaurante.setForeground(new Color(128, 0, 0));
		btnRestaurante.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRestaurante.addActionListener(this);
		
		btnGimnasio.setBounds(330, 167, 115, 48);
		btnGimnasio.setForeground(new Color(128, 0, 0));
		btnGimnasio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnGimnasio);
		btnGimnasio.addActionListener(this);
		
		btnCentroDeConvenciones.setBounds(238, 26, 148, 48);
		btnCentroDeConvenciones.setForeground(new Color(128, 0, 0));
		btnCentroDeConvenciones.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnCentroDeConvenciones);
		btnCentroDeConvenciones.addActionListener(this);
		
		
		btnBar.setBounds(81, 23, 115, 48);
		btnBar.setForeground(new Color(128, 0, 0));
		btnBar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		contentPane.add(btnBar);
		btnBar.addActionListener(this);
		
		btnPolideportivo.setBounds(297, 237, 115, 48);
		btnPolideportivo.setForeground(new Color(128, 0, 0));
		btnPolideportivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnPolideportivo);
		btnPolideportivo.addActionListener(this);
		
		btnMasterSnack.setBounds(32, 237, 130, 48);
		btnMasterSnack.setForeground(new Color(128, 0, 0));
		btnMasterSnack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnMasterSnack);
		btnMasterSnack.addActionListener(this);
		
		btnClubDeNios.setBounds(23, 93, 130, 48);
		btnClubDeNios.setForeground(new Color(128, 0, 0));
		btnClubDeNios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnClubDeNios);
		btnClubDeNios.addActionListener(this);
		
		btnEnfermeria.setBounds(10, 167, 130, 48);
		btnEnfermeria.setForeground(new Color(128, 0, 0));
		btnEnfermeria.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnEnfermeria);
		btnEnfermeria.addActionListener(this);
		
		btnDiscoteca.setBounds(297, 92, 115, 48);
		btnDiscoteca.setForeground(new Color(128, 0, 0));
		btnDiscoteca.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnDiscoteca);
		btnDiscoteca.addActionListener(this);
		
		JLabel lblHotelDeCentro = new JLabel("--"+Recepcion.nombre.toUpperCase()+"--");
		lblHotelDeCentro.setForeground(new Color(210, 105, 30));
		lblHotelDeCentro.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotelDeCentro.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblHotelDeCentro.setBounds(44, 386, 386, 31);
		contentPane.add(lblHotelDeCentro);
		
		JLabel lblServicios = new JLabel("S\r\n");
		lblServicios.setForeground(new Color(240, 248, 255));
		lblServicios.setHorizontalAlignment(SwingConstants.TRAILING);
		lblServicios.setFont(new Font("Tekton Pro", Font.PLAIN, 30));
		lblServicios.setBounds(440, 11, 29, 26);
		contentPane.add(lblServicios);
		
		JLabel lblE = new JLabel("E");
		lblE.setForeground(new Color(240, 248, 255));
		lblE.setToolTipText("");
		lblE.setHorizontalAlignment(SwingConstants.TRAILING);
		lblE.setFont(new Font("Tekton Pro", Font.PLAIN, 30));
		lblE.setBounds(440, 48, 29, 30);
		contentPane.add(lblE);
		
		JLabel lblR = new JLabel("R");
		lblR.setForeground(new Color(240, 248, 255));
		lblR.setToolTipText("");
		lblR.setHorizontalAlignment(SwingConstants.TRAILING);
		lblR.setFont(new Font("Tekton Pro", Font.PLAIN, 30));
		lblR.setBounds(440, 93, 29, 31);
		contentPane.add(lblR);
		
		JLabel lblV = new JLabel("V");
		lblV.setForeground(new Color(240, 248, 255));
		lblV.setToolTipText("");
		lblV.setHorizontalAlignment(SwingConstants.TRAILING);
		lblV.setFont(new Font("Tekton Pro", Font.PLAIN, 30));
		lblV.setBounds(440, 122, 29, 38);
		contentPane.add(lblV);
		
		JLabel lblI = new JLabel("I");
		lblI.setForeground(new Color(240, 248, 255));
		lblI.setToolTipText("");
		lblI.setHorizontalAlignment(SwingConstants.TRAILING);
		lblI.setFont(new Font("Tekton Pro", Font.PLAIN, 30));
		lblI.setBounds(440, 167, 20, 31);
		contentPane.add(lblI);
		
		JLabel lblC = new JLabel("C");
		lblC.setForeground(new Color(240, 248, 255));
		lblC.setToolTipText("");
		lblC.setHorizontalAlignment(SwingConstants.TRAILING);
		lblC.setFont(new Font("Tekton Pro", Font.PLAIN, 30));
		lblC.setBounds(440, 197, 29, 26);
		contentPane.add(lblC);
		
		JLabel lblI_1 = new JLabel("I");
		lblI_1.setForeground(new Color(240, 248, 255));
		lblI_1.setToolTipText("");
		lblI_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblI_1.setFont(new Font("Tekton Pro", Font.PLAIN, 30));
		lblI_1.setBounds(440, 237, 20, 31);
		contentPane.add(lblI_1);
		
		JLabel lblO = new JLabel("O");
		lblO.setForeground(new Color(240, 248, 255));
		lblO.setToolTipText("");
		lblO.setHorizontalAlignment(SwingConstants.TRAILING);
		lblO.setFont(new Font("Tekton Pro", Font.PLAIN, 30));
		lblO.setBounds(440, 265, 29, 31);
		contentPane.add(lblO);
		
		JLabel lblS = new JLabel("S");
		lblS.setForeground(new Color(240, 248, 255));
		lblS.setToolTipText("");
		lblS.setHorizontalAlignment(SwingConstants.TRAILING);
		lblS.setFont(new Font("Tekton Pro", Font.PLAIN, 30));
		lblS.setBounds(440, 296, 29, 36);
		contentPane.add(lblS);
	
	}

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String imagen= "/Imagenes/Servicios.jpg";
		pane= new PanelImagen(imagen);
		pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pane);
		pane.setLayout(null);
		JTextArea textPane = new JTextArea();
		textPane.setEditable(false);
		textPane.setLineWrap(true);
		textPane.setBounds(5,5, 465, 300);
		JScrollPane scroll = new JScrollPane (textPane);
		scroll.setBounds(5,5, 490, 300);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pane.add(scroll);
		
		
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(159, 326, 66, 20);
		comboBox.addItem("Torre");
		comboBox.addItem("Modulo");
		pane.add(comboBox);
		
		btnCuenta.setForeground(new Color(128, 0, 0));
		btnCuenta.setFont(new Font("Tunga", Font.BOLD, 15));
		btnCuenta.setBounds(95, 400, 130, 36);
		pane.add(btnCuenta);
		btnCuenta.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e){
         
            	edificio=(String)comboBox.getSelectedItem();
        		noEdificio=Integer.parseInt(textField_1.getText());
        		habitacion= Integer.parseInt(textField.getText());
        		monto= Float.valueOf(txtMonto.getText());
        		if (edificio=="Torre"){
					Checks.torre.AgregarCuenta(habitacion, noEdificio, monto);
				}else if(edificio=="Modulo"){
					Checks.modulo.AgregarCuenta(habitacion, noEdificio, monto);
				}
               
            }
        });
		btnRegresar.setForeground(new Color(128, 0, 0));
		btnRegresar.setFont(new Font("Tunga", Font.BOLD, 15));
		
		btnRegresar.setBounds(318, 400, 118,36);
		pane.add(btnRegresar);
		btnRegresar.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
               setContentPane(contentPane);
            }
        });      
		
		txtMonto = new JTextField("00.00");
		txtMonto.setBounds(150, 357, 75, 20);
		pane.add(txtMonto);
		txtMonto.setColumns(10);
		
		JLabel lblMontoTotal = new JLabel("Monto Total");
		lblMontoTotal.setForeground(new Color(250, 240, 230));
		lblMontoTotal.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		lblMontoTotal.setBounds(32, 359, 108, 14);
		pane.add(lblMontoTotal);
		
		JLabel lblHabitacion = new JLabel("Habitacion");
		lblHabitacion.setForeground(new Color(250, 240, 230));
		lblHabitacion.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		lblHabitacion.setBounds(295, 352, 86, 28);
		pane.add(lblHabitacion);
		
		textField = new JTextField();
		textField.setBounds(383, 357, 53, 20);
		pane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEdificio = new JLabel("Edificio");
		lblEdificio.setForeground(new Color(245, 245, 245));
		lblEdificio.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		lblEdificio.setBounds(65, 327, 63, 22);
		pane.add(lblEdificio);
		
	
		
		JLabel lblNoEdificio = new JLabel("No.Edificio");
		lblNoEdificio.setForeground(new Color(250, 235, 215));
		lblNoEdificio.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		lblNoEdificio.setBounds(318, 327, 97, 22);
		pane.add(lblNoEdificio);
		
		textField_1 = new JTextField();
		textField_1.setBounds(399, 329, 37, 20);
		pane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblHotelDeCentro = new JLabel();
		lblHotelDeCentro.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotelDeCentro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblHotelDeCentro.setForeground(new Color(210, 105, 30));
		lblHotelDeCentro.setBounds(42, 446, 386, 31);
		pane.add(lblHotelDeCentro);
		
		String nl = System.getProperty("line.separator");
		if(e.getSource()==btnRestaurante){
			imagen = "Imagen/Bar.jpg";
			pane= new PanelImagen(imagen);
			lblHotelDeCentro.setText("Restaurantes");
			textPane.setText("1. El restaurante ''Mayan Place''"+
						nl+"Ofrece desayunos, almuerzos y cenas internacionales tipo buffet en una estructura "+
								nl+ "abierta de dos pisos mirando hacia la piscina principal y el Océano Pacífico. "
								+nl+ "La influencia Maya es evidente en las lámparas artesanas y la estatua maya de "
								+nl+ "2 pisos de alto en el centro de dicho espacio"+
						nl+"   Ubicado a un costado de la piscina salada, al extremo  norte."+
						nl+"   Horario: 5.00pm-1.30am, de jueves a domingos."+
						nl+"   Precios a partir de Q50.00"+
						nl+"   Capacidad para 130 Personas"+
					nl+"2.El restaurante ''Mayan Nights''"+
						nl+"Ofrece deliciosas cenas Thai a la carta bajo los murales mayas cerca del mar"+
						nl+"Ubicado en la playa en frente de la piscina salada."+
						nl+"   Horario: 11.00am-0.00am, todos los dias."+
						nl+"   Precios a partir de Q30.00"+
						nl+"   Capacidad para 150 Personas"+
					nl+"3. El restaurante y bar ''Mayan Grill''"+
						nl+"Se especializa en carnes y otros elementos a la parrilla. "
								+ "Ofrece tanto aperitivos como un completo menú de cenas a la carta"+
						nl+"   Ubicado a un costado de la playa."+
						nl+"   Horario: 7.00am-11pm, todos los días."+
						nl+"   Precios a partir de Q70.00"+
						nl+"   Capacidad para 100 Personas"+
					nl+"4. El restaurante ''Italian Noodles''"+
						nl+"Ofrece un auténtico y único menú de pastas con un toque jamaiquino"+
						nl+"   Ubicado a la par de la Discoteca."+
						nl+"   Horario: 5.00pm-1.30am, de jueves a domingos."+
						nl+"   Precios a partir de Q50.00"+
						nl+"   Capacidad para 130 Personas"+
					nl+"5. El restaurante ''Mediterranean Flavor''"+
						nl+"Los menús mezclan los sabores Mediterráneos con una variedad de otros sabores "
								+nl+ "internacionales"+
						nl+"   Ubicado entre los frondosos jardines cerca del lobby principal del hotel. "+
						nl+"   Horario: 5.00pm-1.30am, de jueves a domingos."+
						nl+"   Precios a partir de Q50.00"+
						nl+"   Capacidad para 130 Personas");
			
		}
		if(e.getSource()==btnBar){
			imagen = "Imagen/Bar.jpg";
			pane= new PanelImagen(imagen);
			lblHotelDeCentro.setText("Bar");
			textPane.setText("1. Bar ''Playa Fria''"+
						nl+"   Ubicado a un costado de la piscina salada, al extremo  norte."+
						nl+"   Horario: 5.00pm-1.30am, de jueves a domingos."+
						nl+"   Precios a partir de Q50.00"+
						nl+"   Capacidad para 130 Personas"+
					nl+"2.Bar ''Mirador''"+
						nl+"Ubicado en la playa luego del restaurante 'Mayan Grill',  extremo sur de la piscina salada."+
						nl+"   Horario: 11.00am-0.00am, todos los dias."+
						nl+"   Precios a partir de Q30.00"+
						nl+"   Capacidad para 150 Personas"+
					nl+"3. Lobby Bar"+
						nl+"   Ubicado en el loby del hotel."+
						nl+"   Horario: 7.00am-11pm, todos los días."+
						nl+"   Precios a partir de Q70.00"+
						nl+"   Capacidad para 100 Personas"+
					nl+"4. Disco Bar"+
						nl+"   Ubicado a la par de la Discoteca."+
						nl+"   Horario: 5.00pm-1.30am, de jueves a domingos."+
						nl+"   Precios a partir de Q50.00"+
						nl+"   Capacidad para 130 Personas");
		}else if(e.getSource()==btnGimnasio){
			lblHotelDeCentro.setText("Gimnasio");
			textPane.setText("1. Gimnasio ''Excentric Body''"+
						nl+"   Ubicado en medio de las dos torres."+
						nl+"   Horario: 5.00am-10.00pm, de lunes a domingo"+
						nl+"   Precio de Entrada Q20.00."+
						nl+"   Precio de Clases a partir de Q70.00"+
						nl+"   Capacidad para 50 Personas");
		}else if(e.getSource()==btnDiscoteca){
			lblHotelDeCentro.setText("Discoteca");
			textPane.setText("1. Discoteca ''Disokothek''"+
						nl+"   Ubicado en medio de las dos torres."+
						nl+"   Horario: 5.00am-10.00pm, de lunes a domingo"+
						nl+"   Precio de Entrada Q20.00."+
						nl+"   Precio de Clases a partir de Q70.00"+
						nl+"   Capacidad para 50 Personas");
		}else if(e.getSource()==btnClubDeNios){
			lblHotelDeCentro.setText("Club de Niños");
			textPane.setText("1. Club de niños ''El dia feliz''"+
						nl+"   Ubicado en la entrada del centro de convenciones"+
						nl+"   Horario: 2.00pm-5.00pm días jueves."+
						nl+"   Horario: 11.00am-1.00pm días martes."+
						nl+"   Precio de Entrada Q40.00."+
						nl+"   Cupo para 40 niños");
		}else if(e.getSource()==btnCentroDeConvenciones){
			lblHotelDeCentro.setText("Centro de Convencines");
			textPane.setText("1. Centro de Convenciones"+
						nl+"   Ubicado  a la par del Loby del Hotel"+
						nl+"   Horario: Segun Eventos"+
						nl+"   Precio: Segun evento"+
						nl+"   Capacidad para 500 Personas");
		}else if(e.getSource()==btnEnfermeria){
			lblHotelDeCentro.setText("Enfermeria");
			textPane.setText("1. Enfermeria"+
						nl+"   Ubicado a la par del Loby, lado opuesto al Centro de Convenciones"+
						nl+"   Horario: 7.00am-9.00pm todos los días"+
						nl+"   Capacidad para 15 Personas");
		}else if(e.getSource()==btnMasterSnack){
			lblHotelDeCentro.setText("Master Snack");
			textPane.setText("1. Master Snack"+
						nl+"   Ubicado en frente de la torre 1"+
						nl+"   Horario: 5.00pm-7.00pm, de miércoles a sábado"+
						nl+"   Precios a partir de Q15.oo"+
						nl+"   Capacidad para 80 Personas");
		}else if(e.getSource()==btnPolideportivo){
			lblHotelDeCentro.setText("Polideportivo");
			textPane.setText("1.Polideportivo"+
						nl+"   Ubicado al fondo contrario de la playa, lado este del Loby"+
						nl+"   Horario: 7.00am-10.00pm, de lunes a domingo"+
						nl+"   Precio de Entrada Q20.00."+
						nl+"   Precio de distintas areas a partir de Q.30"+
						nl+"   Capacidad para 400 Personas");
		}else if(e.getSource()==btnDiscoteca){
			lblHotelDeCentro.setText("Discoteca");
			textPane.setText("1. Discoteca ''Disokothek''"+
						nl+"   Ubicado en medio de las dos torres."+
						nl+"   Horario: 5.00am-10.00pm, de lunes a domingo"+
						nl+"   Precio de Entrada Q20.00."+
						nl+"   Precio de Clases a partir de Q70.00"+
						nl+"   Capacidad para 50 Personas");
		}
		
		
	}
}
