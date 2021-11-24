import java.util.ArrayList;

public class CardapioAdulto extends Cardapio {

    private Item item;
    private int quantidade;
    private Embalagem embalagem;

    @Override
    public void montarPedido() {
        System.out.println("Item " + item.getNome() + " adicionado com sucesso!");

        System.out.println( "Item selecionado: " + item.getNome() +
                            "Embalagem selecionada: " + embalagem.getTipo() +
                            "Valor: R$" + item.getValor());
    }

    @Override
    public void montarPedido(Item item) {

    }

    @Override
    public double calcularPrecoVenda() {
        System.out.println("Valor do pedido: ");
        return item.getValor() * quantidade;
    }
}
