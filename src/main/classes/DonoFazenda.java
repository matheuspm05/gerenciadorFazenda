package main.classes;

public class DonoFazenda {
    private String nome;
    private String cpf;
    private String contato;
    private double rendaMensal;

    // constutor
    public DonoFazenda(String nome, String cpf, String contato, double rendaMensal) {
        this.nome = nome;
        this.cpf = cpf;
        this.contato = contato;
        this.rendaMensal = rendaMensal;
    }

    // gets
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getContato() {
        return contato;
    }

    public double getRendaMensal() {
        return rendaMensal;
    }

    public void informacoes() {
        System.out.println("\tINFORMAÇOES SOBRE DONO FAZENDA");
        System.out.println("\nDONO: " + nome + "\nCPF: " + cpf + "\nCONTATO: " + contato + "\nRENDA R$: " + rendaMensal);
    }
    
    @Override
    public String toString() {
        return "\nDONO: " + nome + "\nCPF: " + cpf + "\nCONTATO: " + contato + "\nRENDA R$: " + rendaMensal;
    }
}
