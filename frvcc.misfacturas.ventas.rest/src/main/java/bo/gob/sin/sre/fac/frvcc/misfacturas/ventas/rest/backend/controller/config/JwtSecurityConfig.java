package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.rest.backend.controller.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import bo.gob.sin.str.caut.security.jwt.JwtAuthenticationEntryPoint;
import bo.gob.sin.str.caut.security.jwt.JwtAuthenticationProvider;
import bo.gob.sin.str.caut.security.jwt.JwtAuthenticationTokenFilter;
import bo.gob.sin.str.caut.security.jwt.JwtSuccessHandler;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {

	private final JwtAuthenticationProvider authenticationProvider;

	private final JwtAuthenticationEntryPoint entryPoint;

	public JwtSecurityConfig(JwtAuthenticationProvider authenticationProvider, JwtAuthenticationEntryPoint entryPoint) {
		this.authenticationProvider = authenticationProvider;
		this.entryPoint = entryPoint;
	}

	@Bean
	public AuthenticationManager authenticationManager() {
		return new ProviderManager(Collections.singletonList(authenticationProvider));
	}

	@Bean
	public JwtAuthenticationTokenFilter authenticationTokenFilter() {
		JwtAuthenticationTokenFilter vFilter = new JwtAuthenticationTokenFilter();
		vFilter.setAuthenticationManager(authenticationManager());
		vFilter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
		return vFilter;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().antMatchers("**/rest/**").authenticated().and().exceptionHandling()
				.authenticationEntryPoint(entryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		http.headers().cacheControl();

	}
}
