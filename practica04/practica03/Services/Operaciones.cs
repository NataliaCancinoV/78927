using System;
using WSDL.calculadora;

namespace WSDL.operaciones{
    public class Operaciones : Calculadora{
        public int Suma (int x, int y){
            return x + y;
        }
        public int Resta(int x, int y){
            return x - y;
        }
        public int Multiplicacion(int x, int y){
            return x * y;
        }
        public double Division(double x, double y){
            return x / y;
        }
    }
}