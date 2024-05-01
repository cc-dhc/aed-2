public class Questao04 {
  public static void main(String[] args) throws Exception {
    Pilha<Integer> pilha = new Pilha<>();

    pilha.inserir(12);
    pilha.inserir(13);
    pilha.inserir(23);
    pilha.inserir(11);

    pilha.mostraPilha();

    invertePilha(pilha);

    pilha.mostraPilha();
  }

  public static <T extends Comparable<T>> void invertePilha(Pilha<T> pilha) throws Exception {
    Fila<T> fila = new Fila<>();

    while (!pilha.vazio()) {
      fila.inserir(pilha.remover());
    }

    while (fila.getTamanho() != 0) {
      pilha.inserir(fila.remover());
    }
  }
}
