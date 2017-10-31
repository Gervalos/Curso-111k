package com.registro.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.registro.objetos.Persona;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo;

	//Este Constructor obtiene como parametro una lista proveniente de JFrame Principal.
	public Registro(List<Persona> lista) {
		setTitle("Ver Registros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVerRegistros = new JLabel("Ver Registros");
		lblVerRegistros.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerRegistros.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVerRegistros.setBounds(144, 11, 125, 32);
		contentPane.add(lblVerRegistros);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 52, 375, 294);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		String[] titulo = {"DNI", "Nombre", "Apellido", "Edad", "Altura", "Peso", "Sexo"};
		modelo = new DefaultTableModel(null, titulo);
		cargarTabla(lista);
		table.setModel(modelo);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Este action listener vuelve al JFrame anterior donde se le setea la lista actual para no perderla en el pase.
				Principal principal = new Principal();
				principal.setLista(lista);
				principal.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(10, 358, 89, 23);
		contentPane.add(btnVolver);
	}
	
	//Este metodo nos carga la tabla.
	public void cargarTabla(List<Persona> lista) {
		if (lista != null) {
			String[] fila = new String[7];
			for (Persona persona : lista) {
				fila[0] = String.valueOf(persona.getDni());
				fila[1] = persona.getNombre();
				fila[2] = persona.getApellido();
				fila[3] = String.valueOf(persona.getEdad());
				fila[4] = String.valueOf(persona.getAltura());
				fila[5] = String.valueOf(persona.getPeso());
				fila[6] = persona.getSexo();
				modelo.addRow(fila);
			}
		}
	}
}
