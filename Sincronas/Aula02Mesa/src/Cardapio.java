import java.util.ArrayList;

public abstract class Cardapio {

    private String nomeCardapio;
    private double precoBase;
    private ArrayList<Item> listaItens;

    public void templateComprar(Item item) {
        montarPedido(item);
        calcularPrecoVenda();
    };

    public abstract void montarPedido(Item item);
    public abstract double calcularPrecoVenda();
}