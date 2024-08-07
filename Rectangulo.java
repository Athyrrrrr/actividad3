package actividad3;
public class Rectangulo {
    int base; // Atributo que define la base de un rectángulo
    int altura; // Atributo que define la altura de un rectángulo

    Rectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
        }

    double calcularArea() {
        return base * altura;
    }

    double calcularPerimetro() {
        return (2 * base) + (2 * altura);
    }
}