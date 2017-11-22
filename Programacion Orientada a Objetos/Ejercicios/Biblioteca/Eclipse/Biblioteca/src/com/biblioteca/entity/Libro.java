package com.biblioteca.entity;

public class Libro {
	private int idLibro;
	private String nombre;
	private String descripcion;
	private int nro_paginas;

	private Autor autor;

	public Libro() {

	}

	public Libro(String nombre, String descripcion, int nro_paginas, Autor autor) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.nro_paginas = nro_paginas;
		this.autor = autor;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNro_paginas() {
		return nro_paginas;
	}

	public void setNro_paginas(int nro_paginas) {
		this.nro_paginas = nro_paginas;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
