package com.example.clinica.model;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class Paciente {

    private Integer id;
    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;
    private LocalDate dataCadastro;
    private Endereco endereco;
    private Dentista dentista;

    public Paciente(Integer id, String nome, String sobrenome, String email, String cpf, LocalDate dataCadastro, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cpf = cpf;
        this.dataCadastro = dataCadastro;
        this.endereco = endereco;
    }

    public Paciente(Integer id, String nome, String sobrenome, String email, String cpf, LocalDate dataCadastro, Endereco endereco, Dentista dentista) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cpf = cpf;
        this.dataCadastro = dataCadastro;
        this.endereco = endereco;
        this.dentista = dentista;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    @Override
    public String toString() {
        return " Paciente: " +
                " | Id: " + id +
                " | Nome: " + nome +
                " | Sobrenome: " + sobrenome +
                " | Email: " + email +
                " | Cpf :" + cpf +
                " | DataCadastro: " + dataCadastro +
                " | Endereco: " + endereco +
                " | Dentista: " + dentista;
    }
}
