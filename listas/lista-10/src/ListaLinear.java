import java.util.Arrays;

public class ListaLinear<E> implements Lista<E> {
    private E[] array;
    private int size;

    public ListaLinear() {
        alocarArray(8);
        this.size = 0;
    }

    // melhorar...
    @SuppressWarnings("unchecked")
    private void alocarArray(int size) {
        array = (E[]) new Object[size];
    }

    @Override
    public void inserirFim(E elemento) {
        if (!(tamanho() < array.length))
            array = Arrays.copyOf(array, size * 2);

        array[size++] = elemento;
    }

    @Override
    public E removerFim() {
        if (vazio())
            throw new RuntimeException("lista vazia");

        return array[--size];
    }

    @Override
    public void inserirInicio(E elemento) {
        if (!(tamanho() < array.length))
            array = Arrays.copyOf(array, size * 2);

        for (int i = size; i >= 0; i--)
            array[i + 1] = array[i];

        array[0] = elemento;
        size++;
    }

    @Override
    public E removerInicio() {
        if (vazio())
            throw new RuntimeException("lista vazia");

        E tmp = array[0];

        for (int i = 0; i < size; i++)
            array[i] = array[i + 1];

        size--;

        return tmp;
    }

    @Override
    public void inserir(int index, E elemento) {
        if (!(tamanho() < array.length))
            array = Arrays.copyOf(array, size * 2);

        for (int i = size; i > index; i--)
            array[i + 1] = array[i];

        array[index] = elemento;

        size++;
    }

    // todo
    public E remover(int index) {
        if (vazio())
            throw new RuntimeException("lista vazia");

        E tmp = array[index];

        for (int i = index; i > size; i++) {
        }
        // array[]

        size--;

        return tmp;
    }

    @Override
    public int tamanho() {
        return this.size;
    }

    @Override
    public boolean vazio() {
        return this.size == 0;
    }

    @Override
    public void mostrar() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }
}