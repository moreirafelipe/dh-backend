//MVC -> O service é a camada de view
package Service;

import Model.Medicamento;
import dao.IDao;

public class MedicamentoService {
    private IDao<Medicamento> medicamentoDao;

    public MedicamentoService(IDao<Medicamento> medicamentoDao) {
        this.medicamentoDao = medicamentoDao;
    }

    public Medicamento salvar(Medicamento medicamento){
        return medicamentoDao.salvar(medicamento);
    }
}
