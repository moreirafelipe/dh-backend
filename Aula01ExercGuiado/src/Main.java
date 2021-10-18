public class Main {
    public static void main(String[] args) {
        IFachadaDesconto fachada = new FachadaDesconto();

        Cartao cartao = new Cartao("1234567890", "Star Bank");
        Produto produto = new Produto("Ervilhas", "Enlatado");

        System.out.println("Desconto: " + fachada.desconto(cartao, produto, 1));

        cartao.setBanco("Coiso");
        produto.setTipo("Latas");

        System.out.println("Desconto: " + fachada.desconto(cartao, produto, 1));
    }
}