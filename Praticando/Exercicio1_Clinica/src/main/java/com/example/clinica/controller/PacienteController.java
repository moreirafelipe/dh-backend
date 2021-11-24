package com.example.clinica.controller;

import com.example.clinica.model.Paciente;
import com.example.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PacienteController {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/buscaPorEmail")
    public String buscarPorEmail(Model model) {
        Paciente paciente = pacienteService.buscarPorEmail("neideblanco@email.com");
        model.addAttribute("labelPaciente", "Dados do paciente: ");
        model.addAttribute("nome", paciente.getNome());
        model.addAttribute("sobrenome", paciente.getSobrenome());
        model.addAttribute("dentista", paciente.getDentista());

        return "index";
    }
}
