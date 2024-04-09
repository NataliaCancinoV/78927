using System;
using imensajes;

namespace mensajes{
    public class Mensajes : iMensajes {
        public string saludar(string nombre){
            return "hola"+nombre;
        }
        public string mostrar(string nombre){
            return "x";
        }
    }
}
