public class calculadoraArea {
    public calculadoraArea(){
    }
    public int areaRectangulo(int base, int altura) {
        return base * altura;
    }
    public int areaCuadrado(int lado1, int lado2){
        return lado1 * lado2;
    }
    public float areaCirculo(int radio){
        float pi = (float) 3.1416;
        return pi * (radio * radio);
    }
}