package com.germanavalos.object;

public class Venta {
	
	private String producto;
	private double precio;
	private int cantidad;
	private String pago;
	
	public Venta() {
		
	}
	
	public Venta(String producto, double precio, int cantidad, String pago) {
		this.producto = producto;
		this.precio = precio;
		this.cantidad = cantidad;
		this.pago = pago;
	}
	
	public String getProducto() {
		return producto;
	}
	
	public void setProducto(String producto) {
		this.producto = producto;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public String getPago() {
		return pago;
	}
	
	public void setPago(String pago) {
		this.pago = pago;
	}
	
}
