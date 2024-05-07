package mx.uv.practica07;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import xx.mx.uv.consumo.wsdl.SaludarResponse;

@SpringBootApplication
public class Practica07Application {

	public static void main(String[] args) {
		SpringApplication.run(Practica07Application.class, args);
	}

	@Bean
	public CommandLineRunner ejecutar(ClaseCliente cliente){
		return x -> {
			// valor por omisión
			String nombre="rafael";
			if (x.length >0){
				nombre = x[0];
			}
			SaludarResponse sr = cliente.x(nombre);
			System.err.println(sr.getRespuesta());
		};
	}

}
