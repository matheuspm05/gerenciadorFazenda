package main.classes;

import java.util.List;
import java.util.ArrayList;

public class Fazenda {
    private String nome;
    private String idadeFazenda;
    private DonoFazenda donoFazenda;

    // Cadastro geral
    private List<Animal> animais;
    private List<Pasto> pastos;
    private List<Curral> currais;
    private List<Campeiro> campeiros;
    private List<Remedio> remedios;

    // constutor
    public Fazenda(String nome, String idadeFazenda, DonoFazenda donoFazenda) {
        this.nome = nome;
        this.idadeFazenda = idadeFazenda;
        this.donoFazenda = donoFazenda;

        animais = new ArrayList<>();
        pastos = new ArrayList<>();
        currais = new ArrayList<>();
        campeiros = new ArrayList<>();
        remedios = new ArrayList<>();
    }

    // gets
    public String getNome() {
        return nome;
    }

    public String getIdadeFazenda() {
        return idadeFazenda;
    }

    public DonoFazenda getDonoFazenda() {
        return donoFazenda;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public List<Pasto> getPastos() {
        return pastos;
    }

    public List<Curral> getCurrais() {
        return currais;
    }

    public List<Campeiro> getCampeiros() {
        return campeiros;
    }

    public List<Remedio> getRemedios() {
        return remedios;
    }

    // ------------------------------------------------------------------------------------
    // auxiliares (busca por id)

    private Animal buscarAnimalPorId(int id) {
        for (Animal a : animais) {
            if (a.getId() == id)
                return a;
        }
        return null;
    }

    private Pasto buscarPastoPorId(int id) {
        for (Pasto p : pastos) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }

    private Curral buscarCurralPorId(int id) {
        for (Curral c : currais) {
            if (c.getId() == id)
                return c;
        }
        return null;
    }

    private Campeiro buscarCampeiroPorId(int id) {
        for (Campeiro c : campeiros) {
            if (c.getId() == id)
                return c;
        }
        return null;
    }

    private boolean existeAnimalId(int id) {
        return buscarAnimalPorId(id) != null;
    }

    private boolean existePastoId(int id) {
        return buscarPastoPorId(id) != null;
    }

    private boolean existeCurralId(int id) {
        return buscarCurralPorId(id) != null;
    }

    private boolean existeCampeiroId(int id) {
        return buscarCampeiroPorId(id) != null;
    }

    private Animal buscarAnimalNoPasto(Pasto pasto, int animalId) {
        for (Animal a : pasto.getAnimais()) {
            if (a.getId() == animalId)
                return a;
        }
        return null;
    }

    private Animal buscarAnimalNoCurral(Curral curral, int animalId) {
        for (Animal a : curral.getAnimais()) {
            if (a.getId() == animalId)
                return a;
        }
        return null;
    }

    // remover o animal de qualquer curral/pasto antes de mover

    private void removerAnimalDeTodosLocais(int animalId) {
        for (Pasto p : pastos) {
            Animal a = buscarAnimalNoPasto(p, animalId);
            if (a != null) {
                p.tirarAnimal(a);
                a.setLocalizacao("Fora de curral/pasto");
            }
        }

        for (Curral c : currais) {
            Animal a = buscarAnimalNoCurral(c, animalId);
            if (a != null) {
                c.tirarAnimal(a);
                a.setLocalizacao("Fora de curral/pasto");
            }
        }
    }

    // -------------------------------------------------------------------------------------------
    // metodos de cadastro
    public void adicionarDono(DonoFazenda donoFazenda) {
        this.donoFazenda = donoFazenda;
    }

    public void adicionarAnimal(Animal animal) {
        if (animal == null) {
            System.out.println("\nANIMAL INVÁLIDO.");
            return;
        }

        int idAnimal = animal.getId();

        if (existeAnimalId(idAnimal)) {
            System.out.println("\nERROR: ANIMAL COM ID " + idAnimal + " JÁ EXISTENTE.");
            return;
        }

        animais.add(animal);
        animal.setLocalizacao("Fazenda");
        System.out.println("\nANIMAL ADICIONADO COM SUCESSO.");
    }

    public void adicionarPasto(Pasto pasto) {
        if (pasto == null) {
            System.out.println("\nPASTO INVÁLIDO.");
            return;
        }

        if (existePastoId(pasto.getId())) {
            System.out.println("\nERROR: PASTO COM ID JÁ EXISTENTE.");
            return;
        }

        pastos.add(pasto);
        System.out.println("\nPASTO ADICIONADO COM SUCESSO.");
    }

    public void adicionarCurral(Curral curral) {
        if (curral == null) {
            System.out.println("\nCURRAL INVÁLIDO.");
            return;
        }

        if (existeCurralId(curral.getId())) {
            System.out.println("\nERROR: CURRAL COM ID JÁ EXISTENTE.");
            return;
        }

        currais.add(curral);
        System.out.println("\nCURRAL ADICIONADO COM SUCESSO.");
    }

    public void adicionarCampeiro(Campeiro campeiro) {
        if (campeiro == null) {
            System.out.println("\nCAMPEIRO INVÁLIDO.");
            return;
        }

        if (existeCampeiroId(campeiro.getId())) {
            System.out.println("\nERROR: CAMPEIRO COM ID JÁ EXISTENTE.");
            return;
        }

        campeiros.add(campeiro);
        System.out.println("\nCAMPEIRO ADICIONADO COM SUCESSO.");
    }

    public void adicionarRemedio(Remedio remedio) {
        if (remedio == null) {
            System.out.println("\nREMÉDIO INVÁLIDO.");
            return;
        }

        remedios.add(remedio);
        System.out.println("\nREMÉDIO ADICIONADO COM SUCESSO.");
    }

    // -------------------------------------------------------------------------------------------
    // mover / remover animais
    public void moverAnimalParaCurral(int animalId, int curralId) {
        Animal animal = buscarAnimalPorId(animalId);
        Curral curral = buscarCurralPorId(curralId);

        if (animal == null) {
            System.out.println("\nANIMAL NÃO ENCONTRADO.");
            return;
        }

        if (curral == null) {
            System.out.println("\nCURRAL NÃO ENCONTRADO.");
            return;
        }

        removerAnimalDeTodosLocais(animalId);
        curral.colocarAnimal(animal);
    }

    public void moverAnimalParaPasto(int animalId, int pastoId) {
        Animal animal = buscarAnimalPorId(animalId);
        Pasto pasto = buscarPastoPorId(pastoId);

        if (animal == null) {
            System.out.println("\nANIMAL NÃO ENCONTRADO.");
            return;
        }

        if (pasto == null) {
            System.out.println("\nPASTO NÃO ENCONTRADO.");
            return;
        }

        removerAnimalDeTodosLocais(animalId);
        pasto.colocarAnimal(animal);
    }

    public void removerAnimalDoCurral(int animalId, int curralId) {
        Curral curral = buscarCurralPorId(curralId);

        if (curral == null) {
            System.out.println("\nCURRAL NÃO ENCONTRADO.");
            return;
        }

        Animal animal = buscarAnimalNoCurral(curral, animalId);
        if (animal == null) {
            System.out.println("\nANIMAL NÃO ENCONTRADO NO CURRAL " + curralId);
            return;
        }

        curral.tirarAnimal(animal);
        animal.setLocalizacao("Fora de curral/pasto");
        System.out.println("\nANIMAL REMOVIDO DO CURRAL " + curralId);
    }

    public void removerAnimalDoPasto(int animalId, int pastoId) {
        Pasto pasto = buscarPastoPorId(pastoId);

        if (pasto == null) {
            System.out.println("\nPASTO NÃO ENCONTRADO.");
            return;
        }

        Animal animal = buscarAnimalNoPasto(pasto, animalId);
        if (animal == null) {
            System.out.println("\nANIMAL NÃO ENCONTRADO NO PASTO " + pastoId);
            return;
        }

        pasto.tirarAnimal(animal);
        animal.setLocalizacao("Fora de curral/pasto");
        System.out.println("\nANIMAL REMOVIDO DO PASTO " + pastoId);
    }

    public void moverAnimalDoPastoParaCurral(int animalId, int pastoId, int curralId) {
        Pasto pasto = buscarPastoPorId(pastoId);
        Curral curral = buscarCurralPorId(curralId);

        if (pasto == null) {
            System.out.println("\nPASTO NÃO ENCONTRADO.");
            return;
        }

        if (curral == null) {
            System.out.println("\nCURRAL NÃO ENCONTRADO.");
            return;
        }

        Animal animal = buscarAnimalNoPasto(pasto, animalId);
        if (animal == null) {
            System.out.println("\nANIMAL NÃO ENCONTRADO NO PASTO " + pastoId);
            return;
        }

        pasto.tirarAnimal(animal);
        curral.colocarAnimal(animal);
        System.out.println("\nANIMAL MOVIDO DO PASTO " + pastoId + " PARA O CURRAL " + curralId);
    }

    public void moverAnimalDoCurralParaPasto(int animalId, int curralId, int pastoId) {
        Curral curral = buscarCurralPorId(curralId);
        Pasto pasto = buscarPastoPorId(pastoId);

        if (curral == null) {
            System.out.println("\nCURRAL NÃO ENCONTRADO.");
            return;
        }

        if (pasto == null) {
            System.out.println("\nPASTO NÃO ENCONTRADO.");
            return;
        }

        Animal animal = buscarAnimalNoCurral(curral, animalId);
        if (animal == null) {
            System.out.println("\nANIMAL NÃO ENCONTRADO NO CURRAL " + curralId);
            return;
        }

        curral.tirarAnimal(animal);
        pasto.colocarAnimal(animal);
        System.out.println("\nANIMAL MOVIDO DO CURRAL " + curralId + " PARA O PASTO " + pastoId);
    }

    // -------------------------------------------------------------------------------------------
    // listagens
    public void listarAnimais() {
        System.out.println("\nTODOS ANIMAIS CADASTRADOS NA FAZENDA:");
        if (animais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
            return;
        }

        for (Animal animal : animais) {
            System.out.println(animal);
        }
    }

    public void listarAnimaisPorPastos() {
        System.out.println("\n--- ANIMAIS POR PASTOS ---");
        if (pastos.isEmpty()) {
            System.out.println("Nenhum pasto cadastrado.");
            return;
        }

        for (Pasto p : pastos) {
            System.out.println("\nPASTO " + p.getId() + " (" + p.getTipoVegetacao() + ")");
            p.listarAnimais();
        }
    }

    public void listarAnimaisPorCurrais() {
        System.out.println("\n--- ANIMAIS POR CURRAIS ---");
        if (currais.isEmpty()) {
            System.out.println("Nenhum curral cadastrado.");
            return;
        }

        for (Curral c : currais) {
            System.out.println("\nCURRAL " + c.getId() + " (capacidade " + c.getCapacidade() + ")");
            c.listarAnimais();
        }
    }

    public void estruturaFazenda() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("\tINFORMAÇÕES COMPLETAS SOBRE A FAZENDA");
        System.out.println("------------------------------------------------------------------");
        System.out.println("NOME: " + nome);
        System.out.println("IDADE DA FAZENDA: " + idadeFazenda);
        System.out.println("DONO: " + donoFazenda);

        System.out.println("\n\tPASTOS");
        if (pastos.isEmpty())
            System.out.println("Nenhum pasto cadastrado.");
        for (Pasto pasto : pastos)
            System.out.println(pasto);

        System.out.println("\n\tCURRAIS");
        if (currais.isEmpty())
            System.out.println("Nenhum curral cadastrado.");
        for (Curral curral : currais)
            System.out.println(curral);

        System.out.println("\n\tCAMPEIROS");
        if (campeiros.isEmpty())
            System.out.println("Nenhum campeiro cadastrado.");
        for (Campeiro campeiro : campeiros)
            System.out.println(campeiro);

        System.out.println("\n\tANIMAIS (CADASTRO GERAL)");
        if (animais.isEmpty())
            System.out.println("Nenhum animal cadastrado.");
        for (Animal animal : animais)
            System.out.println(animal);

        System.out.println("\n\tREMÉDIOS");
        if (remedios.isEmpty())
            System.out.println("Nenhum remédio cadastrado.");
        for (Remedio remedio : remedios)
            System.out.println(remedio);
    }

    @Override
    public String toString() {
        return "\nNOME: " + nome +
                "\nIDADE DA FAZENDA: " + idadeFazenda +
                "\nDONO: " + donoFazenda;
    }

}
