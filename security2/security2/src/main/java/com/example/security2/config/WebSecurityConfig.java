
package com.example.security2.config;

import java.util.List;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		//http.cors(c -> {})	
		//http.csrf((c)->c.disable()); 
		//stateless, never, if required
		//http.sessionManagement((s)-> s.sessionCreationPolicy(SessionCreationPolicy.NEVER));//create a session but only one
		http.authorizeHttpRequests((req)->
		req.requestMatchers("/register","/public","/error","/save","/csrf").permitAll()    //error page is inbuilt\
		.requestMatchers("/delete", "/findAll").hasRole("ADMIN")
		//.requestMatchers("/update").hasAllRoles("ADMIN", "USER")//works when both are there
		.requestMatchers("/delete", "/findAll").hasAuthority("ADMIN") //kinda same like hasRole
		
		.requestMatchers("/update").hasAnyRole("ADMIN", "USER")
		.anyRequest().authenticated());
		http.formLogin(Customizer.withDefaults());
		http.httpBasic(Customizer.withDefaults());
		http.headers(Customizer.withDefaults());
		return http.build();
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();//encrypts and decrypts
		
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(List.of("http://localhost:3000"));
		config.setAllowedMethods(List.of("GET","POST","PUT","DELETE"));
		config.setAllowedHeaders(List.of("*"));
		config.setAllowCredentials(true);
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return (CorsConfigurationSource) source;
		
	}
	
}
