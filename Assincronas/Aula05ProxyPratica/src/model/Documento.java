package model;

import java.util.ArrayList;

public class Documento {

    private int id;
    private String url;
    private String conteudo;
    private ArrayList<String> listaUsuarios;

    public Documento(int id, String url, String conteudo) {
        this.id = id;
        this.url = url;
        this.conteudo = conteudo;
        this.listaUsuarios = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public ArrayList getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}
