package com.javatpoint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javatpoint.entity.Cliente;
import com.javatpoint.entity.Prestamo;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

	// Método para inicializar datos hardcodeados (se ejecuta al inicio)
	static {
		inicializarDatos();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Model model) {
		// Obtener usuario logueado
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		model.addAttribute("usuario", "Admin " + username);

		// Obtener todos los clientes hardcodeados
		List<Cliente> clientes = Cliente.getListaClientes();
		model.addAttribute("clientes", clientes);

		return "admin";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(Model model) {
	    // Obtengo usuario solo para el saludo
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    model.addAttribute("usuario", "Cliente " + username);

	    // Cargo **todos** los pr�stamos hardcodeados
	    List<Prestamo> todosLosPrestamos = Prestamo.getListaPrestamos();
	    model.addAttribute("prestamos", todosLosPrestamos);

	    // Opcional: nombre gen�rico o del primer cliente
	    Cliente primerCliente = Cliente.getListaClientes().isEmpty() 
	        ? null 
	        : Cliente.getListaClientes().get(0);
	    String clienteNombre = primerCliente != null
	        ? primerCliente.getNombre() + " " + primerCliente.getApellido()
	        : "Invitado";
	    model.addAttribute("clienteNombre", clienteNombre);

	    return "user";
	}

	// Método para inicializar datos hardcodeados
	private static void inicializarDatos() {
		// Crear clientes hardcodeados
		Cliente cliente1 = new Cliente("12345678", "Juan", "Pérez", "Av. Corrientes 1234", "1001", "Buenos Aires",
				"Argentina", LocalDate.of(1985, 5, 15), "juan.perez@email.com", "11-4567-8901", true);

		Cliente cliente2 = new Cliente("87654321", "María", "García", "Av. Santa Fe 5678", "1002", "Buenos Aires",
				"Argentina", LocalDate.of(1990, 8, 22), "maria.garcia@email.com", "11-9876-5432", true);

		Cliente cliente3 = new Cliente("11223344", "Carlos", "López", "Av. Rivadavia 9101", "1003", "Buenos Aires",
				"Argentina", LocalDate.of(1978, 12, 3), "carlos.lopez@email.com", "11-1122-3344", false);

		Cliente cliente4 = new Cliente("44332211", "Ana", "Martínez", "Av. Belgrano 1121", "1004", "Buenos Aires",
				"Argentina", LocalDate.of(1992, 3, 10), "ana.martinez@email.com", "11-4433-2211", true);

		Cliente cliente5 = new Cliente("55667788", "Luis", "Rodríguez", "Av. Callao 3141", "1005", "Buenos Aires",
				"Argentina", LocalDate.of(1988, 7, 25), "luis.rodriguez@email.com", "11-5566-7788", true);

		// Agregar clientes a la lista estática
		Cliente.getListaClientes().add(cliente1);
		Cliente.getListaClientes().add(cliente2);
		Cliente.getListaClientes().add(cliente3);
		Cliente.getListaClientes().add(cliente4);
		Cliente.getListaClientes().add(cliente5);

		// Crear préstamos hardcodeados
		Prestamo prestamo1 = new Prestamo(1, LocalDate.of(2024, 1, 15), cliente1, 50000.0f, 12, true);

		Prestamo prestamo2 = new Prestamo(2, LocalDate.of(2023, 6, 1), cliente1, 200000.0f, 240, true);

		Prestamo prestamo3 = new Prestamo(3, LocalDate.of(2024, 3, 10), cliente2, 80000.0f, 60, true);

		Prestamo prestamo4 = new Prestamo(4, LocalDate.of(2024, 2, 20), cliente2, 35000.0f, 18, true);

		Prestamo prestamo5 = new Prestamo(5, LocalDate.of(2024, 4, 5), cliente4, 75000.0f, 36, true);

		Prestamo prestamo6 = new Prestamo(6, LocalDate.of(2023, 12, 10), cliente5, 120000.0f, 84, true);

		// Agregar préstamos a la lista estática
		Prestamo.getListaPrestamos().add(prestamo1);
		Prestamo.getListaPrestamos().add(prestamo2);
		Prestamo.getListaPrestamos().add(prestamo3);
		Prestamo.getListaPrestamos().add(prestamo4);
		Prestamo.getListaPrestamos().add(prestamo5);
		Prestamo.getListaPrestamos().add(prestamo6);
	}
}