package com.germanavalos.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.germanavalos.object.Venta;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerTodas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo;
	

	public VerTodas(List<Venta> ventas) {
		setTitle("Ver Ventas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 278);
		contentPane.add(scrollPane);
		
		table = new JTable();
		String[] titulo = {"Producto", "Precio", "Cantidad", "Pago", "Total"};
		modelo = new DefaultTableModel(null, titulo);
		
		cargarTodas(ventas);
		
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventas ventasv = new Ventas();
				ventasv.setVentas(ventas);
				ventasv.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(10, 300, 89, 23);
		contentPane.add(btnVolver);
		
	}
	
	public void cargarTodas(List<Venta> ventas) {
		String[] fila = new String[5];
		
		for (Venta venta : ventas) {
			fila[0] = venta.getProducto();
			fila[1] = String.valueOf(venta.getPrecio());
			fila[2] = String.valueOf(venta.getCantidad());
			fila[3] = venta.getPago();
			fila[4] = String.valueOf(venta.getTotal());
			modelo.addRow(fila);
		}
	}
}
