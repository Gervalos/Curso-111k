package com.registro.objetos;

public class Persona {
	
	private String nombre, apellido, sexo;
	private double altura, peso;
	private int edad, dni;
	
	public Persona () {
		
	}
	
	public Persona(String nombre, String apellido, String sexo, double altura, double peso, int edad, int dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.altura = altura;
		this.peso = peso;
		this.edad = edad;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
}
