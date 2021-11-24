import dao.ConfiguracaoJDBC;
import dao.impl.DentistaDaoImpl;
import dao.impl.EnderecoDaoImpl;
import dao.impl.PacienteDaoImpl;
import model.Dentista;
import model.Endereco;
import model.Paciente;
import org.junit.jupiter.api.Test;
import service.DentistaService;
import service.EnderecoService;
import service.PacienteService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PacienteServiceTest {
    private PacienteService pacienteService = new PacienteService(new PacienteDaoImpl(new ConfiguracaoJDBC()), new EnderecoService(new EnderecoDaoImpl(new ConfiguracaoJDBC())));
    private DentistaService dentistaService = new DentistaService(new DentistaDaoImpl(new ConfiguracaoJDBC()));

    @Test
    public void guardarPaciente(){
        Paciente paciente = new Paciente("Felipe","Moreira", "999999",  LocalDate.of(2021,3,7), new Endereco("rua das flores", 30, "Foz do Iguacu", "Paraná" ));
        pacienteService.salvar(paciente);
        assertTrue(paciente.getId() != null);
    }

    @Test
    public void pesquisarPaciente(){
        Paciente paciente = new Paciente("Franciele","Moreira", "000000",  LocalDate.of(2021,3,19), new Endereco("rua das flores", 30, "Foz do Iguacu", "Paraná" ));
        pacienteService.salvar(paciente);
        assertTrue(paciente.getId() != null);
        Paciente procurado = pacienteService.buscar(paciente.getId());
        assertTrue(procurado.getId() != null);
    }

    @Test
    public void listarDentistas() {

        Dentista dentista = new Dentista(99999, "Maria", "Ribeiro");
        Dentista dentista2 = new Dentista(88888, "Afranio", "Peixoto");
        Dentista dentista3 = new Dentista(77777, "Josefa", "Silveira");

        dentistaService.salvar(dentista);
        dentistaService.salvar(dentista2);
        dentistaService.salvar(dentista3);
        dentistaService.buscarTodos();
    }
}
