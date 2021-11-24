package com.example.clinica_odonto.service.impl;

import com.example.clinica_odonto.model.Endereco;
import com.example.clinica_odonto.model.Paciente;
import com.example.clinica_odonto.service.OdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PacienteServiceImpl implements OdontoService<Paciente> {
    private static Map<Integer, Paciente> pacienteMap = new HashMap<>();
    private static Integer idGlobal = 1;

    @Autowired
    private EnderecoServiceImpl enderecoService;

    @Override
    public Paciente salvar(Paciente paciente) {
        paciente.setIdEndereco(enderecoService.salvar(paciente.getEndereco()).getId());
        paciente.setId(idGlobal);
        pacienteMap.put(idGlobal, paciente);
        idGlobal++;
        return paciente;
    }

    @Override
    public Map<Integer, Paciente> buscarTodos() {
        pacienteMap.forEach((chave, paciente) -> {
            paciente.setEndereco(enderecoService.buscarPorId(paciente.getIdEndereco()));
        });
        return pacienteMap;
    }

    @Override
    public void deletar(Integer id) {
        enderecoService.deletar(buscarPorId(id).getIdEndereco());
        pacienteMap.remove(id);
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        Paciente paciente = new Paciente();
        try{
            paciente = pacienteMap.get(id);
            paciente.setEndereco(enderecoService.buscarPorId(paciente.getIdEndereco()));
        } catch (Exception e){
            return null;
        }
        return paciente;
    }

    @Override
    public Paciente atualizar(Paciente paciente) {
        enderecoService.atualizar(paciente.getEndereco());
        pacienteMap.put(paciente.getId(), paciente);
        return paciente;
    }
}
