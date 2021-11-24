package service;
import dao.IDao;
import model.Paciente;

public class PacienteService {
    private IDao<Paciente> pacienteDao;
    private EnderecoService enderecoService;

    public PacienteService(IDao<Paciente> pacienteDao, EnderecoService enderecoService) {
        this.pacienteDao = pacienteDao;
        this.enderecoService = enderecoService;
    }

    public Paciente salvar (Paciente paciente){
        enderecoService.salvar(paciente.getEndereco());
        return pacienteDao.salvar(paciente);
    }

    public Paciente buscar(Integer id) {
        return pacienteDao.buscar(id);
    }
}
