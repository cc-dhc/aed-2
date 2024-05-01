public class PrincipalFila {
  public static void main(String[] args) throws Exception {

    System.out.println("==== FILA FLEXIVEL ====");
    Fila<Integer> fila = new Fila<>();
    int x1;
    Integer x2;
    Integer x3;

    fila.inserir(5);
    fila.inserir(7);
    fila.inserir(8);
    fila.inserir(9);

    System.out.println("achcamenror" + fila.acharMenor());

    System.out.println("Apos insercoes(5, 7, 8, 9): ");
    fila.mostrar();

    x1 = fila.remover();
    x2 = fila.remover();

    System.out.println("Apos remocoes (" + x1 + ", " + x2 + "):");
    fila.mostrar();

    fila.inserir(3);
    fila.inserir(4);

    System.out.println("Apos insercoes(3, 4): ");
    fila.mostrar();

    System.out.println("Ordenar");

    fila.mostrar();

    x1 = fila.remover();
    x2 = fila.remover();
    x3 = fila.remover();

    System.out.println("Apos remocoes (" + x1 + ", " + x2 + ", " + x3 + "):");
    fila.mostrar();

    fila.inserir(4);
    fila.inserir(5);

    System.out.println("Apos insercoes(4, 5): ");
    fila.mostrar();

    x1 = fila.remover();
    x2 = fila.remover();

    System.out.println("Apos remocoes (" + x1 + ", " + x2 + "):");
    fila.mostrar();

    fila.inserir(6);
    fila.inserir(7);

    System.out.println("Apos insercoes(6, 7): ");
    fila.mostrar();

    x1 = (int) fila.remover();

    System.out.println("Apos remocao (" + x1 + "): ");
    fila.mostrar();
  }
}
