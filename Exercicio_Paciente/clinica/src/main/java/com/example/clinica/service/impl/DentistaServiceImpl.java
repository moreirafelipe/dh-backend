package com.example.clinica.service.impl;

import com.example.clinica.model.Dentista;
import com.example.clinica.service.DentistaService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DentistaServiceImpl implements DentistaService {

    private Dentista dentista1 = new Dentista(1, "Felipe", "Oliveira", "A01");
    private Dentista dentista2 = new Dentista(2, "Maria", "Silva", "A02");


    @Override
    public List<Dentista> buscarTodos() {
        return Arrays.asList(dentista1, dentista2);
    }

    @Override
    public Dentista buscarPorId(Integer id) {
        List<Dentista> dentistas = Arrays.asList(dentista1, dentista2);

        return dentistas.stream().filter(dentista -> dentista.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
