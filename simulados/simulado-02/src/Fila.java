/**
 * Fila dinamica
 *
 * @author Diego Silva Caldeira Rocha
 * @version 3 01/2023
 *
 */
public class Fila<T extends Comparable<T>> {
  private Celula<T> primeiro;
  private Celula<T> ultimo;

  private int tamanho = 0;

  /**
   * Construtor da classe que cria uma fila sem elementos (somente no cabeca).
   */
  public Fila() {

    primeiro = new Celula<T>();
    ultimo = primeiro;

  }

  /**
   * Insere elemento na fila (politica FIFO).
   *
   * @param x elemento a inserir.
   */
  public void inserir(T x) {
    Celula<T> novo = new Celula<>(x);
    ultimo.setProx(novo);
    ultimo = novo;

    tamanho++;
  }

  public T acharMenor() throws Exception {

    if (primeiro == ultimo) {
      throw new Exception("Erro ao remover!");
    }

    return AcharMenor(primeiro.getProx());
  }

  private T AcharMenor(Celula<T> celula) {
    T menor;

    if (celula.getProx() == null)
      return celula.getElemento();
    menor = AcharMenor(celula.getProx());
    if (menor.compareTo(celula.getElemento()) > 0)
      menor = celula.getElemento();
    return menor;
  }

  /**
   * Remove elemento da fila (politica FIFO).
   *
   * @return Elemento removido.
   * @trhows Exception Se a fila nao tiver elementos.
   */
  public T remover() throws Exception {
    if (primeiro == ultimo) {
      throw new Exception("Erro ao remover!");
    }
    tamanho--;
    Celula<T> tmp = primeiro;
    primeiro = primeiro.getProx();
    T resp = primeiro.getElemento();
    tmp.setProx(null);
    tmp = null;
    return resp;
  }

  /**
   * Mostra os elementos separados por espacos.
   */
  public void mostrar() {
    System.out.print("[ ");

    for (Celula<T> i = primeiro.getProx(); i != primeiro; i = i.getProx()) {
      System.out.print(i.getElemento() + " ");
    }

    System.out.println("] ");
  }

  public int getTamanho() {
    return tamanho;
  }

}