package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Pessoa {

    private String nome;
    private String sobrenome;
    private String RG;
    private String vacina;
    private Date data;

    public Pessoa(String nome, String sobrenome, String RG, String vacina, Date data) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.RG = RG;
        this.vacina = vacina;
        this.data = data;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getVacina() {
        return vacina;
    }

    public void setVacina(String vacina) {
        this.vacina = vacina;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
