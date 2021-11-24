public class ApiQuantidade {

    public int desconto (int quant) {
        if(quant > 12) {
            return 15;
        }
        return 0;
    }
}
