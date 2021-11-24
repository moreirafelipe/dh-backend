public class ApiProduto {
    public int desconto(Produto prod) {
        if(prod.getTipo().compareTo("lata") == 0) {
            return 10;
        }
        return 0;
    }
}
