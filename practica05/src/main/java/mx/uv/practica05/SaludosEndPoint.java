package mx.uv.practica05;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import mx.uv.t4is.saludos.SaludarRequest;
import mx.uv.t4is.saludos.SaludarResponse;

@Endpoint
public class SaludosEndPoint {

    @PayloadRoot(localPart = "SaludarRequest", namespace = "t4is.uv.mx/saludos")

    @ResponsePayload
    public SaludarResponse Saludar(@RequestPayload SaludarRequest peticion){
        SaludarResponse respuesta = new SaludarResponse();
        respuesta.setRespuesta("Hola" + peticion.getNombre());
        return respuesta;
    }
}

