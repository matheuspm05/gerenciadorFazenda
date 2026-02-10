package main;

import java.util.Scanner;
import main.classes.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DonoFazenda dono = new DonoFazenda("Matheus", "22222.22", "(28)999.999", 10000.0);
        Fazenda fazenda = new Fazenda("Fazenda Pastore", "2 anos", dono);

        // dados iniciais opcionais
        fazenda.adicionarPasto(new Pasto(1, "500m²", "Capim"));
        fazenda.adicionarCurral(new Curral(1, 10));
        fazenda.adicionarRemedio(new Remedio("Ivermectina", "10ml"));
        fazenda.adicionarRemedio(new Remedio("Vitamax", "5ml"));

        while (true) {
            System.out.println("\n==============================");
            System.out.println("   SISTEMA DA FAZENDA");
            System.out.println("==============================");
            System.out.println("1) Cadastrar Animal");
            System.out.println("2) Cadastrar Pasto");
            System.out.println("3) Cadastrar Curral");
            System.out.println("4) Listar Estrutura (geral)");
            System.out.println("5) Mover Animal -> Pasto");
            System.out.println("6) Mover Animal -> Curral");
            System.out.println("7) Mover Pasto -> Curral");
            System.out.println("8) Mover Curral -> Pasto");
            System.out.println("9) Aplicar Remédio em Animal");

            System.out.println("\n--- VISUALIZAÇÃO ---");
            System.out.println("10) Listar Animais por Pastos");
            System.out.println("11) Listar Animais por Currais");
            System.out.println("12) Listar Animais (cadastro geral + localização)");

            System.out.println("\n0) Sair");
            System.out.print("Escolha: ");

            int op = lerInt(sc);

            switch (op) {
                case 1 -> cadastrarAnimal(sc, fazenda);
                case 2 -> cadastrarPasto(sc, fazenda);
                case 3 -> cadastrarCurral(sc, fazenda);
                case 4 -> fazenda.estruturaFazenda();
                case 5 -> moverParaPasto(sc, fazenda);
                case 6 -> moverParaCurral(sc, fazenda);
                case 7 -> moverPastoParaCurral(sc, fazenda);
                case 8 -> moverCurralParaPasto(sc, fazenda);
                case 9 -> aplicarRemedio(sc, fazenda);

                case 10 -> fazenda.listarAnimaisPorPastos();
                case 11 -> fazenda.listarAnimaisPorCurrais();
                case 12 -> fazenda.listarAnimais();

                case 0 -> {
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    // ------------------ ações ------------------

    private static void cadastrarAnimal(Scanner sc, Fazenda fazenda) {
        System.out.println("\n--- CADASTRAR ANIMAL ---");
        System.out.println("1) Boi  2) Vaca  3) Cavalo");
        System.out.print("Tipo: ");
        int tipo = lerInt(sc);

        System.out.print("ID: ");
        int id = lerInt(sc);

        System.out.print("Nome: ");
        String nome = lerLinha(sc);

        System.out.print("Idade (ex: 3 anos): ");
        String idade = lerLinha(sc);

        System.out.print("Peso (ex: 380kg): ");
        String peso = lerLinha(sc);

        Animal animal;

        if (tipo == 1) {
            System.out.print("Raça: ");
            String raca = lerLinha(sc);
            animal = new Boi(id, nome, idade, peso, raca);
        } else if (tipo == 2) {
            System.out.print("Leite (ex: 15L): ");
            String leite = lerLinha(sc);
            animal = new Vaca(id, nome, idade, peso, leite);
        } else if (tipo == 3) {
            System.out.print("Cor: ");
            String cor = lerLinha(sc);
            animal = new Cavalo(id, nome, idade, peso, cor);
        } else {
            System.out.println("Tipo inválido.");
            return;
        }

        fazenda.adicionarAnimal(animal);
    }

    private static void cadastrarPasto(Scanner sc, Fazenda fazenda) {
        System.out.println("\n--- CADASTRAR PASTO ---");
        System.out.print("ID: ");
        int id = lerInt(sc);

        System.out.print("Tamanho (ex: 500m²): ");
        String tam = lerLinha(sc);

        System.out.print("Vegetação: ");
        String veg = lerLinha(sc);

        fazenda.adicionarPasto(new Pasto(id, tam, veg));
    }

    private static void cadastrarCurral(Scanner sc, Fazenda fazenda) {
        System.out.println("\n--- CADASTRAR CURRAL ---");
        System.out.print("ID: ");
        int id = lerInt(sc);

        System.out.print("Capacidade: ");
        int cap = lerInt(sc);

        fazenda.adicionarCurral(new Curral(id, cap));
    }

    private static void moverParaPasto(Scanner sc, Fazenda fazenda) {
        System.out.println("\n--- MOVER ANIMAL -> PASTO ---");
        System.out.print("ID do Animal: ");
        int animalId = lerInt(sc);

        System.out.print("ID do Pasto: ");
        int pastoId = lerInt(sc);

        fazenda.moverAnimalParaPasto(animalId, pastoId);
    }

    private static void moverParaCurral(Scanner sc, Fazenda fazenda) {
        System.out.println("\n--- MOVER ANIMAL -> CURRAL ---");
        System.out.print("ID do Animal: ");
        int animalId = lerInt(sc);

        System.out.print("ID do Curral: ");
        int curralId = lerInt(sc);

        fazenda.moverAnimalParaCurral(animalId, curralId);
    }

    private static void moverPastoParaCurral(Scanner sc, Fazenda fazenda) {
        System.out.println("\n--- MOVER PASTO -> CURRAL ---");
        System.out.print("ID do Animal: ");
        int animalId = lerInt(sc);

        System.out.print("ID do Pasto: ");
        int pastoId = lerInt(sc);

        System.out.print("ID do Curral: ");
        int curralId = lerInt(sc);

        fazenda.moverAnimalDoPastoParaCurral(animalId, pastoId, curralId);
    }

    private static void moverCurralParaPasto(Scanner sc, Fazenda fazenda) {
        System.out.println("\n--- MOVER CURRAL -> PASTO ---");
        System.out.print("ID do Animal: ");
        int animalId = lerInt(sc);

        System.out.print("ID do Curral: ");
        int curralId = lerInt(sc);

        System.out.print("ID do Pasto: ");
        int pastoId = lerInt(sc);

        fazenda.moverAnimalDoCurralParaPasto(animalId, curralId, pastoId);
    }

    private static void aplicarRemedio(Scanner sc, Fazenda fazenda) {
        System.out.println("\n--- APLICAR REMÉDIO ---");
        System.out.print("ID do Animal: ");
        int animalId = lerInt(sc);

        Animal animal = null;
        for (Animal a : fazenda.getAnimais()) {
            if (a.getId() == animalId) {
                animal = a;
                break;
            }
        }

        if (animal == null) {
            System.out.println("Animal não encontrado.");
            return;
        }

        if (fazenda.getRemedios().isEmpty()) {
            System.out.println("Nenhum remédio cadastrado.");
            return;
        }

        System.out.println("Remédios cadastrados:");
        for (int i = 0; i < fazenda.getRemedios().size(); i++) {
            System.out.println((i + 1) + ") " + fazenda.getRemedios().get(i));
        }

        System.out.print("Escolha o número do remédio: ");
        int idx = lerInt(sc) - 1;

        if (idx < 0 || idx >= fazenda.getRemedios().size()) {
            System.out.println("Remédio inválido.");
            return;
        }

        Remedio r = fazenda.getRemedios().get(idx);
        animal.aplicarRemedio(r);
    }

    // ------------------ utilidades ------------------

    private static int lerInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            sc.nextLine();
            System.out.print("Digite um número: ");
        }
        int v = sc.nextInt();
        sc.nextLine(); // limpa \n
        return v;
    }

    private static String lerLinha(Scanner sc) {
        String s = sc.nextLine();
        while (s.isBlank()) s = sc.nextLine();
        return s.trim();
    }
}
