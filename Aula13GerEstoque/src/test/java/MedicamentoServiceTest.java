import Model.Medicamento;
import Service.MedicamentoService;
import dao.ConfiguracaoJDBC;
import dao.impl.MedicamentoDaoImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MedicamentoServiceTest {

    private MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDaoImpl(new ConfiguracaoJDBC()));

    @Test
    public void guardarMedicamento(){
        Medicamento medicamento = new Medicamento(1234567890, "Ibuprofeno", "Labt", 1000, 20.0);
        medicamentoService.salvar(medicamento);
        assertTrue(medicamento.getId() != null);
    }
}
