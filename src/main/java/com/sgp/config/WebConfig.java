package com.sgp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;





@Configuration
public class WebConfig implements WebMvcConfigurer {
	
   @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("dashboard");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/403").setViewName("403");
        

    }

    @Bean
	public SpringSecurityDialect securityDialect() {
	    return new SpringSecurityDialect();
	}
    
   
    
    @Bean
    public SessionRegistry sessionRegistry() 
    { return new SessionRegistryImpl(); }
}
