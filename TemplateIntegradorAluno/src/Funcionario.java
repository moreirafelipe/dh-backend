import java.util.ArrayList;

public class Funcionario extends Vendedor {

    private int anosAntiguidade;
    private ArrayList<Vendedor> afiliados;

    public Funcionario(String nome, int anosAntiguidade){
        super.nome = nome;
        super.PONTOS_POR_VENDA = 5;
        super.totalPontos = 0;
        this.anosAntiguidade = anosAntiguidade;
        this.afiliados = new ArrayList<>();
    }

     /*agrega um afiliado ao funcionario, e por sua vez soma os pontos*/
     public void addAfiliado(Vendedor afiliado){
        this.afiliados.add(afiliado);
         System.out.println("Afiliado " + afiliado.nome + " adicionado.");
        //System.out.println(afiliado.nome+ " agora é afiliado de "+super.nome);
     }

    /*implementação do método abstrato*/
    /*por cada ano de antiguidade obtem 5 pontos, por cada afiliado obtem 5*/
    @Override
    public int calcularPontos() {
        super.totalPontos = ((this.afiliados.size()*10) + (this.anosAntiguidade*5) + (vendas * this.PONTOS_POR_VENDA));
        return super.totalPontos;
    }
}
