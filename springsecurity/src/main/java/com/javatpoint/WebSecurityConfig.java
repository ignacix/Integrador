package com.javatpoint;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.javatpoint.TipoUsuario;

@EnableWebSecurity
@ComponentScan("com.javatpoint")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

		// Usuario administrador
		manager.createUser(
				User.withDefaultPasswordEncoder().username("admin").password("admin123").roles("ADMIN").build());

		// Usuarios clientes basados en los DNI de los clientes hardcodeados
		manager.createUser(
				User.withDefaultPasswordEncoder().username("12345678").password("juan123").roles("USER").build()); // Juan
																													// Pérez

		manager.createUser(
				User.withDefaultPasswordEncoder().username("87654321").password("maria123").roles("USER").build()); // María
																													// García

		manager.createUser(
				User.withDefaultPasswordEncoder().username("11223344").password("carlos123").roles("USER").build()); // Carlos
																														// López

		manager.createUser(
				User.withDefaultPasswordEncoder().username("44332211").password("ana123").roles("USER").build()); // Ana
																													// Martínez

		manager.createUser(
				User.withDefaultPasswordEncoder().username("55667788").password("luis123").roles("USER").build()); // Luis
																													// Rodríguez

		return manager;
	}

	@Bean
	public TipoUsuario tipoUsuario() {
		return new TipoUsuario();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/index", "/login").permitAll() // Agregado "/"
				.antMatchers("/admin").hasRole("ADMIN").antMatchers("/user").hasRole("USER").anyRequest()
				.authenticated() // Agregado para mayor seguridad
				.and().formLogin().loginPage("/login").loginProcessingUrl("/login").successHandler(tipoUsuario())
				.permitAll().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/").permitAll();
	}
}