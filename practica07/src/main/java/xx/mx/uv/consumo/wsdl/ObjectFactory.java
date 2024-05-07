
package xx.mx.uv.consumo.wsdl;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the xx.mx.uv.consumo.wsdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BuscarSaludosRequest_QNAME = new QName("t4is.uv.mx/saludos", "BuscarSaludosRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: xx.mx.uv.consumo.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BuscarSaludosResponse }
     * 
     */
    public BuscarSaludosResponse createBuscarSaludosResponse() {
        return new BuscarSaludosResponse();
    }

    /**
     * Create an instance of {@link SaludarRequest }
     * 
     */
    public SaludarRequest createSaludarRequest() {
        return new SaludarRequest();
    }

    /**
     * Create an instance of {@link SaludarResponse }
     * 
     */
    public SaludarResponse createSaludarResponse() {
        return new SaludarResponse();
    }

    /**
     * Create an instance of {@link BuscarSaludosResponse.Saludos }
     * 
     */
    public BuscarSaludosResponse.Saludos createBuscarSaludosResponseSaludos() {
        return new BuscarSaludosResponse.Saludos();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "t4is.uv.mx/saludos", name = "BuscarSaludosRequest")
    public JAXBElement<Object> createBuscarSaludosRequest(Object value) {
        return new JAXBElement<Object>(_BuscarSaludosRequest_QNAME, Object.class, null, value);
    }

}
