package service;

import dao.IDao;
import model.Dentista;
import model.Endereco;

public class DentistaService {
    private IDao<Dentista> dentistaDao;
    public DentistaService(IDao<Dentista> dentistaDao){
        this.dentistaDao = dentistaDao;
    }

    public void buscarTodos() {dentistaDao.buscarTodos();}
    public Dentista salvar(Dentista dentista){
        return dentistaDao.salvar(dentista);
    }
}
