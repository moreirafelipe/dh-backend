public class Roupa {
    private String tamanho;
    private String tipo;
    private boolean eNovo;
    private boolean importada;

    public Roupa(String tamanho, String tipo, boolean eNovo, boolean importada) {
        this.tamanho = tamanho;
        this.tipo = tipo;
        this.eNovo = eNovo;
        this.importada = importada;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getTipo() {
        return tipo;
    }
}
