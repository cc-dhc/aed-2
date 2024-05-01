public class Main {
  public static void main(String[] args) {
    int n = 100;
    int linha = 0;
    int i, j, k;

    for (i = 1; i < 4; i++)
      for (j = i; j < n + 1; j++)
        for (k = i; k < j + 1; k++)
          System.out.printf("[%d]: %d %d %d\n", linha++, i, j, k);
  }
}
