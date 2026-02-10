package main.classes;

public class Remedio {

    private String nome;
    private String dose;

    // constutor
    public Remedio(String nome, String dose) {
        this.nome = nome;
        this.dose = dose;
    }

    // gets
    public String getNome() {
        return nome;
    }

    public String getDose() {
        return dose;
    }

    public String toString() {
        return "Remédio [nome=" + nome + ", dose=" + dose + "]";
    }

}
