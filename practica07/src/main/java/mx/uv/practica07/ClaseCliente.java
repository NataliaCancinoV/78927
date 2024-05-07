package mx.uv.practica07;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import xx.mx.uv.consumo.wsdl.SaludarRequest;
import xx.mx.uv.consumo.wsdl.SaludarResponse;

public class ClaseCliente extends WebServiceGatewaySupport {
    
    public SaludarResponse x (String nombre) {
        SaludarRequest saludo = new SaludarRequest();
        saludo.setNombre(nombre);
        SaludarResponse respuesta = (SaludarResponse) 
        // docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}} - {{range $p, $conf := .NetworkSettings.Ports}}{{(index $conf 0).HostPort}} {{end}}' $(docker ps -aq)
        //getWebServiceTemplate().marshalSendAndReceive("http://172.17.0.2:8080/ws/saludos", saludo,  //en contenedor
        getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws/saludos", saludo,
        new SoapActionCallback(""));
        return respuesta;
    }
}
