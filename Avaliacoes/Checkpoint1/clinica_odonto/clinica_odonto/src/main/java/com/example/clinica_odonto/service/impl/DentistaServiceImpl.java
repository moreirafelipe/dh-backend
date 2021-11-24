package com.example.clinica_odonto.service.impl;

import com.example.clinica_odonto.model.Dentista;
import com.example.clinica_odonto.service.OdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DentistaServiceImpl implements OdontoService<Dentista> {
    private static Map<Integer, Dentista> dentistaMap = new HashMap<>();
    private static Integer idGlobal = 1;

    @Autowired
    private EnderecoServiceImpl enderecoService;

    @Override
    public Dentista salvar(Dentista dentista) {
        dentista.setIdEndereco(enderecoService.salvar(dentista.getEndereco()).getId());
        dentista.setId(idGlobal);
        dentistaMap.put(idGlobal, dentista);
        idGlobal++;
        return dentista;
    }

    @Override
    public Map<Integer, Dentista> buscarTodos() {
        dentistaMap.forEach((chave, dentista) -> {
            dentista.setEndereco(enderecoService.buscarPorId(dentista.getIdEndereco()));
        });
        return dentistaMap;
    }

    @Override
    public void deletar(Integer id) {
        enderecoService.deletar(buscarPorId(id).getIdEndereco());
        dentistaMap.remove(id);
    }

    @Override
    public Dentista buscarPorId(Integer id) {
        Dentista dentista = new Dentista();
        try{
            dentista = dentistaMap.get(id);
            dentista.setEndereco(enderecoService.buscarPorId(dentista.getIdEndereco()));
        } catch (Exception e){
            return null;
        }

        return dentista;
    }

    @Override
    public Dentista atualizar(Dentista dentista) {
        enderecoService.atualizar(dentista.getEndereco());
        dentistaMap.put(dentista.getId(), dentista);
        return dentista;
    }
}
