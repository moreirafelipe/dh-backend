package com.example.clinica_odontologica_2.controller;

import com.example.clinica_odontologica_2.model.Consulta;
import com.example.clinica_odontologica_2.model.Dentista;
import com.example.clinica_odontologica_2.service.impl.ConsultaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaServiceImpl consultaService;

    @PostMapping
    public ResponseEntity salvarConsulta(@RequestBody Consulta consulta) {
        Consulta consultaRetorno = consultaService.salvar(consulta);

        if(consultaRetorno != null)
            return ResponseEntity.ok(consultaRetorno);

        return ResponseEntity.badRequest().body("Paciente e/ou dentista não encontrado");
    }
}
