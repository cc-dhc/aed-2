import javax.swing.JOptionPane;

public class E01 {
    public static void main(String[] args) {
        String nome = typeString("Digite o nome do cliente");
        String cpf = typeString("Digite o cpf do cliente");
        double saldo = typeDouble("Digite o saldo inicial do cliente");
        Conta c = new Conta(nome, cpf, saldo);
        double deposito = typeDouble("Digite o valor do depósito");
        c.deposita(deposito);
        double saque = typeDouble("Digite o valor do saque");
        try {
            c.saca(saque);
        } catch (SaldoInsuficienteException | LimiteInsuficienteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "\nOperação não realizada!");
        }
        JOptionPane.showMessageDialog(null, c.toString());
    }

    private static double typeDouble(String txt) {
        Double d = null;
        do {
            String userInput = JOptionPane.showInputDialog(txt);
            try {
                d = Double.parseDouble(userInput);
            } catch(NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Valor inválido, favor inserir novamente!");
            }
        } while(d == null);
        return d;
    }

    private static String typeString(String txt) {
        return JOptionPane.showInputDialog(null, txt);
    }

    public static void showMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
}

class Conta {
    private double saldo;
    private double limite = 200;
    private String nome, cpf;

    public Conta(String nome, String cpf, double saldo) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setSaldo(saldo);
    }

    public String getNome() {
        return nome;
    }
    public double getLimite() {
        return limite;
    }
    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = (saldo < 0) ? 0 : saldo;
    }

    public void deposita(double valor) {
        setSaldo((valor < 0) ? saldo : saldo + valor);
    }

    public void saca(double valor) throws SaldoInsuficienteException, LimiteInsuficienteException {
        if (getSaldo() <= 0) {
            throw new SaldoInsuficienteException("Seu saldo é: " + this.saldo + "\n Voce tentou sacar: " + valor);
        } else if (getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
        } else if (getSaldo() + getLimite() >= valor) {
            valor -= getSaldo();
            setSaldo(0);
            setLimite(getLimite() - valor);
            E01.showMessage("Seu limite restante é de: " + this.limite);
        } else if (getSaldo() + getLimite() <= valor) {
            throw new LimiteInsuficienteException("Seu limite é: " + this.limite + "\n Você tentou sacar: " + valor);
        }
    }

    @Override
    public String toString() {
        return "Cliente: " + this.nome + "\nCPF: " + this.cpf + "\nSaldo: " + this.saldo;
    }
}

class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String msg) {
        super(msg);
    }
}

class LimiteInsuficienteException extends Exception {
    public LimiteInsuficienteException(String msg) {
        super(msg);
    }
}