package mx.uv.practica06;

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
public class ConversionesConf extends WsConfigurerAdapter{
    @Bean
    public XsdSchema saludosSchema(){
        return new SimpleXsdSchema(new ClassPathResource("conversiones.xsd"));
    }
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServler(ApplicationContext applicationContext){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }
    @Bean(name="conversiones")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema conversionSchema){
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("conversionesPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("t4is.uv.mx/conversiones");
        wsdl.setSchema(conversionSchema);
        return wsdl;
    }
    
}

