package com.sgp.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



@Configuration
@EnableWebSecurity 
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserPrincipalDetailsService userPrincipalDetailsService;
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	DaoAuthenticationProvider authenticationProvider(){
		  DaoAuthenticationProvider daoAuthenticationProvider = new  DaoAuthenticationProvider();
		  //daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		  daoAuthenticationProvider.setPasswordEncoder(encoder());
		  daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);
		  
		  return daoAuthenticationProvider; }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}


	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
        		.headers()
        			.frameOptions().sameOrigin()
        			.and()
	        	.authorizeRequests()
	                .antMatchers("/bootstrap/**", "/error", "/dist/**", "/plugins/**", "/Registre/**", "/reset_password/**", "/user/**", "/forgot_password/**").permitAll()
	                .anyRequest().authenticated()
	                .and()
	            .formLogin()
	                .failureUrl("/login?error")
	                .loginPage("/login")
	                .defaultSuccessUrl("/")
	                .permitAll()
	                .and()
	            .logout()
	                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	                .logoutSuccessUrl("/login")
	                .permitAll();
	          
	    }
	 
	    PersistentTokenRepository persistentTokenRepository(){
	    	JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
	    	tokenRepositoryImpl.setDataSource(dataSource);
	    	return tokenRepositoryImpl;
	    }
}
