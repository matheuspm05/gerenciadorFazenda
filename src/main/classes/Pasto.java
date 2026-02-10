package main.classes;

public class Pasto extends LocalDeAnimal {

    private int id;
    private String tamanho;
    private String tipoVegetacao;

    // constutor
    public Pasto(int id, String tamanho, String tipoVegetacao) {
        this.id = id;
        this.tamanho = tamanho;
        this.tipoVegetacao = tipoVegetacao;
    }

    // gets
    public int getId() {
        return id;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getTipoVegetacao() {
        return tipoVegetacao;
    }

    public void colocarAnimal(Animal animal) {
        adicionarAnimal(animal);
        if (animal != null) {
            animal.setLocalizacao("Pasto " + id);
        }
    }

     public void tirarAnimal(Animal animal) {
        removerAnimal(animal);
    }

    @Override
    public void limpar() {
        System.out.println("\nCORTANDO MATOS DO PASTO!");
    }

    @Override
    public void listarAnimais() {
        System.out.println("\tTODOS ANIMAIS DO PASTO " + id + ":");
        if (getAnimais().isEmpty()) {
            System.out.println("Nenhum animal no pasto.");
            return;
        }
        for (Animal animal : getAnimais()) {
            System.out.println(animal);
        }
    }

    @Override
    public String toString() {
        return "\nTIPO: PASTO" +
                "\nID: " + id +
                "\nTAMANHO: " + tamanho +
                "\nTIPO DE VEGETAÇÃO: " + tipoVegetacao;
    }

}
