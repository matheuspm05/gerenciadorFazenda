package main.classes;

import java.util.List;
import java.util.ArrayList;
import main.interfaces.Tratavel;

public abstract class Animal implements Tratavel {
    private int id;
    private String nome;
    private String idade;
    private String peso;

    private String localizacao;
    private List<Remedio> historicoRemedios;

    // constutor
    public Animal(int id, String nome, String idade, String peso) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        historicoRemedios = new ArrayList<>();
    }

    // gets
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getIdade() {
        return idade;
    }

    public String getPeso() {
        return peso;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public List<Remedio> getHistoricoRemedios() {
        return historicoRemedios;
    }

    public abstract void exibirInformacoes();

    @Override
    public void aplicarRemedio(Remedio remedio) {

        System.out.println("\nAPLICANDO REMÉDIO: " + remedio.getNome());
        System.out.println("DOSE: " + remedio.getDose());
        historicoRemedios.add(remedio);
    }

    @Override
    public String toString() {
        return  """
                ------------------------
                ANIMAL
                ------------------------
                ID          : %d
                NOME        : %s
                IDADE       : %s
                PESO        : %s
                LOCALIZAÇÃO : %s
                ------------------------
                """.formatted(id, nome, idade, peso,
                localizacao != null ? localizacao : "Não definida");
    }

}
