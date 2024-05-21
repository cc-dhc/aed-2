public class App {
  public static void main(String[] args) throws Exception {
    System.out.println("Hello, World!");

    ListaLinear<Integer> lista = new ListaLinear<>();
    System.out.println(lista.vazio());

    for (int i = 0; i < 10; i++) {
      lista.inserirFim(i);
    }

    lista.inserirInicio(69);

    System.out.println(lista.tamanho());
    System.out.println(lista.vazio());
    lista.inserirInicio(70);
    lista.mostrar();
    lista.removerFim();
    lista.mostrar();

  }
}