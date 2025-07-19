package com.javatpoint.entity;

public class Usuario {

	// Variable est�tica para generar IDs �nicos.
	// Se inicializa en 1 y se incrementa cada vez que se crea un nuevo usuario.
	private static Long nextId = 1L;

	// atributos
	private Long id;
	private String nombreUsuario;
	private String contrasena;
	private String tipo; // "ADMIN" o "CLIENTE"

	// Constructor
	public Usuario(String nombreUsuario, String contrasena, String tipo) {

		// Asignar el ID y luego incrementarlo para el pr�ximo usuario
		this.id = ++nextId; // Incrementa nextId y luego lo asigna
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;

		// Validar el tipo al construir el objeto
		if ("ADMIN".equalsIgnoreCase(tipo) || "CLIENTE".equalsIgnoreCase(tipo)) {
			this.tipo = tipo.toUpperCase(); // Almacenar en may�sculas para consistencia
		} else {
			// tirar una excepcione en el futuro?
		}
	}

	// Getters y Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getTipo() {
		return tipo;
	}

	// Setter para el tipo con validaci�n
	public void setTipo(String tipo) {
		if ("ADMIN".equalsIgnoreCase(tipo) || "CLIENTE".equalsIgnoreCase(tipo)) {
			this.tipo = tipo.toUpperCase();
		} else {
			// tirar una excepcione en el futuro?
		}
	}

	// Opcional: Metodo para verificar si es administrador
	public boolean isAdmin() {
		return "ADMIN".equals(this.tipo);
	}

	// Opcional: Metodo para verificar si es cliente
	public boolean isCliente() {
		return "CLIENTE".equals(this.tipo);
	}
}
