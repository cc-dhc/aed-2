public interface Lista<E> {
  public void inserirFim(E elemento);

  public E removerFim();

  public void inserirInicio(E elemento);

  public E removerInicio();

  public void inserir(int index, E elemento);

  public E remover(int index);

  public int tamanho();

  public boolean vazio();

  public void mostrar();
}