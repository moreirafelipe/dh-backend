public class Afiliado extends Vendedor{

    public Afiliado(String nome){
        super.nome = nome;
        super.PONTOS_POR_VENDA = 15;
        super.totalPontos = 0;
    }

    @Override
    public int calcularPontos() {
        super.totalPontos = super.vendas * PONTOS_POR_VENDA;
        return super.totalPontos;
    }
}
