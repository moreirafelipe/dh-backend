public class Estagiario extends Vendedor{

    public Estagiario(String nome) {
        super.nome = nome;
        super.PONTOS_POR_VENDA = 5;
        super.totalPontos = 0;
    }

    public void vender(int qtdVendas){
        this.vendas += qtdVendas;
        System.out.println("O vendedor " + this.nome + " realizou " + this.vendas + " vendas.");
        // System.out.println(this.nome +" realizou "+qtdVendas + " vendas.");
    }

    public String mostrarCategoria(){
        int pontuacao = this.calcularPontos();

        if(pontuacao < 50)
            categoria = "Estagiário novato";
        else
            categoria = "Estagiário experiente";

        return "Categoria: " + this.categoria + " Nome: " + this.nome + " Total de pontos: " + this.totalPontos;
    }

    @Override
    public int calcularPontos() {
        super.totalPontos = super.vendas * PONTOS_POR_VENDA;
        return super.totalPontos;
    }
}
