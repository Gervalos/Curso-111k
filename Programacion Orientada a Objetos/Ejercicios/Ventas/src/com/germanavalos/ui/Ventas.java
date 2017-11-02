package com.germanavalos.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.germanavalos.object.Venta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Ventas extends JFrame {

	private JPanel contentPane;
	private JTextField tfPrecio;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tfTotal;
	private JComboBox<String> cbProductos;
	private JSpinner spCantidad;
	private JRadioButton radioContado;
	private JRadioButton radioTarjeta;
	private JButton btnCalcular;
	
	private List<Venta> ventas = new ArrayList<>();

	public Ventas() {
		setTitle("Ventas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProducto.setBounds(10, 11, 110, 22);
		contentPane.add(lblProducto);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrecio.setBounds(10, 44, 110, 22);
		contentPane.add(lblPrecio);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidad.setBounds(10, 77, 110, 22);
		contentPane.add(lblCantidad);
		
		JLabel lblPago = new JLabel("Pago:");
		lblPago.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPago.setBounds(10, 119, 110, 22);
		contentPane.add(lblPago);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTotal.setBounds(10, 162, 110, 22);
		contentPane.add(lblTotal);
		
		cbProductos = new JComboBox();
		cbProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pr = cbProductos.getSelectedItem().toString();
				double precio = 0;
				for (String[] valor : cargarArreglo()) {
					if (valor[0].equals(pr)) {
						precio = Double.parseDouble(valor[1]);
					}
				}
				tfPrecio.setText(String.valueOf(precio));
				vaciarConCombo();
			}
		});
		cbProductos.setBounds(96, 11, 184, 20);
		contentPane.add(cbProductos);
		
		tfPrecio = new JTextField();
		tfPrecio.setEditable(false);
		tfPrecio.setBounds(96, 42, 184, 20);
		contentPane.add(tfPrecio);
		tfPrecio.setColumns(10);
		
		spCantidad = new JSpinner();
		spCantidad.setBounds(96, 75, 184, 20);
		contentPane.add(spCantidad);
		
		radioTarjeta = new JRadioButton("Tarjeta");
		buttonGroup.add(radioTarjeta);
		radioTarjeta.setBounds(96, 132, 109, 23);
		contentPane.add(radioTarjeta);
		
		radioContado = new JRadioButton("Contado");
		buttonGroup.add(radioContado);
		radioContado.setBounds(96, 106, 109, 23);
		contentPane.add(radioContado);
		
		tfTotal = new JTextField();
		tfTotal.setEditable(false);
		tfTotal.setBounds(96, 164, 81, 20);
		contentPane.add(tfTotal);
		tfTotal.setColumns(10);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double precio = Double.parseDouble(tfPrecio.getText());
				int cantidad = Integer.parseInt(spCantidad.getValue().toString());
				if (!verificarVacios()) {
					if (cantidad != 0) {
						double total = precio*cantidad;
						if (radioContado.isSelected()) {
							total = total - (total * 0.1);
						}
						else {
							total = total + (total * 0.1);
						}
						tfTotal.setText(String.valueOf(total));
					}
				}
				else {
					System.out.println("sali");
				}
			}
		});
		btnCalcular.setBounds(187, 163, 93, 23);
		contentPane.add(btnCalcular);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(10, 216, 75, 23);
		contentPane.add(btnVolver);
		
		JButton btnVerTodos = new JButton("Ver Todos");
		btnVerTodos.setBounds(96, 216, 85, 23);
		contentPane.add(btnVerTodos);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verificarVacios();
				Venta venta = new Venta();
				venta.setProducto(cbProductos.getSelectedItem().toString());
				venta.setCantidad(Integer.parseInt(spCantidad.getValue().toString()));
				if (radioTarjeta.isSelected()) {
					venta.setPago("Tarjeta");
				}
				else {
					venta.setPago("Contado");
				}
				venta.setPrecio(Double.parseDouble(tfPrecio.getText()));
				venta.setTotal(Double.parseDouble(tfTotal.getText()));
				
				ventas.add(venta);
				
				JOptionPane.showMessageDialog(contentPane, "Se agrego correctamente");
			}
		});
		btnAgregar.setBounds(191, 216, 89, 23);
		contentPane.add(btnAgregar);
		
		cargarCombo();
	}
	
	public String[][] cargarArreglo() {
		String[][] productos = new String[5][2];
		productos[0][0] = "Teclado USB";
		productos[0][1] = "100";
		
		productos[1][0] = "Mouse USB";
		productos[1][1] = "50";
		productos[2][0] = "Monitor 19" + '"';
		productos[2][1] = "2500";
		productos[3][0] = "Intel i3";
		productos[3][1] = "2000";
		productos[4][0] = "AMD Phenom X4";
		productos[4][1] = "1500";
		
		return productos;
	}
	
	public void cargarCombo() {
		String[][] productos = cargarArreglo();
		for (int i = 0; i < 5; i++) {
			cbProductos.addItem(productos[i][0]);
		}
	}
	
	public boolean verificarVacios() {
		if (spCantidad.getValue().toString().equals("0")) {
			JOptionPane.showMessageDialog(contentPane, "No ingreso una cantidad");
			return true;
		}
		else if (!radioContado.isSelected() && !radioTarjeta.isSelected()) {
			JOptionPane.showMessageDialog(contentPane, "No se ingreso un metodo de pago");
			return true;
		}
		else if (radioContado.isSelected() || radioTarjeta.isSelected()) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void vaciarConCombo() {
		tfTotal.setText("");
		spCantidad.setValue(0);
	}
	
}
