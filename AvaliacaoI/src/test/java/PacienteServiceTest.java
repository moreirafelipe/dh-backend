import dao.ConfiguracaoJDBC;
import dao.impl.EnderecoDaoImpl;
import dao.impl.PacienteDaoImpl;
import model.Endereco;
import model.Paciente;
import org.junit.jupiter.api.Test;
import service.EnderecoService;
import service.PacienteService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PacienteServiceTest {
    private PacienteService pacienteService = new PacienteService(new PacienteDaoImpl(), new EnderecoService(new EnderecoDaoImpl(new ConfiguracaoJDBC())));

    @Test
    public void cadastrarPaciente() {

        Endereco endereco1 = new Endereco("Rua Leila Camargo", "130A", "Trememmbé", "SP");
        Endereco endereco2 = new Endereco("Rua Francisca Camargo", "180A", "Caçapava", "MG");
        Paciente paciente1 = new Paciente("Felipe", "Moreira", "471741", LocalDate.of(1990,5,07), endereco1);
        Paciente paciente2 = new Paciente("Franciele", "Moreira", "999999", LocalDate.of(1994,5,19), endereco2);

        pacienteService.adicionar(paciente1);
        pacienteService.adicionar(paciente2);

        assertNotNull( paciente1.getId());
        assertNotNull( paciente2.getId());
    }
}
