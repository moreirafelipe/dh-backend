package com.example.clinica.controller;

import com.example.clinica.model.Dentista;
import com.example.clinica.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DentistaController{

    private final DentistaService dentistaService;

    @Autowired
    public DentistaController(DentistaService dentistaService) {
        this.dentistaService = dentistaService;
    }

    @GetMapping("/buscaPorId")
    public String buscarPorId(Model model){
        Dentista dentista = dentistaService.buscarPorId(2);
        model.addAttribute("matricula", dentista.getMatricula());
        model.addAttribute("paciente", dentista.getPaciente());
        model.addAttribute("labelDentista", "Id do dentista: ");

        return "index";
    }
}
