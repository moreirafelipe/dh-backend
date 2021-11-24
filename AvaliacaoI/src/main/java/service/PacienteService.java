package service;

import dao.IDao;
import model.Endereco;
import model.Paciente;

public class PacienteService {
    private IDao<Paciente> pacienteDao;
    private EnderecoService enderecoService;

    public PacienteService(IDao<Paciente> pacienteDao, EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
        this.pacienteDao = pacienteDao;
    }

    public Paciente adicionar(Paciente paciente) {
        enderecoService.adicionar(paciente.getEndereco());
        return pacienteDao.adicionar(paciente);
    }
}
