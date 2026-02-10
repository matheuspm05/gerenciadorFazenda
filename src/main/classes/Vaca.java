package main.classes;

public class Vaca extends Animal {
    private String litrosLeite;

    public Vaca(int id, String nome, String idade, String peso, String litrosLeite) {
        super(id, nome, idade, peso);
        this.litrosLeite = litrosLeite;

    }

    public String getLitrosLeite() {
        return litrosLeite;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("\tINFORMAÇÕES SOBRE A VACA");
        System.out.println(super.toString());
        System.out.println("LEITE (L)   : " + litrosLeite);

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
        return  """
                TIPO: VACA
                %s
                LEITE (L): %s
                """.formatted(super.toString(), litrosLeite);
    }
}
