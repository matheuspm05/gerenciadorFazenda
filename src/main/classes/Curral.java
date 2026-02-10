package main.classes;

public class Curral extends LocalDeAnimal {
    private int id;
    private int capacidadeMaxima;

    // constutor
    public Curral(int id, int capacidade) {
        this.id = id;
        this.capacidadeMaxima = capacidade;
    }

    // gets
    public int getId() {
        return id;
    }

    public int getCapacidade() {
        return capacidadeMaxima;
    }

    public void colocarAnimal(Animal animal) {
        if (getAnimais().size() >= capacidadeMaxima) {
            System.out.println("\nCURRAL " + id + " ESTÁ CHEIO!");
            return;
        }

        adicionarAnimal(animal);
        if (animal != null) {
            animal.setLocalizacao("Curral " + id);
        }
    };

    public void tirarAnimal(Animal animal) {
        removerAnimal(animal);
    }

    @Override
    public void limpar() {
        System.out.println("\nLIMPANDO O CURRAL!");
    }

    @Override
    public void listarAnimais() {
        System.out.println("\tTODOS ANIMAIS DO CURRAL " + id + ":");
        if (getAnimais().isEmpty()) {
            System.out.println("Nenhum animal no curral.");
            return;
        }

        for (Animal animal : getAnimais()) {
            System.out.println(animal);
        }
    }

    @Override
    public String toString() {
        return "\nTIPO: CURRAL" +
               "\nID: " + id +
               "\nCAPACIDADE MÁXIMA: " + capacidadeMaxima +
               "\nOCUPAÇÃO ATUAL: " + getAnimais().size();
    }

}
