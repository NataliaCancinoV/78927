package mx.uv.practica05;

//import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

//import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
@EnableWs
@Configuration
public class SaludosConf extends WsConfigurerAdapter{
    @Bean
    public XsdSchema saludoSchema(){
        return new SimpleXsdSchema(new ClassPathResource("saludos.xsd"));
    }
    //APLICATION CONTEXT ES EL ENTORNO DONDE SE VA A EJECUTAR
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformSchemaLocations(true);

        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }
    //METODO QUE HACE QUE SE EXPONGA EL WEB SERVICE
    @Bean(name = "saludos")
    public DefaultWsdl11Definition defaultWsdl11Definition (XsdSchema saludoSchema){
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("saludosPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("t4is.uv.mx/saludos");
        wsdl.setSchema(saludoSchema);
        return wsdl;
    } 
}

