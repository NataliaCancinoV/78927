using System;
using System.ServiceModel;

namespace WSDL.calculadora {
    [ServiceContract]
    public interface Calculadora {
        [OperationContract]
        int Suma(int x, int y);
        [OperationContract]
        int Resta(int x, int y);
        [OperationContract]
        int Multiplicacion(int x, int y);
        [OperationContract]
        double Division(double x, double y);
    }
}