import java.util.Scanner;

public class Questao03 {

  public static boolean EquacaoCorreta(String entrada) throws Exception {
    Pilha<Character> pilha = new Pilha<>();
    boolean correta = true;

    int[] arr = entrada.chars().toArray();

    for (int c : arr) {
      switch ((char) c) {
        case '(' -> pilha.inserir('.');
        case ')' -> {
          if (!pilha.vazio()) pilha.remover();
          else correta = false;
        }
      }
    }

    if (!pilha.vazio()) correta = false;

    return correta;
  }

  public static void main(String[] args) {
    try {

      Scanner sc = new Scanner(System.in);

      System.out.println("Digite a equação: ");
      String equacao = sc.nextLine();

      if (EquacaoCorreta(equacao))
        System.out.println("Equação Correta");
      else
        System.out.println("Equação incorreta");
      sc.close();

    } catch (Exception erro) {
      System.out.println(erro.getMessage());
    }

  }

}
