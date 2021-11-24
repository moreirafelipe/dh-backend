package com.dh.ecommerce.service.impl;

import com.dh.ecommerce.model.Endereco;
import com.dh.ecommerce.model.Produto;

import java.util.List;

public class EnvioService {

    public void processarEnvio(List<Produto> produtos, Endereco endereco){
        System.out.println("Enviando produtos a " + endereco.getRua() +" "+ endereco.getNro() +","+ endereco.getBairro());
    }
}
