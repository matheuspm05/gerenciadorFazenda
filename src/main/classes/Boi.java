package main.classes;

public class Boi extends Animal {
    private String tipo;

    public Boi(int id, String nome, String idade, String peso, String tipo) {
        super(id, nome, idade, peso);
        this.tipo = tipo;

    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("\tINFORMAÇOES SOBRE O BOI");

        System.out.println(super.toString());
        System.out.println("RAÇA        : " + tipo);

        System.out.println("\nREMEDIOS USADOS:");
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
        return  """
                TIPO: BOI
                %s
                RAÇA: %s
                """.formatted(super.toString(), tipo);
    }
}
