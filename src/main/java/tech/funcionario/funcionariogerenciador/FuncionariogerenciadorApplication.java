package tech.funcionario.funcionariogerenciador;

import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


@SpringBootApplication
public class FuncionariogerenciadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuncionariogerenciadorApplication.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguracao = new CorsConfiguration();
		corsConfiguracao.setAllowCredentials(true);
		corsConfiguracao.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguracao.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With", "Access-Control-Request-Method",
				"Access-Control-Request-Headers"));
		corsConfiguracao.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguracao.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBaseCorsConfiguracaoSource = new UrlBasedCorsConfigurationSource();
		urlBaseCorsConfiguracaoSource.registerCorsConfiguration("/**", corsConfiguracao);
		return new CorsFilter(urlBaseCorsConfiguracaoSource);

	}
}
