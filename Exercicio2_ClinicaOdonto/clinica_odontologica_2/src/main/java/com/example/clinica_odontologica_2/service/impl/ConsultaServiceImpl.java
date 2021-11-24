package com.example.clinica_odontologica_2.service.impl;

import com.example.clinica_odontologica_2.model.Consulta;
import com.example.clinica_odontologica_2.model.Dentista;
import com.example.clinica_odontologica_2.repository.impl.ConsultaRepositoryImpl;
import com.example.clinica_odontologica_2.repository.impl.DentistaRepositoryImpl;
import com.example.clinica_odontologica_2.service.OdontoService;

public class ConsultaServiceImpl implements OdontoService<Consulta> {

    private ConsultaRepositoryImpl consultaRepository;

    public ConsultaServiceImpl(ConsultaRepositoryImpl consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @Override
    public Consulta salvar(Consulta consulta) {
        return consultaRepository.salvar(consulta);
    }

    @Override
    public Consulta buscarPorId(Integer id) {
        return consultaRepository.buscarPorId(id);
    }
}
