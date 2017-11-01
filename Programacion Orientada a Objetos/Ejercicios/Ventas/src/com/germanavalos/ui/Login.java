package com.germanavalos.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsuario;
	private JTextField tfClave;

	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 372, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Login", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 336, 183);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuario.setBounds(26, 48, 88, 20);
		panel.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClave.setBounds(26, 94, 72, 20);
		panel.add(lblClave);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(108, 51, 203, 20);
		panel.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		tfClave = new JTextField();
		tfClave.setBounds(108, 94, 203, 20);
		panel.add(tfClave);
		tfClave.setColumns(10);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setBounds(58, 149, 89, 23);
		panel.add(btnSalir);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfClave.getText().equals("") && tfUsuario.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "No ingreso usuario y clave");
				}
				else if (tfClave.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "No ingreso clave");
				}
				else if (tfUsuario.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "No ingreso usuario");
				}
				else {
					if (tfUsuario.getText().equals("admin") && tfClave.getText().equals("1234")) {
						JOptionPane.showMessageDialog(contentPane, "Bienvenido");
						Ventas venta = new Ventas();
						venta.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "Error de usuario y clave");
					}
				}
			}
		});
		btnIngresar.setBounds(192, 149, 89, 23);
		panel.add(btnIngresar);
	}
}
