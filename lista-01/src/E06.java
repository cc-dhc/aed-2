public class E06 {
    public static void main(String[] args) {
        Cachorro c = new Cachorro();
        Gato g = new Gato();
        Ovelha o = new Ovelha();

        c.come();
        c.late();

        g.come();
        g.mia();

        o.come();
        o.baah();
    }
}

abstract class Mamifero {
    int numPatas;

    public void come() {
        System.out.println(String.format("[%s]: comendo...", this.getClass().getName()));
    }
}

class Cachorro extends Mamifero {
    public void late() {
        System.out.println("[Cachorro]: latindo...");
    }

}

class Gato extends Mamifero {
    public void mia() {
        System.out.println("[Gato]: miando...");
    }
}

class Ovelha extends Mamifero {
    public void baah() {
        System.out.println("[Ovelha]: baah...");
    }
}