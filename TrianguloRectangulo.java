package actividad3;

public class TrianguloRectangulo {
    int base; // Atributo que define la base de un triángulo rectángulo
    int altura; // Atributo que define la altura de un triángulo rectángulo

    public TrianguloRectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public double calcularArea() {
        return (base * altura) / 2.0;
    }

    public double calcularPerimetro() {
        return base + altura + calcularHipotenusa();
    }

    public double calcularHipotenusa() {
        return Math.sqrt(base * base + altura * altura);
    }

    public String determinarTipoTriangulo() {
        if (base == altura && base == calcularHipotenusa() && altura == calcularHipotenusa()) {
            return "Es un triángulo equilátero";
        } else if (base != altura && base != calcularHipotenusa() && altura != calcularHipotenusa()) {
            return "Es un triángulo escaleno";
        } else {
            return "Es un triángulo isósceles";
        }
    }
}
