package model;

public class Serie {

    private String nome;
    private String pais;
    private String link;

    public Serie(String nome, String pais, String link) {
        this.nome = nome;
        this.pais = pais;
        this.link = link;
    }

    public String getNome() {
        return nome;
    }

    public String getPais() {
        return pais;
    }

    public String getLink() {
        return link;
    }
}
