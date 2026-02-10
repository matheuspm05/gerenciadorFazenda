package main.classes;

import java.util.ArrayList;
import java.util.List;

public class Campeiro {
    private int id;
    private String nome;
    private String tempoServico;
    private double salario;
    private List<Animal> animaisCuidados;

    // constutor
    public Campeiro(int id, String nome, String tempoServico, double salario) {
        this.id = id;
        this.nome = nome;
        this.tempoServico = tempoServico;
        this.salario = salario;
        animaisCuidados = new ArrayList<>();
    }

    // gets
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTempoServico() {
        return tempoServico;
    }

    public double getSalario() {
        return salario;
    }

    public List<Animal> getAnimalCuidados() {
        return animaisCuidados;
    }

    public void adicionarAnimalCuidados(Animal animal) {

        int idAnimal = animal.getId();
        boolean existe = false;

        for (Animal a : animaisCuidados) {
            if (a.getId() == idAnimal) {
                existe = true;
                break;
            }
        }

        if (existe) {
            System.out.println("\nANIMAL CUIDADO JA EXISTENTE.");
        } else {
            animaisCuidados.add(animal);
            System.out.println("\nANIMAL CUIDADO ADICIONADO COM SUCESSO.");
        }

    }

    public void informacoes() {
        System.out.println("\tINFORMAÇOES SOBRE CAMPEIRO");
        System.out.println(
                "\nID: " + id + "\nCAMPEIRO: " + nome + "\nTEMPO DE SERVIÇO: " + tempoServico + "\nSALARIO: "
                        + salario);

        System.out.println("\nANIMAIS CUIDADOS:");
        for (Animal a : animaisCuidados) {
            System.out.println(a);
        }

    }

    @Override
    public String toString() {
        return "\nTIPO: CAMPEIRO" +
                "\nID: " + id +
                "\nNOME: " + nome +
                "\nTEMPO DE SERVIÇO: " + tempoServico +
                "\nSALÁRIO: R$ " + salario;
    }

}
