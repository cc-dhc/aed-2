class ListaDupla<E> implements Lista<E> {
  private CelulaDupla<E> primeiro;
  private CelulaDupla<E> ultimo;
  private int size;

  @Override
  public void inserir(int index, E elemento) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void inserirFim(E elemento) {
    CelulaDupla<E> novo = new CelulaDupla<>(elemento);
    
    if (!vazio()) {
      novo.setAnterior(ultimo);
      ultimo.setProximo(novo);
    }

    ultimo = novo;
    size++;
  }

  @Override
  public void inserirInicio(E elemento) {
    CelulaDupla<E> novo = new CelulaDupla<>(elemento);

    if (!vazio()) {
      novo.setProximo(primeiro);
      primeiro.setAnterior(novo);
    }

    primeiro = novo;
    size++;
  }

  @Override
  public void mostrar() {
    if (vazio()) return;

    CelulaDupla<E> atual = primeiro;
    
    do {
      System.out.println(atual.getElemento());
      atual = atual.getProximo();
    } while (atual != null);
  }

  @Override
  public E remover(int index) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public E removerFim() {
    //todo
    return null;
  }

  @Override
  public E removerInicio() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int tamanho() {
    return size;
  }

  @Override
  public boolean vazio() {
    return tamanho() == 0 && ultimo == null;
  }
}