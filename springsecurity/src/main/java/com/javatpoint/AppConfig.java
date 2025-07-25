package com.javatpoint;    
import org.springframework.context.annotation.Bean;    
import org.springframework.context.annotation.ComponentScan;    
import org.springframework.context.annotation.Configuration;    
import org.springframework.web.servlet.config.annotation.EnableWebMvc;    
import org.springframework.web.servlet.view.InternalResourceViewResolver;    
import org.springframework.web.servlet.view.JstlView;    
@EnableWebMvc    
@Configuration    
@ComponentScan({ "com.javatpoint.controller.*" })    
public class AppConfig {    
    @Bean    
    public InternalResourceViewResolver viewResolver() {    
        InternalResourceViewResolver viewResolver    
                          = new InternalResourceViewResolver();    
        //viewResolver.setViewClass(JstlView.class);    
        viewResolver.setPrefix("/WEB-INF/views/");    
        viewResolver.setSuffix(".jsp");    
        return viewResolver;    
    }    
}    