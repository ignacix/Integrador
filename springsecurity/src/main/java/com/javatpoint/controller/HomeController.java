package com.javatpoint.controller;    
    import org.springframework.stereotype.Controller;    
    import org.springframework.web.bind.annotation.RequestMapping;    
    import org.springframework.web.bind.annotation.RequestMethod;    
      
    @Controller    
    public class HomeController {    
            
        @RequestMapping(value="/", method=RequestMethod.GET)    
        public String index() {                  
            return "index";    
        }    
        @RequestMapping(value="/admin", method=RequestMethod.GET)    
        public String admin() {                    
            return "admin";    
        }    
        
        @RequestMapping(value="/login", method=RequestMethod.GET)    
        public String login() {    
            return "login";    
        }    
        
        
        @RequestMapping(value="/user", method=RequestMethod.GET)    
        public String user() {              
            return "user";    
        }    
    } 