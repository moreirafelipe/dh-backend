package com.example.clinica_odontologica_2.service.impl;

import com.example.clinica_odontologica_2.model.Dentista;
import com.example.clinica_odontologica_2.repository.impl.DentistaRepositoryImpl;
import com.example.clinica_odontologica_2.service.OdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DentistaServiceImpl implements OdontoService<Dentista> {

    @Autowired
    private DentistaRepositoryImpl dentistaRepository;

    @Override
    public Dentista salvar(Dentista dentista) {
        return dentistaRepository.salvar(dentista);
    }

    @Override
    public Dentista buscarPorId(Integer id) {
        return dentistaRepository.buscarPorId(id);
    }

    @Override
    public void deletar(Integer id) {}

    @Override
    public Map<Integer, Dentista> buscarTodos() {
        return null;
    }

    @Override
    public Dentista atualizar(Integer id, Dentista dentista) {
        return null;
    }
}
