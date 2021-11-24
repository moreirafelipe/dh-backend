public class Roupa {
    private String tamanho;
    private String tipo;
    private boolean eNovo;
    private boolean importada;

    public Roupa(String tipo, String tamanho, boolean eNovo, boolean importada) {
        this.tamanho = tamanho;
        this.tipo = tipo;
        this.eNovo = eNovo;
        this.importada = importada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void seteNovo(boolean eNovo) {
        this.eNovo = eNovo;
    }

    public void setImportada(boolean importada) {
        this.importada = importada;
    }

    @Override
    public String toString() {
        return "Tipo " + tipo + " | Tamanho: " + tamanho + " | É nova? " + eNovo + " | Importada: " + importada;
    }
}
