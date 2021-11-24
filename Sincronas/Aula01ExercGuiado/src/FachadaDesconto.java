public class FachadaDesconto implements IFachadaDesconto{

    private ApiCartao apiCartao;
    private ApiProduto apiProduto;
    private ApiQuantidade apiQuantidade;

    public FachadaDesconto() {
        this.apiCartao = new ApiCartao();
        this.apiProduto = new ApiProduto();
        this.apiQuantidade = new ApiQuantidade();
    }

    public int desconto(Cartao cartao, Produto prod, int quantidade) {
//        int desconto = 0;
        return apiQuantidade.desconto(quantidade) + apiProduto.desconto(prod)  + apiCartao.desconto(cartao);
//        return desconto;
    }
}
