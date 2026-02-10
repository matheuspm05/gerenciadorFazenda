package main.classes;

public class Cavalo extends Animal {

    private String cor;

    public Cavalo(int id, String nome, String idade, String peso, String cor) {
        super(id, nome, idade, peso);
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("\tINFORMAÇÕES SOBRE O CAVALO");
        System.out.println(super.toString());
        System.out.println("COR         : " + cor);

        System.out.println("\nREMÉDIOS USADOS:");
        if (getHistoricoRemedios().isEmpty()) {
            System.out.println("Nenhum");
        } else {
            for (Remedio remedio : getHistoricoRemedios()) {
                System.out.println(remedio.getNome());
            }
        }
    }

     @Override
    public String toString() {
        return """
               TIPO: CAVALO
               %s
               COR: %s
               """.formatted(super.toString(), cor);
    }

}
