package com.example.aula23grestclinicaodonto.repository.impl;

import com.example.aula23grestclinicaodonto.dto.EnderecoDTO;
import com.example.aula23grestclinicaodonto.model.Endereco;
import com.example.aula23grestclinicaodonto.repository.IRepository;

//MESA - 16/11 - DTO - Implementar DTO no exercicio ClinicaOdonto anterior (Paciente completo)

import java.util.HashMap;
import java.util.Map;

public class EnderecoRepositoryImpl implements IRepository<Endereco> {

    private static Map<Integer, EnderecoDTO> enderecoMap = new HashMap<>();
    private static Integer idGlobal = 1;

    @Override
    public Endereco salvar(Endereco endereco) {
        endereco.setId(idGlobal);
        EnderecoDTO enderecoDTO = new EnderecoDTO(endereco);
        enderecoMap.put(idGlobal, enderecoDTO);
        idGlobal++;
        enderecoMap.containsValue(enderecoDTO);
//        enderecoMap.forEach();
        return endereco;
    }

    @Override
    public Endereco buscarPorId(Integer id) {
        Endereco endereco = new Endereco(enderecoMap.get(id));
        return endereco;
    }
}
