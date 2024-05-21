public class CelulaDupla<E> {
  private E elemento;
  private CelulaDupla<E> proximo;
  private CelulaDupla<E> anterior;

  public CelulaDupla(E elemento) {
    this.elemento = elemento;
  }

  public CelulaDupla(E elemento, CelulaDupla<E> proximo, CelulaDupla<E> anterior) {
    this.elemento = elemento;
    this.proximo = proximo;
    this.anterior = anterior;
  }

  public E getElemento() {
    return elemento;
  }

  public void setElemento(E elemento) {
    this.elemento = elemento;
  }

  public CelulaDupla<E> getProximo() {
    return proximo;
  }

  public void setProximo(CelulaDupla<E> proximo) {
    this.proximo = proximo;
  }

  public CelulaDupla<E> getAnterior() {
    return anterior;
  }

  public void setAnterior(CelulaDupla<E> anterior) {
    this.anterior = anterior;
  }
}