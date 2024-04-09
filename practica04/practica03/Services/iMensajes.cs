using System;
using System.ServiceModel;

namespace imensajes{
    [ServiceContract]
    public interface iMensajes{
        [OperationContract]
        string saludar(string nombre);
        string mostrar(string nombre);
    }
}