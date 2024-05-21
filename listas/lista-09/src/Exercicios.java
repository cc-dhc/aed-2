public class Exercicios {
  public static void main(String[] args) {
    Pilha pilha = new Pilha();
    //PilhaSentinela pilha = new PilhaSentinela();

    pilha.inserir(5);
    pilha.inserir(6);
    pilha.inserir(9);
    pilha.inserir(10);

    pilha.mostrar();
    System.out.println();
    System.out.println(pilha.remover());
    System.out.println();
    pilha.mostrar();
    System.out.println();
    System.out.println(pilha.tamanho());
    System.out.println(pilha.vazio());
  }
}

class Celula {
  private int elemento;
  private Celula prox;
  public Celula(int elemento) {
    this.elemento = elemento;
  }
  public int getElemento() {
    return elemento;
  }
  public void setElemento(int elemento) {
    this.elemento = elemento;
  }
  public Celula getProx() {
    return prox;
  }
  public void setProx(Celula prox) {
    this.prox = prox;
  }
  
}

class Pilha {
  private Celula topo;

  public Pilha() {
    topo = null;
  }

  public void inserir(int elemento) {
    Celula novo = new Celula(elemento);
    if (vazio()) topo = novo;
    else {
      novo.setProx(topo);
      topo = novo;
    }
  }

  public int remover() {
    if (vazio()) throw new RuntimeException("pilha vazia");
    
    int elemento = topo.getElemento();
    topo = topo.getProx();
    
    return elemento;
  }

  public int tamanho() {
    if (vazio()) return 0;

    Celula atual = topo;
    int tamanho = 0;

    do {
      tamanho++;
      atual = atual.getProx();
    } while(atual != null);

    return tamanho;
  }

  public boolean vazio() {
    return topo == null;
  }

  public void mostrar() {
    Celula atual = topo;

    while (atual != null) {
      System.out.println(atual.getElemento());
      atual = atual.getProx();
    }
  }

  public int soma() {
    if (vazio()) throw new RuntimeException("pilha vazia");
    return soma(topo);
  }

  private int soma(Celula atual) {
    if (atual == null) return 0;
    return atual.getElemento() + soma(atual.getProx());
  }

  public int maior() {
    if (vazio()) throw new RuntimeException("pilha vazia");
    return maior(topo);
  }

  private int maior(Celula atual) {
    if (atual == null) return Integer.MIN_VALUE;

    return Math.max(atual.getElemento(), maior(atual.getProx()));
  }

  public void mostrarRecursivo() {
    if (vazio()) throw new RuntimeException("pilha vazia");
    mostrarRecursivo(topo);
  }

  private void mostrarRecursivo(Celula atual) {
    if (atual == null) return;

    System.out.println(atual.getElemento());

    mostrarRecursivo(atual.getProx());
  }
}

class PilhaSentinela {
  private Celula sentinela;
  private Celula topo;

  public PilhaSentinela() {
    sentinela = new Celula(0);
    topo = sentinela;
  }


  public void inserir(int elemento) {
    Celula novo = new Celula(elemento);
    novo.setProx(topo);
    topo = novo;
  }

  public int remover() {
    if (vazio()) throw new RuntimeException("pilha vazia");
    
    int elemento = topo.getElemento();
    topo = topo.getProx();
    
    return elemento;
  }

  public int tamanho() {
    if (vazio()) return 0;

    Celula atual = topo;
    int tamanho = 0;

    do {
      tamanho++;
      atual = atual.getProx();
    } while(atual != sentinela);

    return tamanho;
  }

  public boolean vazio() {
    return topo == sentinela;
  }

  public void mostrar() {
    Celula atual = topo;

    while (atual != sentinela) {
      System.out.println(atual.getElemento());
      atual = atual.getProx();
    }
  }
}