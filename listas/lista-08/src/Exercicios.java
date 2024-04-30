public class Exercicios {
  public static void main(String[] args) {
    
  }
}

class No {
  private int element;
  private No nextNode;

  public No(int element, No nextNode) {
    this.element = element;
    this.nextNode = nextNode;
  }

  public int getElement() {
    return element;
  }

  public void setElement(int element) {
    this.element = element;
  }

  public No getNextNode() {
    return nextNode;
  }

  public void setNextNode(No nextNode) {
    this.nextNode = nextNode;
  }
}

class Fila {
  private No head;

  public Fila() {
    head = new No(0, null);
  }

  public void enfileirar(int element) {
    No current = head;

    while (current.getNextNode() != null)
      current = current.getNextNode();

    current.setNextNode(new No(element, null));
  }

  public int remover() {
    No first = head.getNextNode();

    if (first != null)
      head = first;

    return first.getElement();
  }

  public void mostrar() {
    No current = head;

    while (current.getNextNode() != null) {
      current = current.getNextNode();
      System.out.println(current.getElement());
    }

  }

  public int amplitude() {
    No current = head;
    int maior = Integer.MIN_VALUE, menor = Integer.MAX_VALUE;

    while (current.getNextNode() != null) {
      current = current.getNextNode();
      if (current.getElement() > maior)
        maior = current.getElement();
      if (current.getElement() < menor)
        menor = current.getElement();
    }

    return maior - menor;
  }

  public double media() {
    No current = head;
    double sum = 0;
    int count = 0;

    while (current.getNextNode() != null) {
      current = current.getNextNode();
      sum += current.getElement();
      count++;
    }

    return sum / (double) count;
  }

  public void fura(int e, int pos) {
    No prev = head;
    No next = head.getNextNode();
    int currentPos = 0;

    while (currentPos != pos && next != null) {
      prev = next;
      next = next.getNextNode();
      currentPos++;
    }

    No novo = new No(e, next);
    prev.setNextNode(novo);
  }

  public int menor() {
    if (head.getNextNode() == null) throw new RuntimeException("Fila Vazia");

    return menor(head.getNextNode());
  }

  private int menor(No no) {
    int menor = Integer.MAX_VALUE;

    if (no == null)
      return menor;

    menor = menor(no.getNextNode());

    return Math.min(no.getElement(), menor);
  }

  public void inverter() {
    No current = head.getNextNode();
    No prev = null;
    No next = null;

    while (current != null) {
      next = current.getNextNode();
      current.setNextNode(prev);
      prev = current;
      current = next;
    }

    head.setNextNode(prev);
  }
}

class FilaSemCabeca {
  private No fila;

  public FilaSemCabeca() {
    this.fila = null;
  }

  public void enfileirar(int element) {
    if (fila == null) {
      fila = new No(element, null);
      return;
    }

    No current = fila.getNextNode();

    while (current.getNextNode() != null) current = current.getNextNode();

    current.setNextNode(new No(element, null));
  }

  public int remover() {
    if (fila == null) throw new RuntimeException("Fila Vazia");

    No first = fila;
    fila = fila.getNextNode();

    return first.getElement();
  }

  public void mostrar() {
    No current = fila;

    while (current != null) {
      System.out.println(current.getElement());
      current = current.getNextNode();
    }

  }
}
