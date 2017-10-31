//Le dice el paquete al que pertenece la clase
package com.registro.ui;

//Se importan las clases necesarias
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import com.registro.objetos.Persona;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

//Esta clase Principal es HIJA (extends) de JFrame
public class Principal extends JFrame {

	//Se declaran los atributos o variables locales de la Clase
	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfEdad;
	private JTextField tfDNI;
	private JSpinner spAltura;
	private JSpinner spPeso;
	private JComboBox<String> combo;
	private List<Persona> listPersonas = new ArrayList<Persona>();

	public Principal() {
		setTitle("Registrar Persona");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRegistro.setBounds(120, 27, 151, 22);
		contentPane.add(lblRegistro);
		
		JPanel panelNombreApe = new JPanel();
		panelNombreApe.setBorder(new TitledBorder(null, "Nombre y Apellido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNombreApe.setBounds(10, 144, 375, 81);
		contentPane.add(panelNombreApe);
		panelNombreApe.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 39, 58, 14);
		panelNombreApe.add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(76, 36, 100, 20);
		panelNombreApe.add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(205, 39, 50, 14);
		panelNombreApe.add(lblApellido);
		
		tfApellido = new JTextField();
		tfApellido.setBounds(265, 36, 100, 20);
		panelNombreApe.add(tfApellido);
		tfApellido.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Caracteristicas Fisicas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 236, 375, 92);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(10, 30, 58, 14);
		panel.add(lblAltura);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(205, 30, 50, 14);
		panel.add(lblPeso);
		
		JLabel lblPeso_1 = new JLabel("Sexo:");
		lblPeso_1.setBounds(10, 58, 58, 14);
		panel.add(lblPeso_1);
		
		spAltura = new JSpinner();
		spAltura.setModel(new SpinnerNumberModel(0.0, null, null, 0.1));
		spAltura.setBounds(78, 24, 95, 20);
		panel.add(spAltura);
		
		spPeso = new JSpinner();
		spPeso.setModel(new SpinnerNumberModel(0.0, null, null, 0.1));
		spPeso.setBounds(265, 27, 100, 20);
		panel.add(spPeso);
		
		//Al combo box le asignamos el objeto resultante del metodo cargarCombo();
		JComboBox<String> comboSexo = cargarCombo();
		comboSexo.setBounds(78, 52, 95, 20);
		panel.add(comboSexo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "DNI y Edad", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 60, 375, 73);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 33, 58, 14);
		panel_1.add(lblDni);
		
		tfDNI = new JTextField();
		tfDNI.setColumns(10);
		tfDNI.setBounds(76, 30, 100, 20);
		panel_1.add(tfDNI);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(205, 33, 50, 14);
		panel_1.add(lblEdad);
		
		tfEdad = new JTextField();
		tfEdad.setColumns(10);
		tfEdad.setBounds(265, 30, 100, 20);
		panel_1.add(tfEdad);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//En el ActionListener de este boton primero se comprueba que los campos no esten vacios.
				if (tfDNI.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "No ingreso un valor en DNI");
				}
				else if (tfEdad.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "No ingreso un valor en Edad");
				}
				else if (tfNombre.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "No ingreso un valor en Nombre");
				}
				else if (tfApellido.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "No ingreso un valor en Apellido");
				}
				else if (spPeso.getValue().toString().equals("0.0")) {
					JOptionPane.showMessageDialog(contentPane, "No ingreso un valor en Peso");
				}
				else if (spAltura.getValue().toString().equals("0.0")) {
					JOptionPane.showMessageDialog(contentPane, "No ingreso un valor en Altura");
				}
				else {
					//Si no estan vacios se crea la persona instanciando la Clase Persona.
					Persona persona = new Persona();
					
					//A al objeto creado se le setean los datos obtenidos por los campos con los setters definidos
					persona.setDni(Integer.parseInt(tfDNI.getText()));
					persona.setEdad(Integer.parseInt(tfEdad.getText()));
					persona.setNombre(tfNombre.getText());
					persona.setApellido(tfApellido.getText());
					persona.setPeso(Double.parseDouble(spPeso.getValue().toString()));
					persona.setAltura(Double.parseDouble(spAltura.getValue().toString()));
					persona.setSexo(combo.getSelectedItem().toString());

					//Se agrega la persona la lista dinamica creada en los atributos locales de la Clase.
					listPersonas.add(persona);
					
					//Popup de aviso que la persona fue registrada con exito.
					JOptionPane.showMessageDialog(contentPane, "Se registro una persona");
				}
			}
		});
		btnRegistrar.setBounds(40, 345, 89, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Este ActionListener limpa todos los campos dejandolos vacios.
				tfDNI.setText("");
				tfNombre.setText("");
				tfApellido.setText("");
				tfEdad.setText("");
				spAltura.setValue(0.0);
				spPeso.setValue(0.0);
				combo.setSelectedIndex(0);
			}
		});
		btnLimpiar.setBounds(148, 345, 89, 23);
		contentPane.add(btnLimpiar);
		
		JButton btnVerRegistros = new JButton("Ver Registros");
		btnVerRegistros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Este ActionListener instancia la clase Registro pasandole como parametro la lista de las personas registradas
				//Ya que al hacer dispose todo lo que tenga esta ventana en memoria se elimina, debemos conservar esa lista.
				Registro registro = new Registro(listPersonas);
				//Se hace visible al nuevo JFrame.
				registro.setVisible(true);
				//Se cierra la ventana actual.
				dispose();
			}
		});
		btnVerRegistros.setBounds(256, 345, 113, 23);
		contentPane.add(btnVerRegistros);
	}
	
	//Este metodo carga el comboBox anadiendole 3 items y retornando un objeto.
	public JComboBox<String> cargarCombo() {
		combo = new JComboBox<String>();
		
		combo.addItem("Masculino");
		combo.addItem("Femenino");
		combo.addItem("Otro");
		
		return combo;
	}
	
	//Este setter es utilizado en el siguiente JFrame para poder pasar la lista entre los JFrame.
	public void setLista(List<Persona> lista) {
		this.listPersonas = lista;
	}
}
