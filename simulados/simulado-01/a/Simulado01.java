public class Simulado01 {
    public static void main(String[] args) {
        try {
            new Gestor(0, "João", 0, 10, "+5531988888088");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class Empregado {
    private int id;
    private String nome;
    private float salario;

    public Empregado(int id, String nome, float salario) throws Exception {
        this.id = id;
        this.nome = nome;
        setSalario(salario);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getSalario() {
        return salario;
    }
    public void setSalario(float salario) throws Exception {
        if (salario <= 0)
            throw new Exception("Salario menor ou igual a zero");

        this.salario = salario;
    }
}

class Gestor extends Empregado {
    private int nivel;
    private String celularCorporativo;

    public Gestor(int id, String nome, float salario, int nivel, String celularCorporativo) throws Exception {
        super(id, nome, salario);
        this.nivel = nivel;
        this.celularCorporativo = celularCorporativo;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public String getCelularCorporativo() {
        return celularCorporativo;
    }
    public void setCelularCorporativo(String celularCorporativo) {
        this.celularCorporativo = celularCorporativo;
    }
}