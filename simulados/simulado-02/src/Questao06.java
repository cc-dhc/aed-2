
import java.util.Scanner;

public class Questao06 {

  public static void soma(Pilha<Integer> P1, Pilha<Integer> P2, Pilha<Integer> P3) throws Exception {
    int resto = 0;
    int n1 = 0;
    int n2 = 0;

    while (!P1.vazio() || !P2.vazio() || resto != 0) {
      n1 = 0;
      n2 = 0;

      if (!P1.vazio()) n1 = P1.remover();
      if (!P2.vazio()) n2 = P2.remover();

      int sum = n1 + n2 + resto;
      P3.inserir(sum % 10);
      resto = sum / 10;
    }

    while (!P3.vazio()) System.out.print(P3.remover());
  }

  public static void main(String[] args) {
    try {

      Scanner sc = new Scanner(System.in);

      System.out.println("Digite o primeiro numero: ");
      String primeio = sc.nextLine();

      System.out.println("Digite o primeiro numero: ");
      String segundo = sc.nextLine();

      Integer.parseInt(primeio);
      Integer.parseInt(segundo);

      Pilha<Integer> P1 = new Pilha<>();
      Pilha<Integer> P2 = new Pilha<>();
      Pilha<Integer> P3 = new Pilha<>();
      for (int i = 0; i < primeio.length(); i++) {
        P1.inserir(Integer.parseInt(primeio.substring(i, i + 1)));
      }

      for (int i = 0; i < segundo.length(); i++) {
        P2.inserir(Integer.parseInt(segundo.substring(i, i + 1)));
      }

      soma(P1, P2, P3);
      sc.close();
    } catch (NumberFormatException ex) {
      ex.printStackTrace();
    } catch (Exception erro) {
      System.out.println(erro.getMessage());
    }
  }

}
