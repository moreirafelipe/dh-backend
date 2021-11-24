package com.example.clinica_odontologica_2.service.impl;

import com.example.clinica_odontologica_2.model.Consulta;
import com.example.clinica_odontologica_2.repository.impl.ConsultaRepositoryImpl;
import com.example.clinica_odontologica_2.service.OdontoService;
import org.springframework.stereotype.Service;

@Service
public class ConsultaServiceImpl  implements OdontoService<Consulta> {
    private ConsultaRepositoryImpl consultaRepository;

    public ConsultaServiceImpl() {
        this.consultaRepository = new ConsultaRepositoryImpl();
    }

    @Override
    public Consulta salvar(Consulta consulta) {
        return consultaRepository.salvar(consulta);
    }

    @Override
    public Consulta buscarPorId(Integer id) {
        return null;
    }
}
