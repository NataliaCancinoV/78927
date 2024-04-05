using System;
using WSDL.mensajes;

namespace WSDL.operaciones{
    public class Operaciones : Mensajes{
        List<string> nombres = new List<string>();
        public string Saludar (string nombre){
            string msj = "Hola " + nombre;
            nombres.Add(nombre);
            return msj;
        }
        public string Mostrar(string id){
            string listaNombres = string.Join(" ", nombres);
            return listaNombres;
        }
        //agregamos operaciones de manera que todos los nombre que vaya saludando 
        //se vayan almacenando y cuando se muestre le damos un indice del arreglo
        //ejemplo en un arreglo
    }
}