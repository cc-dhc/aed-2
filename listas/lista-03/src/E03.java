public class E03 {
    public static void main(String[] args) throws EntradaInvalidaException {
        System.out.println(fatorial(21));
    }

    public static int fatorial(int numero) throws EntradaInvalidaException {
        if (numero >= 20) {
            throw new EntradaInvalidaException(numero);
        }

        int fat = 1;
        int n = 1;

        while (++n <= numero) {
            fat *= n;
        }
        return fat;
    }
}

class EntradaInvalidaException extends Exception {
    EntradaInvalidaException(int n) {
        super("Entrada n: " + n + " maior que o limite de 20!");
    }
}
