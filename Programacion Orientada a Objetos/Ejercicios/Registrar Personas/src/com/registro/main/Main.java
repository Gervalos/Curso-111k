package com.registro.main;

import java.awt.EventQueue;
import com.registro.ui.Principal;

//Esta Clase contiene el metodo de entrada que instancia la clase Principal para que muestre primero
public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
