package org.looplegion.app.security;

import org.looplegion.app.security.jwt.JWTAuthenticationFilter;
import org.looplegion.app.security.jwt.JWTAuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;



import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Collections;
import java.util.List;

/**
* @EnableWebSecurity: habilita la configuraci�n de seguridad web 
*   en una aplicaci�n Spring Boot.
* @Configuration: contiene configuraciones para la aplicaci�n, 
*  como definiciones de beans y configuraci�n de componentes, 
*  y que debe ser considerada durante la inicializaci�n del 
*  contexto de la aplicaci�n.
*
*/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	
	// STEP 1 Autenticaci�n basada en usuarios en memoria
/*	@Bean
	UserDetailsService userDetailsService( PasswordEncoder passwordEncoder ) {
		UserDetails sergio = User.builder()
								.username("sergio")
								.password("$2a$10$Su5Y7B0V9ab24ZBUG6OsBOWyzXchSLp6AshwOq6mlDu8rA6zmt2oW") // 123
								.roles("ADMIN") // ROLE_ADMIN
								.build();
		UserDetails tania = User.builder()
								.username("tania")
								.password(passwordEncoder.encode("456"))
								.roles("CUSTOMER") // ROLE_CUSTOMER
								.build();
		UserDetails kristian = User.builder()
								.username("kristian")
								.password(passwordEncoder.encode("789"))// .password("{noop}789")
								.roles("WAREHOUSE") // ROLE_WAREHOUSE
								.build();
		
		return new InMemoryUserDetailsManager(sergio, tania, kristian);
	} */
	
	// STEP 1.1 Crear un bean de PassworsEncoder
	/**
	 *  Crear un bean de BCryptPasswordEncoder.
	 *  BCrypPasswordEncoder es una implementaci�n de PasswordEncoder proporcionada
	 *  por Spring Security. Se utiliza para codificar y verificar contrase�as utilizando
	 *  el algoritmo de hashing bcrypt.
	 *  El algoritmo incorpora un sal aleatoria por cada contrase�a, lo que agrega un capa
	 *  adicional de seguridad.
	 */	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public static void main(String[] args) {
		System.out.println( new BCryptPasswordEncoder().encode("123")  );
	}
	
	
	// STEP 2 Realizar configuraciones personalizadas del filter chain
	@Bean
	SecurityFilterChain filterChain( 
			HttpSecurity http,
			AuthenticationManager authManager,
			JWTAuthorizationFilter jwtAuthorizationFilter
			) throws Exception {
		
		// STEP 7.3 Crear el objeto y la configuraci�n para jwtAuthenticationFilter
		JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
		jwtAuthenticationFilter.setAuthenticationManager(  authManager );
		jwtAuthenticationFilter.setFilterProcessesUrl("/login");
		
		
		// STEP 2.1 Deshabilitar la seguridad
		/*return http
				.authorizeHttpRequests( authorize -> authorize.anyRequest().permitAll() )
				.csrf( csrf-> csrf.disable() )
				.httpBasic( withDefaults() ) 
				.build(); */
		
		// STEP 2.2 PErsonalizar la seguridad en los endpoints
		// TODO cambiar el nombre de los endposint y roles utilizados
		return http
				.cors(cors -> cors.configurationSource(corsConfigurationSource()))
				.authorizeHttpRequests( authorize -> authorize
						.requestMatchers("/", "index.html", "/assets/**","/login").permitAll()
						.requestMatchers(HttpMethod.POST, "/api/v1/users").permitAll()
						.requestMatchers(HttpMethod.GET, "/api/v1/products","/api/v1/products/**","/api/v1/posts","/api/v1/posts/**").permitAll()
						.requestMatchers(HttpMethod.POST, "/api/v1/posts").hasRole("Admin")
						.requestMatchers(HttpMethod.DELETE, "/api/v1/products/**").hasRole("Admin")
						.requestMatchers(HttpMethod.GET, "/api/v1/privileges/**").hasRole("Admin")
						.requestMatchers("/api/v1/users/**",
										"/api/v1/purchases/**",
										"/api/v1/order-has-products/**"
								).hasAnyRole("Admin","User")
						.anyRequest().authenticated()						
						)
				// STEP 7: Agregamos el filtro de autenticaci�n del login
				// interceptar las solicitudes de autenticaci�n 
				// y generamos el token en la respuesta
				.addFilter(jwtAuthenticationFilter)
				// STEP 8: Agregamos el filtro para las demas solicitudes verificando el token JWT
				// Interceptamos las solicitudes , extraemos y validamos el token
				// y autenticamos al usuario
				.addFilterBefore( jwtAuthorizationFilter  ,  UsernamePasswordAuthenticationFilter.class)				
			    // no es necesario almacenar informaci�n de sesi�n en el servidor, 
				// ya que toda la informaci�n necesaria para la autenticaci�n 
				// se encuentra en el token, y cada solicitud es aut�noma.				 
				.sessionManagement(managment -> managment.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.csrf( csrf-> csrf.disable() )
				.httpBasic( withDefaults() ) 
				.build();
		
	}
	
	
	// STEP 3 Autenticaci�n basada en usuarios de la DB
	/** 
	 *  AuthenticationManager: Gestiona las operaciones de autenticaci�n.
	 *  getSharedObject: Obtiene una instancia compartida de AuthenticationManagerBuilder 
	 *  .userDetailsService: Configura el AuthenticationManagerBuilder 
	 *  	para utilizar un servicio de detalles de usuario personalizado.
	 *  userDetailsService: responsable de cargar detalles espec�ficos 
	 *  	del usuario durante el proceso de autenticaci�n.
	 */	
	@Bean
	AuthenticationManager authManager(
				HttpSecurity httpSecurity,
				PasswordEncoder passwordEncoder,
				UserDetailsService userDetailsService
			
			) throws Exception {
		
		AuthenticationManagerBuilder authManagerBuilder = httpSecurity
				.getSharedObject( AuthenticationManagerBuilder.class  );
		
		authManagerBuilder
		 .userDetailsService( userDetailsService ) 
		 .passwordEncoder( passwordEncoder );
		
		return authManagerBuilder.build();
	}
	
	// STEP 6: opcional, configurar los CORS en caso de que no funcione 
	// @CrossOrigin(origins = "*") en los controladores
		@Bean
		CorsConfigurationSource corsConfigurationSource() {
			CorsConfiguration configuration = new CorsConfiguration();
			configuration.setAllowedOrigins( List.of("http://localhost:8081" ) );
			configuration.setAllowedMethods( List.of("GET", "POST", "PUT", "DELETE") );
			configuration.setAllowedHeaders( Collections.singletonList("*"));
			configuration.setAllowedHeaders( List.of("Authorization","Content-Type") );
			configuration.setAllowCredentials(true);
			
			// Para todas las rutas en la aplicaci�n ("/**"), 
			// aplique la configuraci�n CORS definida en el objeto configuration.
			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			source.registerCorsConfiguration("/**", configuration);
			return source;
			
		}
	
	
}