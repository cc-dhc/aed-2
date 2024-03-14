public class E04 {
    public static void main(String[] args) {
        try {
            Triangulo t1 = new Triangulo(1, 1, 1);
            System.out.println(t1.determinarTipo());

            Triangulo t2 = new Triangulo(1, 1, 2);
            System.out.println(t2.determinarTipo());

            Triangulo t3 = new Triangulo(1, 2, 3);
            System.out.println(t3.determinarTipo());

            Triangulo t4 = new Triangulo(-1, 1, 1);
            System.out.println(t4.determinarTipo());
        } catch (TrianguloInvalidoError tie) {
            System.out.println(tie.getMessage());
        }

    }
}

// Equilátero (0), Isósceles (1), Escaleno (2).
class Triangulo {
    int tipo;

    Triangulo(double a, double b, double c) throws TrianguloInvalidoError {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new TrianguloInvalidoError("Lados negativos ou com valor 0!");
        }

        if (a > b + c || b > a + c || c > a + b) {
            throw new TrianguloInvalidoError("Desigualdade triangular detectada!");
        }

        if (a == b && a == c) {
            tipo = 0;
        } else if (a == b || a == c || b == c) {
            tipo = 1;
        } else {
            tipo = 2;
        }
    }

    public int determinarTipo() {
        return tipo;
    }
}

class TrianguloInvalidoError extends Exception {
    TrianguloInvalidoError(String msg) {
        super(msg);
    }
}