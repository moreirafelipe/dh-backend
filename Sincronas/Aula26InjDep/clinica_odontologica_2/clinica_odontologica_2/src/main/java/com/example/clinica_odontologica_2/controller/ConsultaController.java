package com.example.clinica_odontologica_2.controller;

import com.example.clinica_odontologica_2.model.Consulta;
import com.example.clinica_odontologica_2.model.Dentista;
import com.example.clinica_odontologica_2.service.impl.ConsultaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaServiceImpl consultaService;

    @PostMapping
    public ResponseEntity salvarConsulta(@RequestBody Consulta consulta) {
        Consulta consultaPost = consultaService.salvar(consulta);

        if(consultaPost == null)
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(consultaPost);
    }

    @GetMapping
    public ResponseEntity<Map<Integer, Consulta>> buscarTodos() {
        return ResponseEntity.ok(consultaService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarConsultaPorId(@PathVariable Integer id) {
        Consulta consultaBuscaId = consultaService.buscarPorId(id);
        if(consultaBuscaId == null)
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(consultaBuscaId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> atualizar(@PathVariable Integer id, @RequestBody Consulta consulta) {
        return ResponseEntity.ok(consultaService.atualizar(id, consulta));
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id) {
        consultaService.deletar(id);
        return "Consulta excluida com sucesso!";
    }
}
