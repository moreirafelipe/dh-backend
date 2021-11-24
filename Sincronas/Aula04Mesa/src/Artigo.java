import java.util.ArrayList;

public class Artigo {
    private String nome;
    private int lote;
    private int peso;
    private String embalagem;

//    Define array com valores de checagem
    protected ArrayList<Boolean> checagens;

    public Artigo(String nome, int lote, int peso, String embalagem) {
        this.nome = nome;
        this.lote = lote;
        this.peso = peso;
        this.embalagem = embalagem;
        this.checagens = new ArrayList<>();
    }

//    Define modificadores de acesso
    public String getNome() {
        return nome;
    }

    public int getLote() {
        return lote;
    }

    public int getPeso() {
        return peso;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setChecagens(Boolean checagem) {
        this.checagens.add(checagem);
    }
}
