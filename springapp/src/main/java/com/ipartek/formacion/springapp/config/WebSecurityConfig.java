package com.ipartek.formacion.springapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig {
	// AUTENTICACIÓN
	private DataSource dataSource;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
	  throws Exception {
	    auth
	    	.jdbcAuthentication()
	    	.dataSource(dataSource)
	    	.passwordEncoder(passwordEncoder)
	    	.usersByUsernameQuery("""
SELECT email, password, 1
FROM usuarios
WHERE email=?
""")
	    	.authoritiesByUsernameQuery("""
SELECT email, CONCAT('ROLE_', rol)
FROM usuarios
WHERE email=? 
""");
	}
	
	// AUTORIZACIÓN
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// TODO: Configurar CSRF y CORS
		http.csrf(c -> c.disable());
		
		http.cors(cors -> cors.configurationSource(request -> {
			var config = new org.springframework.web.cors.CorsConfiguration();
			config.setAllowedOrigins(java.util.List.of("*"));
			config.setAllowedMethods(java.util.List.of("*"));
			config.setAllowedHeaders(java.util.List.of("*"));
			return config;
		}));

		http.authorizeHttpRequests(requests -> requests
				.requestMatchers("/admin/**").hasRole("ADMINISTRADOR")
				.requestMatchers("/detalle").authenticated() //hasAnyRole("USUARIO", "ADMINISTRADOR")
				.anyRequest().permitAll()
			)
			.formLogin(form -> form
				.loginPage("/login")
				.permitAll()
			)
			.logout(LogoutConfigurer::permitAll);

		return http.build();
	}

}