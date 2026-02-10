package main.classes;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class LocalDeAnimal {

    private final List<Animal> animais = new ArrayList<>();

    public List<Animal> getAnimais() {
        return animais;
    }

    public abstract void limpar();
    public abstract void listarAnimais();

    protected void adicionarAnimal(Animal animal) {
        if (animal == null) {
            System.out.println("\nANIMAL INVÁLIDO.");
            return;
        }

        int idAnimal = animal.getId();
        if (existeId(idAnimal)) {
            System.out.println("\nANIMAL COM ID JÁ EXISTENTE.");
            return;
        }

        animais.add(animal);
    }

    protected void removerAnimal(Animal animal) {
        if (animal == null) {
            System.out.println("\nANIMAL INVÁLIDO.");
            return;
        }

        int idAnimal = animal.getId();
        boolean removido = false;

        Iterator<Animal> iterator = animais.iterator();
        while (iterator.hasNext()) {
            Animal a = iterator.next();
            if (a.getId() == idAnimal) {
                iterator.remove();
                System.out.println("\nANIMAL REMOVIDO COM SUCESSO!");
                removido = true;
                break;
            }
        }
        if (!removido) {
            System.out.println("\nANIMAL NÃO ENCONTRADO.");
        }
    }

    protected boolean existeId(int id) {
        for (Animal a : animais) {
            if (a.getId() == id) return true;
        }
        return false;
    }

}
