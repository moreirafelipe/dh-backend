package com.example.clinica.service;
import com.example.clinica.model.Dentista;
import java.util.List;

public interface DentistaService {
    List<Dentista> buscarTodos();
    Dentista buscarPorId (Integer Id);
}
