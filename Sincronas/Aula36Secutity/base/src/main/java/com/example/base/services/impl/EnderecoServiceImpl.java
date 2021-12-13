package com.example.base.services.impl;

import com.example.base.model.EnderecoModel;
import com.example.base.persistence.entities.EnderecoEntity;
import com.example.base.persistence.repository.EnderecoRepository;
import com.example.base.services.OdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl implements OdontoService<EnderecoModel> {

    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public EnderecoModel salvar(EnderecoModel enderecoModel) {
        return new EnderecoModel(enderecoRepository.save(new EnderecoEntity(enderecoModel)));
    }

    public List<String> listarRuas() {
        return enderecoRepository.findAllRuas();
    }
}
