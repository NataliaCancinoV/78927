package mx.uv.practica07;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class clienteConf {
    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // revisar en el pom.xml <packageName>
        marshaller.setContextPath("xx.mx.uv.consumo.wsdl");
        return marshaller;
    }

    @Bean
    public ClaseCliente cliente(Jaxb2Marshaller marshaller){
        ClaseCliente c = new ClaseCliente();
        // URI donde está el servicio
        c.setDefaultUri("http://localhost:8080/ws/saludos");
        c.setMarshaller(marshaller);
        c.setUnmarshaller(marshaller);
        return c;
    }
}
