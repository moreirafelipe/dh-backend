
//validação que usa propriedades de subclasse apenas!!
//Classe abstrata Vendedor - aqui vai o Template Method
public abstract class Vendedor {
    protected String nome;
    protected int vendas = 0;
    protected int PONTOS_POR_VENDA;
    protected int totalPontos;
    protected String categoria;

    public void vender(int qtdVendas){
        this.vendas += qtdVendas;
        System.out.println("O vendedor " + this.nome + " realizou " + this.vendas + " vendas.");
       // System.out.println(this.nome +" realizou "+qtdVendas + " vendas.");
    }

    /*Método que calcula os pontos do Vendedor de acordo com seus aspectos a serem considerados*/
    public abstract int calcularPontos();

    /*TEMPLATE METHOD - recebe o total de pontos calculados a partir da subclasse e valida cada item para retornar a categoria*/
    public String mostrarCategoria(){
        int pontuacao = this.calcularPontos();

        if(pontuacao < 20)
            categoria = "Novato";
         else if(pontuacao <= 30)
            categoria = "Aprendiz";
         else if (pontuacao <= 40)
            categoria = "Bom";
         else
            categoria = "Mestre";

        return "Categoria: " + this.categoria + " Nome: " + this.nome + " Total de pontos: " + this.totalPontos;
    }
}





