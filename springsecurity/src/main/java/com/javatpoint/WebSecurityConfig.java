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
      manager.createUser(User.withDefaultPasswordEncoder()  
      .username("admin").password("admin123").roles("ADMIN").build());  
      
      manager.createUser(User.withDefaultPasswordEncoder()  
    		 .username("user").password("user123").roles("USER").build()); 
      return manager;    
  }    
  
  @Bean
  public TipoUsuario tipoUsuario() {
      return new TipoUsuario();
  }
  
  
  @Override    
  protected void configure(HttpSecurity http) throws Exception {    
      http.authorizeRequests().  
       antMatchers("/index","/").permitAll()  
      .antMatchers("/login").permitAll()  
      .antMatchers("/admin").hasRole("ADMIN")
      .antMatchers("/user").hasRole("USER")
      .and()  
      .formLogin()
      //.loginPage("/login")
      .loginProcessingUrl("/login")
      .successHandler(tipoUsuario())
      .and()  
      .logout()  
      .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));      
  }

}    