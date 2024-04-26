public class App {
    public static void main(String[] args) throws Exception {
        Fila fila = new Fila();

        fila.enfileirar(10);
        fila.enfileirar(12);
        fila.enfileirar(13);
        fila.enfileirar(14);

        fila.mostrar();

        System.out.println(fila.media());
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
        
        while (current.getNextNode() != null) current = current.getNextNode();

        current.setNextNode(new No(element, null));
    }

    public int remover() {
        No first = head.getNextNode();

        if (first != null) head = first;

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
            if (current.getElement() > maior) maior = current.getElement();
            if (current.getElement() < menor) menor = current.getElement();
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
        No current = head;
        int currentPos = 0;
        
        while (current.getNextNode() != null) {
            current = current.getNextNode();
            currentPos++;
        }

    }
}

