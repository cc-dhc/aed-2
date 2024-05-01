/**
 * Celula (pilha, lista e fila dinamica)
 *
 * @author Diego Silva Caldeira Rocha
 * @version 3 01/2023
 */
class Celula<T> {
  private Celula<T> prox; // Aponta a celula prox.

  private T elemento; // Elemento inserido na celula.

  public T getElemento() {
    return elemento;
  }

  public void setElemento(T elemento) {
    this.elemento = elemento;
  }

  public Celula<T> getProx() {
    return prox;
  }

  public void setProx(Celula<T> prox) {
    this.prox = prox;
  }

  /**
   * Construtor da classe.
   */
  public Celula() {
    elemento = null;
  }

  /**
   * Construtor da classe.
   *
   * @param elemento int inserido na celula.
   */
  public Celula(T elemento) {
    this.elemento = elemento;
    this.prox = null;
  }
}
