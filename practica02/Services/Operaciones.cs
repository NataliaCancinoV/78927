using System;
using WSDL.mensajes;

namespace WSDL.operaciones{
    public class Operaciones : Mensajes{
        List<string> id = new List<string>();
        public string Saludar (string nombre){
            string msj = "Hola " + nombre;
            id.Add(nombre);
            return msj;
        }
        public string Mostrar(string id){
            string nombres = string.Join(" ", id);
            return nombres;
            
        }
        //agregamos operaciones de manera que todos los nombre que vaya saludando 
        //se vayan almacenando y cuando se muestre le damos un indice del arreglo
        //ejemplo en un arreglo
    }
}