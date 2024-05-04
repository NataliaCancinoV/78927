package mx.uv.practica06;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import mx.uv.t4is.conversiones.ConversionFahrenheitACelsiusRequest;
import mx.uv.t4is.conversiones.ConversionFahrenheitACelsiusResponse;
import mx.uv.t4is.conversiones.ConversionCelsiusAFahrenheitRequest;
import mx.uv.t4is.conversiones.ConversionCelsiusAFahrenheitResponse;
import mx.uv.t4is.conversiones.HistorialConversionesResponse;
import mx.uv.t4is.conversiones.HistorialConversionesResponse.Conversiones;

@Endpoint
public class ConversionesEndPoint {
    List<Conversiones> conversionesFC = new ArrayList<>();

    @PayloadRoot(localPart = "ConversionFahrenheitACelsiusRequest", namespace = "t4is.uv.mx/conversiones")

    @ResponsePayload
    public ConversionFahrenheitACelsiusResponse Conversion(@RequestPayload ConversionFahrenheitACelsiusRequest peticion){
        ConversionFahrenheitACelsiusResponse respuesta = new ConversionFahrenheitACelsiusResponse();
        double gradosFC = ((peticion.getGradosF() - 32) * 5/9);
        respuesta.setRespuesta(peticion.getGradosF() + " grados Fahrenheit son " + gradosFC + " grados Celsius");
        Conversiones e = new Conversiones();
        e.setId("Fahrenheit a Celsius");
        e.setGradosConvertir(peticion.getGradosF());
        e.setIdConversion("Resultado");
        e.setConversion(gradosFC);
        conversionesFC.add(e);

        return respuesta;
    }

    List<Conversiones> conversionesCF = new ArrayList<>();
    @PayloadRoot(localPart = "ConversionCelsiusAFahrenheitRequest", namespace = "t4is.uv.mx/conversiones")

    @ResponsePayload
    public ConversionCelsiusAFahrenheitResponse Conversion (@RequestPayload ConversionCelsiusAFahrenheitRequest peticion){
       ConversionCelsiusAFahrenheitResponse respuesta = new ConversionCelsiusAFahrenheitResponse();
        double gradosCF = (peticion.getGradosC() * 9/5) + 32;
        respuesta.setRespuesta(peticion.getGradosC() + " grados Celsius son " + gradosCF + " grados Fahrenheit");
        Conversiones e = new Conversiones();
        e.setId("Celsius a Fahrenheit");
        e.setGradosConvertir(peticion.getGradosC());
        e.setIdConversion("Resultado");
        e.setConversion(gradosCF);
        conversionesCF.add(e);

        return respuesta;
    }

    List<Conversiones> conversionesUnidas = new ArrayList<>();

    @PayloadRoot(localPart = "HistorialConversionesRequest", namespace = "t4is.uv.mx/conversiones")
    @ResponsePayload //con esto lo que devuelve serializado
    public HistorialConversionesResponse historialConversiones(){
        HistorialConversionesResponse respuesta = new HistorialConversionesResponse();
        conversionesUnidas.addAll(conversionesFC);
        conversionesUnidas.addAll(conversionesCF);
        respuesta.getConversiones().addAll(conversionesUnidas);
        return respuesta;
    }
}
