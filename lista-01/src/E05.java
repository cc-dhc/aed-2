public class E05 {
    public static void main(String[] args) {
        Produto p1 = new Produto("a", 1, 1);
        Produto p2 = new Produto();

        p2.setDescricao("b");
        p2.setQuant(10);

        assert p1.getId() != p2.getId();

        assert p1.emEstoque();
        assert p2.emEstoque();
    }
}

class Produto {
    private int id;
    @SuppressWarnings("unused")
    private String descricao;
    @SuppressWarnings("unused")
    private float preco;
    private int quant;
    private int cont;

    Produto(String d, float p, int q) {
        id = (int) Math.random();
        descricao = d;
        preco = p;
        quant = q;
    }

    Produto() {
        id = (int) Math.random();
    }

    public boolean emEstoque() {
        return quant > 0;
    }

    public int getCont() {
        return cont;
    }

    public int getId() {
        return id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }
}