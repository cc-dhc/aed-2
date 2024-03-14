public class E02 {
    public static void main(String[] args) {
        double d = divisao(4, 0);
        System.out.println(d);
    }

    public static double divisao(int a, int b) throws ArithmeticException {
        double d = (double) a / b;

        if (Double.isInfinite(d)) {
            throw new ArithmeticException("Divisão por zero");
        }

        return d;
    }
}
