public class E01 {
  public static void main(String[] args) {
    Pessoa pessoa1 = new Pessoa("João", "Silva");
    Funcionario pessoa2 = new Funcionario("Maria", "Medeiros", 1750d);
    Professor pessoa3 = new Professor("José", "Souza", -500d);
    Professor pessoa4 = new Professor("Ana", "Oliveira", 1500d);

    System.out.println(pessoa1);
    System.out.println(pessoa2);
    System.out.println(pessoa3);
    System.out.println(pessoa4);
  }
}

class Pessoa {
  private String nome;
  private String sobrenome;

  public Pessoa(String nome, String sobrenome) {
    this.nome = nome;
    this.sobrenome = sobrenome;
  }

  public Pessoa() {
  }

  public String getNomeCompleto() {
    return String.format("%s %s", nome, sobrenome);
  }

  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getSobrenome() {
    return sobrenome;
  }
  public void setSobrenome(String sobrenome) {
    this.sobrenome = sobrenome;
  }

  @Override 
  public String toString() {
    return String.format(
      "Nome: %s",
      this.getNomeCompleto()
    );
  }
}

class Funcionario extends Pessoa {
  private int matricula;
  private double salario;

  public Funcionario(String nome, String sobrenome, double salario) {
    super(nome, sobrenome);
    this.matricula = (int) Math.random();
    this.salario = Math.max(salario, 0);
  }

  public double getSalarioPrimeiraParcela() {
    return salario * 0.60d;
  }

  public double getSalarioSegundaParcela() {
    return salario * 0.40d;
  }

  public int getMatricula() {
    return matricula;
  }
  public void setMatricula(int matricula) {
    this.matricula = matricula;
  }
  public double getSalario() {
    return salario;
  }
  public void setSalario(double salario) {
    this.salario = Math.max(salario, 0);
  }

  @Override
  public String toString() {
    return String.format(
      "Nome: %s,\tP1: %.2f,\tP2: %.2f",
      super.getNomeCompleto(),
      this.getSalarioPrimeiraParcela(),
      this.getSalarioSegundaParcela()
    );
  }
}

class Professor extends Funcionario {
  public Professor(String nome, String sobrenome, double salario) {
    super(nome, sobrenome, salario);
  }

  @Override
  public double getSalarioPrimeiraParcela() {
    return super.getSalario();
  }

  @Override
  public double getSalarioSegundaParcela() {
    return 0;
  }
}
