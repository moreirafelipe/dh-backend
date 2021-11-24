package com.dh.ecommerce.service;

import com.dh.ecommerce.model.Endereco;
import com.dh.ecommerce.model.Cartao;

public interface ICompraService {

    public void processarCompra(String produtoId, Integer quantidade, Cartao cartao, Endereco endereco);
}
